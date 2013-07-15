package com.xored.af.databinding;

import org.eclipse.core.databinding.property.INativePropertyListener;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

public abstract class AdapterPropertyListener implements INativePropertyListener {
    private Adapter adapter;

    public void removeFrom(Object source) {
        final Notifier notifier = (Notifier) source;
        notifier.eAdapters().remove(adapter);
    }

    public void addTo(final Object source) {
        final Notifier notifier = (Notifier) source;
        notifier.eAdapters().add(adapter = createAdapter(notifier));
    }

    protected abstract Adapter createAdapter(Notifier notifier);
}
