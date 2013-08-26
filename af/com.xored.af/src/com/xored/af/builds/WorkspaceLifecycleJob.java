/**
 * Copyright (C) 2013, 1C
 */
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
