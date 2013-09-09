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
package com.xored.af.builds;

import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;

import com.xored.af.internal.BuilderSpec;

public abstract class EmfProjectNature implements IProjectNature {
    private final BuilderSpec builderSpec;

    public EmfProjectNature(final String builderId) {
        builderSpec = new BuilderSpec(builderId);
    }

    public void configure() throws CoreException {
        builderSpec.addToBuildSpec(getProject());
    }

    public void deconfigure() throws CoreException {
        builderSpec.removeFromBuildSpec(getProject());
    }
}
