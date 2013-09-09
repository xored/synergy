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
package com.xored.af.validation;

import java.util.List;

import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;

public class ArgumentsEObject extends DynamicEObjectImpl {
    private final List<String> arguments;

    public ArgumentsEObject(List<String> arguments) {
        this.arguments = arguments;
    }

    public String toMarkerString() {
        final StringBuilder sb = new StringBuilder();
        for (String s : arguments) {
            sb.append(s);
            sb.append('\0');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
