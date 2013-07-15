package com.xored.af.ui.labels;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

import org.eclipse.core.databinding.observable.IObserving;
import org.eclipse.core.databinding.observable.list.IListChangeListener;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.ListChangeEvent;
import org.eclipse.core.databinding.observable.list.ListDiffVisitor;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;

import com.xored.af.databinding.ResourceProperties;
import com.xored.af.ui.LabelProviderUpdateHandler;
import com.xored.af.ui.UIEventGroup;
import com.xored.af.ui.internal.AfUiPlugin;
import com.xored.af.validation.EmfDiagnostic;
import com.xored.af.validation.SimpleDiagnostic;

public abstract class EObjectDecorator extends LabelProvider implements ILightweightLabelDecorator {
    private class DiagnosticsListener implements IListChangeListener {

        public void handleListChange(final ListChangeEvent event) {
            final Set<Object> toUpdate = new HashSet<Object>();
            event.diff.accept(new ListDiffVisitor() {

                @Override
                public void handleRemove(final int index, final Object element) {
                    update(element);
                }

                @Override
                public void handleAdd(final int index, final Object element) {
                    update(element);
                }

                private void update(final Object o) {
                    if (o instanceof EmfDiagnostic) {
                        final EmfDiagnostic diagnostic = (EmfDiagnostic) o;
                        final IObservableList list = event.getObservableList();
                        final Resource resource = (Resource) ((IObserving) list).getObserved();
                        final Collection<? extends Object> relevant = getRelevantObjects(diagnostic, resource);
                        toUpdate.addAll(relevant);
                    }
                }
            });
            if (!toUpdate.isEmpty()) {
                updates.post(new LabelProviderChangedEvent(EObjectDecorator.this, toUpdate.toArray()));
            }
        }
    }

    protected final Map<Object, Object> decoratedList = new WeakHashMap<Object, Object>(100);

    private static final int DEFAULT_RESOURCE_COUNT = 32;
    private final Map<Resource, IObservableList> errors = new HashMap<Resource, IObservableList>(
        DEFAULT_RESOURCE_COUNT);
    private final Map<Resource, IObservableList> warns = new HashMap<Resource, IObservableList>(
        DEFAULT_RESOURCE_COUNT);
    private final Map<Resource, IObservableValue> resourceSets = new HashMap<Resource, IObservableValue>(
        DEFAULT_RESOURCE_COUNT);

    private final DiagnosticsListener diagListener = new DiagnosticsListener();

    public void decorate(final Object element, final IDecoration decoration) {
        if (element instanceof EObject) {
            try {
                decoratedList.put(element, null);
                doDecorate((EObject) element, decoration);
            } catch (final Exception e) {
                AfUiPlugin.getDefault().warn(e);
            }
        }
    }

    private void doDecorate(final EObject eobject, final IDecoration decoration) {
        final Resource resource = eobject.eResource();
        if (resource == null) {
            return;
        }

        // iterate over copies to avoid concurrency issues
        for (final Diagnostic d : new ArrayList<Diagnostic>(resource.getErrors())) {
            if (d instanceof EmfDiagnostic) {
                final EmfDiagnostic diag = (EmfDiagnostic) d;
                try {
                    if (isDiagnosticRelevant(eobject, diag)) {
                        decoration.addOverlay(AfUiPlugin.OVR_ERROR);
                        ensureIsObserved(resource);
                        return;
                    }
                } catch (final Exception e) {
                    AfUiPlugin.getDefault().warn(e);
                }
            } else if (d instanceof SimpleDiagnostic) {
                final SimpleDiagnostic diag = (SimpleDiagnostic) d;
                if (diag.getLocation() != null
                    && URI.createURI(diag.getLocation()).equals(EcoreUtil.getURI(eobject).trimFragment())) {
                    decoration.addOverlay(AfUiPlugin.OVR_ERROR);
                    ensureIsObserved(resource);
                    return;
                }
            }
        }

        for (final Diagnostic d : new ArrayList<Diagnostic>(resource.getWarnings())) {
            if (d instanceof EmfDiagnostic) {
                final EmfDiagnostic diag = (EmfDiagnostic) d;
                try {
                    if (isDiagnosticRelevant(eobject, diag)) {
                        decoration.addOverlay(AfUiPlugin.OVR_WARN);
                        ensureIsObserved(resource);
                        return;
                    }
                } catch (final Exception e) {
                    AfUiPlugin.getDefault().warn(e);
                }
            }
        }
    }

    private synchronized void ensureIsObserved(final Resource resource) {
        if (resourceSets.containsKey(resource)) {
            return;
        }

        final Display display = PlatformUI.getWorkbench().getDisplay();

        if (display.isDisposed()) {
            return;
        }

        display.asyncExec(new Runnable() {

            public void run() {
                if (display.isDisposed()) {
                    return;
                }

                final IObservableValue resourceSet = ResourceProperties.resourceSet().observe(resource);
                resourceSets.put(resource, resourceSet);

                final IObservableList errors = ResourceProperties.errors().observe(resource);
                EObjectDecorator.this.errors.put(resource, errors);

                final IObservableList warns = ResourceProperties.warnings().observe(resource);
                EObjectDecorator.this.warns.put(resource, warns);

                resourceSet.addValueChangeListener(new IValueChangeListener() {

                    public void handleValueChange(final ValueChangeEvent event) {
                        stopObserving(resource);
                    }
                });

                errors.addListChangeListener(diagListener);
                warns.addListChangeListener(diagListener);
            }
        });
    }

    private synchronized void stopObserving(final Resource resource) {
        if (!resourceSets.containsKey(resource)) {
            return;
        }

        resourceSets.get(resource).dispose();
        resourceSets.remove(resource);

        errors.get(resource).dispose();
        errors.remove(resource);

        warns.get(resource).dispose();
        warns.remove(resource);
    }

    protected abstract boolean isDiagnosticRelevant(final EObject eobject, final EmfDiagnostic diagnostic);

    protected abstract Collection<?> getRelevantObjects(final EmfDiagnostic diagnostic,
        final Resource resource);

    @Override
    public void dispose() {
        for (final Resource resource : new HashSet<Resource>(resourceSets.keySet())) {
            stopObserving(resource);
        }
        super.dispose();
    }

    private final UIEventGroup<LabelProviderChangedEvent> updates = new UIEventGroup<LabelProviderChangedEvent>(
        "Updating EObjectDecorator", new LabelProviderUpdateHandler(this) {

            @Override
            protected void fireEventImmediately(LabelProviderChangedEvent event) {
                superFireLabelProviderChanged(event);
            }
        });

    @Override
    protected void fireLabelProviderChanged(final LabelProviderChangedEvent event) {
        superFireLabelProviderChanged(event);
    }

    private void superFireLabelProviderChanged(final LabelProviderChangedEvent event) {
        super.fireLabelProviderChanged(event);
    }
}
