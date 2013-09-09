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

import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

public class BuildWorkspaceJob extends WorkspaceJob {
    private final boolean fullBuild;

    public BuildWorkspaceJob(boolean fullBuild) {
        super("Build workspace");
        this.fullBuild = fullBuild;
        setUser(true);
        setRule(ResourcesPlugin.getWorkspace().getRoot());
    }

    @Override
    public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
        ResourcesPlugin.getWorkspace().build(
            fullBuild ? IncrementalProjectBuilder.FULL_BUILD : IncrementalProjectBuilder.INCREMENTAL_BUILD,
            monitor);
        return Status.OK_STATUS;
    }

    @Override
    public boolean belongsTo(Object family) {
        if (family == ResourcesPlugin.FAMILY_MANUAL_BUILD) {
            return true;
        }
        return super.belongsTo(family);
    }
}