package com.xored.af.databinding;

import org.eclipse.core.databinding.observable.Diffs;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.ValueDiff;
import org.eclipse.core.databinding.property.INativePropertyListener;
import org.eclipse.core.databinding.property.ISimplePropertyListener;
import org.eclipse.core.databinding.property.SimplePropertyEvent;
import org.eclipse.core.databinding.property.value.SimpleValueProperty;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;

public abstract class NotifierValueProperty extends SimpleValueProperty {

    private final int featureId;
    private final Object valueType;

    public NotifierValueProperty(final int featureId, final Object valueType) {
        this.featureId = featureId;
        this.valueType = valueType;
    }

    public Object getValueType() {
        return valueType;
    }

    @Override
    public INativePropertyListener adaptListener(final ISimplePropertyListener listener) {
        return new AdapterPropertyListener() {

            @Override
            protected Adapter createAdapter(final Notifier notifier) {
                return new AdapterImpl() {
                    @Override
                    public void notifyChanged(Notification msg) {
                        if (msg.getFeatureID(notifier.getClass()) == featureId && !msg.isTouch()) {
                            final ValueDiff diff = Diffs
                                .createValueDiff(msg.getOldValue(), msg.getNewValue());
                            listener.handleEvent(new SimplePropertyEvent(SimplePropertyEvent.STALE, notifier,
                                NotifierValueProperty.this, diff));
                            listener.handleEvent(new SimplePropertyEvent(SimplePropertyEvent.CHANGE,
                                notifier, NotifierValueProperty.this, diff));
                        }
                    }
                };
            }
        };
    }

    @Override
    public IObservableValue observe(Realm realm, Object source) {
        Assert.isLegal(source instanceof Notifier, "source instanceof Notifier");
        return super.observe(realm, source);
    }
}
