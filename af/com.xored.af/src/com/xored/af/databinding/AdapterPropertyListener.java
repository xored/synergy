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
