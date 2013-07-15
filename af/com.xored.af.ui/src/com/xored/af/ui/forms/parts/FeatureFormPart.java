package com.xored.af.ui.forms.parts;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.forms.AbstractFormPart;
import org.eclipse.ui.forms.IManagedForm;

import com.xored.af.ui.forms.EmfForm;
import com.xored.af.ui.forms.FeatureUIDescriptor;

public abstract class FeatureFormPart extends AbstractFormPart {
    protected final FeatureUIDescriptor ui;
    protected final IValueProperty property;

    protected IObservableValue input;
    protected boolean ownsInput;

    protected IObservableValue modelObservable;
    private Binding binding;

    public FeatureFormPart(final FeatureUIDescriptor ui, final IValueProperty property) {
        this.ui = ui;
        this.property = property;
    }

    @Override
    public void initialize(final IManagedForm form) {
        super.initialize(form);

        if (ownsInput && this.input != null) {
            this.input.dispose();
            this.input = null;
        }
        if (binding != null) {
            binding.dispose();
        }

        final Object input = form.getInput();
        if (input instanceof IObservableValue) {
            this.input = (IObservableValue) input;
            this.ownsInput = false;
        } else {
            this.input = new WritableValue(getEmfForm().getBindingContext().getValidationRealm(), input,
                input instanceof EObject ? ((EObject) input).eClass() : input.getClass());
            this.ownsInput = true;
        }

        this.modelObservable = property.observeDetail(this.input);

        binding = getEmfForm().getBindingContext().bindValue(observeControl(), modelObservable,
            getTargetToModelStrategy(), ui.createModelToTarget());
    }

    protected UpdateValueStrategy getTargetToModelStrategy() {
        return ui.createTargetToModel();
    }

    protected EmfForm getEmfForm() {
        return (EmfForm) getManagedForm();
    }

    protected abstract IObservableValue observeControl();

    public abstract Control getControl();

    public Binding getBinding() {
        return binding;
    }

    public IObservableValue getModelObservable() {
        return modelObservable;
    }
}
