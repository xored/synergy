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
package com.xored.af.ui.forms.parts;

import org.eclipse.core.databinding.observable.IObserving;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.xored.af.ui.forms.FeatureUIDescriptor;
import com.xored.af.ui.forms.FeatureUIDescriptor.ComboControl;

public class ComboFormPart extends FeatureFormPart {
    private final Label label;
    private final ComboViewer viewer;

    public ComboFormPart(final FormToolkit toolkit, final Composite parent, final FeatureUIDescriptor ui,
        final IValueProperty property) {

        super(ui, property);

        if (ui.label != null) {
            label = toolkit.createLabel(parent, ui.label + ":");
            label.setToolTipText(ui.tooltip);
            GridDataFactory.swtDefaults().applyTo(label);
        } else {
            label = null;
        }

        viewer = new ComboViewer(parent, SWT.READ_ONLY);
        viewer.getControl().setToolTipText(ui.tooltip);
        GridDataFactory.swtDefaults().align(SWT.FILL, SWT.CENTER).grab(true, false).applyTo(
            viewer.getControl());

        final ComboControl descriptor = (ComboControl) ui.control;
        viewer.setContentProvider(descriptor.createContentProvider());
        viewer.setLabelProvider(descriptor.createLabelProvider());
    }

    public ComboViewer getViewer() {
        return viewer;
    }

    @Override
    public void setFocus() {
        viewer.getControl().setFocus();
    }

    @Override
    protected IObservableValue observeControl() {
        if (modelObservable instanceof IObserving) {
            final IObserving observing = (IObserving) modelObservable;
            viewer.setInput(observing.getObserved());
            getEmfForm().getInput().addValueChangeListener(new IValueChangeListener() {

                public void handleValueChange(ValueChangeEvent event) {
                    viewer.setInput(event.diff.getNewValue());
                    viewer.setSelection(modelObservable.getValue() != null ? new StructuredSelection(
                        modelObservable.getValue()) : new StructuredSelection());
                }
            });
        }
        return ViewerProperties.singleSelection().observe(viewer);
    }

    @Override
    public Control getControl() {
        return viewer.getControl();
    }
}
