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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.xored.af.validation.EmfDiagnostic;

public class NonContainingEObjectDecorator extends EObjectDecorator {

    @Override
    protected boolean isDiagnosticRelevant(EObject eobject, EmfDiagnostic diagnostic) {
        return diagnostic.getObject() == eobject;
    }

    @Override
    protected Collection<?> getRelevantObjects(EmfDiagnostic diagnostic, final Resource resource) {
        final List<EObject> objects = new ArrayList<EObject>();
        if (diagnostic.getObject() != null) {
            objects.add(diagnostic.getObject());
        }
        objects.addAll(diagnostic.getLocus());
        return objects;
    }
}
