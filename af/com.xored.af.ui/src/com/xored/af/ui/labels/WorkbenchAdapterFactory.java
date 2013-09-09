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
package com.xored.af.ui.labels;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.model.IWorkbenchAdapter;
import org.eclipse.ui.model.IWorkbenchAdapter2;
import org.eclipse.ui.model.WorkbenchAdapter;

public abstract class WorkbenchAdapterFactory implements IAdapterFactory {
    private static class AdapterFactoryWorkbenchAdapter extends WorkbenchAdapter {
        private final AdapterFactory adapterFactory;

        public AdapterFactoryWorkbenchAdapter(final AdapterFactory adapterFactory) {
            this.adapterFactory = adapterFactory;
        }

        @Override
        public ImageDescriptor getImageDescriptor(final Object object) {
            return ExtendedImageRegistry.getInstance().getImageDescriptor(
                getItemLabelProvider(object).getImage(object));
        }

        @Override
        public String getLabel(final Object object) {
            return getItemLabelProvider(object).getText(object);
        }

        private IItemLabelProvider getItemLabelProvider(final Object object) {
            return (IItemLabelProvider) adapterFactory.adapt(object, IItemLabelProvider.class);
        }
    }

    private IWorkbenchAdapter2 adapter;

    public Object getAdapter(final Object adaptableObject, final Class adapterType) {
        if (adapterType == IWorkbenchAdapter.class || adapterType == IWorkbenchAdapter2.class) {
            if (adapter == null) {
                adapter = new AdapterFactoryWorkbenchAdapter(getAdapterFactory());
            }
            return adapter;
        } else {
            return null;
        }
    }

    public Class[] getAdapterList() {
        return new Class[] { IWorkbenchAdapter.class, IWorkbenchAdapter2.class };
    }

    protected abstract AdapterFactory getAdapterFactory();
}
