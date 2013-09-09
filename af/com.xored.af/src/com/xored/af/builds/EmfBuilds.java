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

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.IJobManager;
import org.eclipse.core.runtime.jobs.Job;

public class EmfBuilds {

    public static final Object VALIDATION_FAMILY = new Object();

    private static class BuildProjectJob extends WorkspaceJob {
        private final IProject project;
        private final int buildKind;

        public BuildProjectJob(final IProject project, final int buildKind) {
            super("Build " + project.getName());
            this.project = project;
            this.buildKind = buildKind;

            setUser(true);
            setRule(project.getWorkspace().getRoot());
        }

        @Override
        public IStatus runInWorkspace(final IProgressMonitor monitor) throws CoreException {
            project.build(buildKind, monitor);
            return Status.OK_STATUS;
        }

        @Override
        public boolean belongsTo(final Object family) {
            if (family == ResourcesPlugin.FAMILY_MANUAL_BUILD) {
                return true;
            } else if (family == project) {
                return true;
            }
            return super.belongsTo(family);
        }
    }

    private EmfBuilds() {
    }

    private static void sleep(final int millis) {
        try {
            Thread.sleep(millis);
        } catch (final InterruptedException e) {
        }
    }

    public static void waitForAll() {
        // Do not use IJobManager.join to avoid deadlocks
        while (isBuildPending()) {
            sleep(100);
        }
    }

    public static boolean isBuildPending() {
        final IJobManager jobManager = Job.getJobManager();

        final Job[] auto = jobManager.find(ResourcesPlugin.FAMILY_AUTO_BUILD);
        for (final Job job : auto) {
            if (job.getState() != Job.NONE) {
                return true;
            }
        }

        final Job[] manual = jobManager.find(ResourcesPlugin.FAMILY_MANUAL_BUILD);
        for (final Job job : manual) {
            if (job.getState() != Job.NONE) {
                return true;
            }
        }

        return false;
    }

    private static synchronized void scheduleBuild(final IProject project, final int buildKind) {
        final Job[] jobs = Job.getJobManager().find(project);
        for (final Job job : jobs) {
            if (job.belongsTo(ResourcesPlugin.FAMILY_MANUAL_BUILD)) {
                return;
            }
        }

        new BuildProjectJob(project, buildKind).schedule();
    }

    public static synchronized void scheduleBuild(final IProject project, final boolean fullBuild) {
        scheduleBuild(project, fullBuild ? IncrementalProjectBuilder.FULL_BUILD
            : IncrementalProjectBuilder.INCREMENTAL_BUILD);
    }
}
