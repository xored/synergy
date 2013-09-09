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
package com.xored.af.ui;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;

import com.xored.af.EventGroup;

public abstract class LabelProviderUpdateHandler implements
    EventGroup.EventHandler<LabelProviderChangedEvent> {

    private final Set<Object> objects = new HashSet<Object>();

    private final IBaseLabelProvider labelProvider;
    private final LabelProviderChangedEvent globalRefresh;

    public LabelProviderUpdateHandler(final IBaseLabelProvider labelProvider) {
        this.labelProvider = labelProvider;
        this.globalRefresh = new LabelProviderChangedEvent(labelProvider);
    }

    public HandleResult handle(final List<LabelProviderChangedEvent> events) {
        objects.clear();
        boolean global = false;

        for (final LabelProviderChangedEvent e : events) {
            if (e.getElements() == null) {
                global = true;
            }
        }

        if (global) {
            // System.out.println("[" + System.currentTimeMillis() +
            // "] firing refresh: global");
            fireEventImmediately(globalRefresh);
            return HandleResult.DONE;
        }

        for (final LabelProviderChangedEvent e : events) {
            for (final Object o : e.getElements()) {
                objects.add(o);
            }
        }

        if (!objects.isEmpty()) {
            final Object[] objectsCopy = objects.toArray();
            objects.clear();

            // System.out.println("[" + System.currentTimeMillis() +
            // "] firing refresh: "
            // + objectsCopy.length);
            fireEventImmediately(new LabelProviderChangedEvent(labelProvider, objectsCopy));
        }

        return HandleResult.DONE;
    }

    protected abstract void fireEventImmediately(final LabelProviderChangedEvent event);
}
