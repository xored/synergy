package com.xored.af.ui.forms.parts;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.xored.af.ui.forms.FeatureUIDescriptor;

public class CheckboxFormPart extends FeatureFormPart {
    private final Button control;

    public CheckboxFormPart(final FormToolkit toolkit, final Composite parent, final FeatureUIDescriptor ui,
        final IValueProperty property) {
        super(ui, property);

        control = toolkit.createButton(parent, ui.label, SWT.CHECK);
        control.setToolTipText(ui.tooltip);
        GridDataFactory.swtDefaults().align(SWT.FILL, SWT.CENTER).grab(true, false).span(2, 1).applyTo(
            control);
    }

    public Button getControl() {
        return control;
    }

    @Override
    public void setFocus() {
        control.setFocus();
    }

    @Override
    protected IObservableValue observeControl() {
        return SWTObservables.observeDelayedValue(400, SWTObservables.observeSelection(control));
    }
}
