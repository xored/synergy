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
package com.xored.af.ui.builds;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.ILock;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.UIJob;

import com.xored.af.builds.EmfBuilds;
import com.xored.af.ui.internal.AfUiPlugin;

/**
 * Will automatically reschedule itself until no builds are pending.
 * 
 * Will prevent nested execution of several runnables in case of ModalContext
 * etc.
 * 
 * This is a non-blocking implementation, thus not prone to deadlocks.
 * 
 */
public abstract class BuildWaitingJob extends UIJob {
	private static final ILock LOCK = Job.getJobManager().newLock();

	protected final Display display;

	public BuildWaitingJob() {
		this(PlatformUI.getWorkbench().getDisplay());
	}

	public BuildWaitingJob(final Display display) {
		super(display, "Build waiting job");
		Assert.isLegal(!display.isDisposed(), "display must not be disposed");

		this.display = display;
	}

	@Override
	public IStatus runInUIThread(final IProgressMonitor monitor) {
		if (display.isDisposed()) {
			return Status.CANCEL_STATUS;
		}

		if (EmfBuilds.isBuildPending() || LOCK.getDepth() > 0) {
			schedule(100);
		} else {
			LOCK.acquire();
			try {
				doRun();
			} catch (final Exception e) {
				return new Status(IStatus.ERROR, AfUiPlugin.PLUGIN_ID, e.getMessage(), e);
			} finally {
				LOCK.release();
			}
		}
		return Status.OK_STATUS;
	}

	protected abstract void doRun() throws Exception;
}
