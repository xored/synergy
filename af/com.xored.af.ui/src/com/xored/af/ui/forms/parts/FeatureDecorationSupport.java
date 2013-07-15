package com.xored.af.ui.forms.parts;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Control;

import com.xored.af.ui.forms.EmfForm;

public class FeatureDecorationSupport {
    private FeatureDecorationSupport() {
    }

    public static void attach(final Control control, final EObject eobject, final EStructuralFeature feature) {
        attachWithQuickFix(control, eobject, feature, false);
    }

    public static void attach(final Control control, final IObservableValue eobjectObservable,
        final EStructuralFeature feature, final EmfForm form) {
        attachWithQuickFix(control, eobjectObservable, feature, form, false);
    }

    public static void attachWithQuickFix(final Control control, final EObject eobject,
        final EStructuralFeature feature, final boolean useQuickFix) {
        final ControlDecoration decoration = new ControlDecoration(control, SWT.TOP | SWT.LEFT);
        final ControlDecorationAdapter decorationAdapter = new ControlDecorationAdapter(decoration, eobject,
            feature, useQuickFix);
        decorationAdapter.install(eobject.eResource());

        control.addDisposeListener(new DisposeListener() {

            public void widgetDisposed(final DisposeEvent e) {
                decorationAdapter.uninstall();
            }
        });
    }

    public static void attachWithQuickFix(final Control control, final IObservableValue eobjectObservable,
        final EStructuralFeature feature, final EmfForm form, final boolean useQuickFix) {

        final ControlDecoration decoration = new ControlDecoration(control, SWT.TOP | SWT.LEFT);

        final EObject eobject = (EObject) eobjectObservable.getValue();
        final ControlDecorationAdapter[] decorationAdapter = new ControlDecorationAdapter[] { null };
        if (eobject != null) {
            decorationAdapter[0] = new ControlDecorationAdapter(decoration, eobject, feature, useQuickFix);
            if (eobject.eResource() != null) {
                decorationAdapter[0].install(eobject.eResource());
            }
        }

        eobjectObservable.addValueChangeListener(new IValueChangeListener() {

            public void handleValueChange(final ValueChangeEvent event) {
                if (decorationAdapter[0] != null) {
                    decorationAdapter[0].uninstall();
                }

                final EObject eobject = (EObject) event.diff.getNewValue();
                if (eobject != null && eobject.eResource() != null) {
                    decorationAdapter[0] = new ControlDecorationAdapter(decoration, eobject, feature,
                        useQuickFix);
                    decorationAdapter[0].install(eobject.eResource());
                } else {
                    decorationAdapter[0] = null;
                }
            }
        });

        control.addDisposeListener(new DisposeListener() {

            public void widgetDisposed(final DisposeEvent e) {
                if (decorationAdapter[0] != null) {
                    decorationAdapter[0].uninstall();
                }
            }
        });
    }
}
