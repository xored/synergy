package com.xored.af.databinding;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.resource.Resource;

public abstract class ResourceValueProperty extends NotifierValueProperty {

    public ResourceValueProperty(final int featureId, final Object valueType) {
        super(featureId, valueType);
    }

    @Override
    public IObservableValue observe(Realm realm, Object source) {
        Assert.isLegal(source instanceof Resource, "source instanceof Resource");
        return super.observe(realm, source);
    }
}
