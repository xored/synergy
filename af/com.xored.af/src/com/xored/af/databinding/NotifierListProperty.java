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

import java.util.Collection;

import org.eclipse.core.databinding.observable.Diffs;
import org.eclipse.core.databinding.observable.list.ListDiff;
import org.eclipse.core.databinding.observable.list.ListDiffEntry;
import org.eclipse.core.databinding.property.INativePropertyListener;
import org.eclipse.core.databinding.property.ISimplePropertyListener;
import org.eclipse.core.databinding.property.SimplePropertyEvent;
import org.eclipse.core.databinding.property.list.SimpleListProperty;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;

public abstract class NotifierListProperty extends SimpleListProperty {

    private final int featureId;
    private final Object elementType;

    public NotifierListProperty(final int featureId, final Object valueType) {
        this.featureId = featureId;
        this.elementType = valueType;
    }

    public Object getElementType() {
        return elementType;
    }

    @Override
    public INativePropertyListener adaptListener(final ISimplePropertyListener listener) {
        return new AdapterPropertyListener() {

            @Override
            protected Adapter createAdapter(final Notifier notifier) {
                return new AdapterImpl() {
                    @Override
                    public void notifyChanged(Notification msg) {
                        if (featureId == msg.getFeatureID(notifier.getClass()) && !msg.isTouch()) {
                            final ListDiff diff;
                            switch (msg.getEventType()) {
                            case Notification.ADD: {
                                diff = Diffs.createListDiff(Diffs.createListDiffEntry(msg.getPosition(),
                                    true, msg.getNewValue()));
                                break;
                            }
                            case Notification.ADD_MANY: {
                                Collection<?> newValues = (Collection<?>) msg.getNewValue();
                                ListDiffEntry[] listDiffEntries = new ListDiffEntry[newValues.size()];
                                int position = msg.getPosition();
                                int index = 0;
                                for (Object newValue : newValues) {
                                    listDiffEntries[index++] = Diffs.createListDiffEntry(position++, true,
                                        newValue);
                                }
                                diff = Diffs.createListDiff(listDiffEntries);
                                break;
                            }
                            case Notification.REMOVE: {
                                diff = Diffs.createListDiff(Diffs.createListDiffEntry(msg.getPosition(),
                                    false, msg.getOldValue()));
                                break;
                            }
                            case Notification.REMOVE_MANY: {
                                Collection<?> oldValues = (Collection<?>) msg.getOldValue();
                                ListDiffEntry[] listDiffEntries = new ListDiffEntry[oldValues.size()];
                                int position = msg.getPosition();
                                int index = 0;
                                for (Object oldValue : oldValues) {
                                    listDiffEntries[index++] = Diffs.createListDiffEntry(position++, false,
                                        oldValue);
                                }
                                diff = Diffs.createListDiff(listDiffEntries);
                                break;
                            }
                            case Notification.SET:
                            case Notification.RESOLVE: {
                                ListDiffEntry[] listDiffEntries = new ListDiffEntry[2];
                                listDiffEntries[0] = Diffs.createListDiffEntry(msg.getPosition(), false, msg
                                    .getOldValue());
                                listDiffEntries[1] = Diffs.createListDiffEntry(msg.getPosition(), true, msg
                                    .getNewValue());
                                diff = Diffs.createListDiff(listDiffEntries);
                                break;
                            }
                            case Notification.MOVE: {
                                Object movedValue = msg.getNewValue();
                                ListDiffEntry[] listDiffEntries = new ListDiffEntry[2];
                                listDiffEntries[0] = Diffs.createListDiffEntry((Integer) msg.getOldValue(),
                                    false, movedValue);
                                listDiffEntries[1] = Diffs.createListDiffEntry(msg.getPosition(), true,
                                    movedValue);
                                diff = Diffs.createListDiff(listDiffEntries);
                                break;
                            }
                            case Notification.UNSET: {
                                // This just represents going back to the unset
                                // state,
                                // but that doesn't affect the contents of the
                                // list.
                                //
                                return;
                            }
                            default: {
                                throw new RuntimeException("unhandled case");
                            }
                            }
                            listener.handleEvent(new SimplePropertyEvent(SimplePropertyEvent.CHANGE,
                                notifier, NotifierListProperty.this, diff));
                        }
                    }
                };
            }
        };
    }
}
