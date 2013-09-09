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
