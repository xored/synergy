package com.xored.af.ui.forms.parts;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.xored.af.ui.forms.EmfForm;
import com.xored.af.ui.forms.FeatureUIDescriptor;

public class TextFormPart extends FeatureFormPart {
    private final Label label;
    private final Text text;

    public TextFormPart(final EmfForm form, final Composite parent, final FeatureUIDescriptor ui,
        final IValueProperty property) {

        super(ui, property);

        if (ui.label != null) {
            label = form.getToolkit().createLabel(parent, ui.label + ":");
            label.setToolTipText(ui.tooltip);
            GridDataFactory.swtDefaults().applyTo(label);
        } else {
            label = null;
        }

        text = form.getToolkit().createText(parent, "");
        text.setToolTipText(ui.tooltip);
        GridDataFactory.swtDefaults().align(SWT.FILL, SWT.CENTER).grab(true, false).applyTo(text);

        FeatureDecorationSupport.attach(text, form.getInput(), ui.feature, form);
    }

    @Override
    public Text getControl() {
        return text;
    }

    @Override
    public void setFocus() {
        text.setFocus();
    }

    @Override
    protected IObservableValue observeControl() {
        return SWTObservables.observeDelayedValue(400, SWTObservables.observeText(text, SWT.Modify));
    }
}
