/*******************************************************************************
 * Copyright (c) 2010-2013 xored software, Inc.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     xored software, Inc. - initial API and Implementation (Igor Zapletnev)
 *******************************************************************************/
package com.xored.af.ui.forms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.ValidationStatusProvider;
import org.eclipse.core.databinding.observable.list.IListChangeListener;
import org.eclipse.core.databinding.observable.list.ListChangeEvent;
import org.eclipse.core.databinding.observable.list.ListDiffVisitor;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.IFormPart;
import org.eclipse.ui.forms.ManagedForm;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;

import com.xored.af.ui.forms.FeatureUIDescriptor.CheckboxControl;
import com.xored.af.ui.forms.FeatureUIDescriptor.ComboControl;
import com.xored.af.ui.forms.FeatureUIDescriptor.TextControl;
import com.xored.af.ui.forms.parts.CheckboxFormPart;
import com.xored.af.ui.forms.parts.ComboFormPart;
import com.xored.af.ui.forms.parts.FeatureFormPart;
import com.xored.af.ui.forms.parts.TextFormPart;

public class EmfForm extends ManagedForm {

    private EMFDataBindingContext bindings;
    private final List<FeatureUIDescriptor> uiDescriptors = new ArrayList<FeatureUIDescriptor>();
    private IFormPart initialFocus;

    private class StatusListener implements IValueChangeListener {
        private final ValidationStatusProvider binding;

        public StatusListener(final ValidationStatusProvider binding) {
            this.binding = binding;
        }

        public void handleValueChange(final ValueChangeEvent event) {
            final FeatureFormPart part = findPart();
            if (part != null) {
                final IStatus oldStatus = (IStatus) event.diff.getOldValue();
                if (!oldStatus.isOK()) {
                    getMessageManager().removeMessage(oldStatus, part.getControl());
                }

                final IStatus status = (IStatus) event.diff.getNewValue();
                if (status == null || status.isOK()) {
                    return;
                }

                final int type;
                switch (status.getSeverity()) {
                case IStatus.ERROR:
                    type = IMessageProvider.ERROR;
                    break;
                case IStatus.WARNING:
                    type = IMessageProvider.WARNING;
                    break;
                default:
                    type = IMessageProvider.INFORMATION;
                    break;
                }
                getMessageManager().addMessage(status, status.getMessage(), status, type, part.getControl());
            }
        }

        private FeatureFormPart findPart() {
            for (final IFormPart part : getParts()) {
                if (part instanceof FeatureFormPart) {
                    final FeatureFormPart featurePart = (FeatureFormPart) part;
                    if (featurePart.getModelObservable() == binding.getModels().get(0)) {
                        return featurePart;
                    }
                }
            }
            return null;
        }
    };

    private final IListChangeListener statusProvidersListener = new IListChangeListener() {

        public void handleListChange(final ListChangeEvent event) {
            event.diff.accept(new ListDiffVisitor() {

                @Override
                public void handleRemove(final int index, final Object element) {
                }

                @Override
                public void handleAdd(final int index, final Object element) {
                    final ValidationStatusProvider provider = (ValidationStatusProvider) element;
                    provider.getValidationStatus().addValueChangeListener(new StatusListener(provider));
                }
            });
        }
    };

    public EmfForm(final Composite parent) {
        super(parent);

        getMessageManager().setDecorationPosition(SWT.LEFT | SWT.TOP);
        bindings = new EMFDataBindingContext();
        bindings.getValidationStatusProviders().addListChangeListener(statusProvidersListener);

        parent.addDisposeListener(new DisposeListener() {

            public void widgetDisposed(final DisposeEvent e) {
                bindings.dispose();
            }
        });
    }

    public EmfForm(final FormToolkit toolkit, final ScrolledForm form) {
        super(toolkit, form);

        getMessageManager().setDecorationPosition(SWT.LEFT | SWT.TOP);
        bindings = new EMFDataBindingContext();
        bindings.getValidationStatusProviders().addListChangeListener(statusProvidersListener);

        form.addDisposeListener(new DisposeListener() {

            public void widgetDisposed(final DisposeEvent e) {
                dispose();
            }
        });
    }

    public void register(final FeatureUIDescriptor descriptor) {
        uiDescriptors.add(descriptor);
    }

    public void registerAll(final Collection<FeatureUIDescriptor> descriptors) {
        uiDescriptors.addAll(descriptors);
    }

    public void setInitialFocus(final IFormPart part) {
        initialFocus = part;
    }

    public DataBindingContext getBindingContext() {
        return bindings;
    }

    public IFormPart addPart(final IValueProperty property) {
        return addPart(property, getForm().getBody());
    }

    public IFormPart addPart(final IValueProperty property, final Composite parent) {
        FeatureUIDescriptor uiDescriptor = null;
        if (property.getValueType() instanceof EStructuralFeature) {
            uiDescriptor = getIUDescriptor((EStructuralFeature) property.getValueType());
        }

        if (uiDescriptor == null) {
            throw new IllegalArgumentException("Unable to derive UI descriptor from property type: "
                + property.getValueType());
        }

        final IFormPart part = createPart(uiDescriptor, property, parent, getInput().getValue());
        if (part != null) {
            addPart(part);
        }
        return part;
    }

    /**
     * @param feature
     *            feature to return UI descriptor for
     * @return UI descriptor for specific feature
     */
    protected FeatureUIDescriptor getIUDescriptor(final EStructuralFeature feature) {
        for (final FeatureUIDescriptor uiDescriptor : uiDescriptors) {
            if (uiDescriptor.feature == feature && uiDescriptor.applicable((EObject) getInput().getValue())) {
                return uiDescriptor;
            }
        }
        return null;
    }

    @Override
    public void dispose() {
        if (bindings != null) {
            bindings.dispose();
        }
        super.dispose();
    }

    protected IFormPart createPart(final FeatureUIDescriptor uiDescriptor, final IValueProperty property,
        final Composite parent, final Object object) {
        IFormPart part = null;
        if (uiDescriptor.control instanceof TextControl) {
            part = new TextFormPart(this, parent, uiDescriptor, property);
        } else if (uiDescriptor.control instanceof CheckboxControl) {
            part = new CheckboxFormPart(getToolkit(), parent, uiDescriptor, property);
        } else if (uiDescriptor.control instanceof ComboControl) {
            part = new ComboFormPart(getToolkit(), parent, uiDescriptor, property);
        }
        return part;
    }

    public void setBindingContext(final EMFDataBindingContext dbc) {
        // TODO: why does not work?
        // if (statuses != null) {
        // statuses.dispose();
        // statuses = null;
        // }

        this.bindings = dbc;

        bindings.getValidationStatusProviders().addListChangeListener(statusProvidersListener);
        for (final Object o : bindings.getValidationStatusProviders()) {
            final ValidationStatusProvider binding = (ValidationStatusProvider) o;
            binding.getValidationStatus().addValueChangeListener(new StatusListener(binding));
        }
    }

    @Override
    public void setFocus() {
        if (initialFocus != null) {
            initialFocus.setFocus();
        } else {
            super.setFocus();
        }
    }

    @Override
    public IObservableValue getInput() {
        return (IObservableValue) super.getInput();
    }
}