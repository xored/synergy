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
package com.xored.af.ui.databinding;

import org.eclipse.core.databinding.observable.Diffs;
import org.eclipse.core.databinding.property.INativePropertyListener;
import org.eclipse.core.databinding.property.ISimplePropertyListener;
import org.eclipse.core.databinding.property.SimplePropertyEvent;
import org.eclipse.core.databinding.property.value.SimpleValueProperty;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPropertyListener;

/**
 * If you want to be able to set the value of this propery, you have to pass
 * {@link DirtyMarkableEditor} to observe(). If you want to use this property
 * for reading only, you can go with just {@link IEditorPart}
 */
public class EditorDirtyProperty extends SimpleValueProperty {
    public interface DirtyMarkableEditor extends IEditorPart {
        /**
         * Implementers are advised to not rely on this method to be called in
         * UI thread.
         * 
         * @param dirty
         */
        public void setDirty(boolean dirty);
    }

    @Override
    public INativePropertyListener adaptListener(final ISimplePropertyListener listener) {
        return new INativePropertyListener() {
            private IPropertyListener propListener;

            public void removeFrom(Object source) {
                final IEditorPart part = (IEditorPart) source;
                part.removePropertyListener(propListener);
            }

            public void addTo(Object source) {
                final IEditorPart part = (IEditorPart) source;
                part.addPropertyListener(propListener = new IPropertyListener() {

                    public void propertyChanged(Object source, int propId) {
                        if (propId == IEditorPart.PROP_DIRTY) {
                            final boolean newValue = part.isDirty();
                            listener.handleEvent(new SimplePropertyEvent(SimplePropertyEvent.CHANGE, source,
                                EditorDirtyProperty.this, Diffs.createValueDiff(null, newValue)));
                        }
                    }
                });
            }
        };
    }

    @Override
    protected Object doGetValue(Object source) {
        final IEditorPart editor = (IEditorPart) source;
        return editor.isDirty();
    }

    @Override
    protected void doSetValue(Object source, Object value) {
        final DirtyMarkableEditor editor = (DirtyMarkableEditor) source;
        editor.setDirty((Boolean) value);
    }

    public Object getValueType() {
        return Boolean.class;
    }
}
