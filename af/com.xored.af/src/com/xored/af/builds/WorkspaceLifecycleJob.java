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

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * @author zapletnev
 */
public class WorkspaceLifecycleJob
    extends WorkspaceJob
{
    private EmfModelLifecycle lifeCyrcle;

    public WorkspaceLifecycleJob(EditingDomain domain, String natureId)
    {
        super("Start Workspace Lifecycle"); //$NON-NLS-1$
        setRule(ResourcesPlugin.getWorkspace().getRoot());
        lifeCyrcle = new EmfModelLifecycle(domain, natureId);
    }

    @Override
    public IStatus runInWorkspace(IProgressMonitor monitor)
        throws CoreException
    {
        lifeCyrcle.start();
        return Status.OK_STATUS;
    }

    public void stop()
    {
        lifeCyrcle.stop();
    }

}
