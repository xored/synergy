package com.xored.sherlock.aspects.jobs.internal;

import org.eclipse.core.internal.jobs.InternalJob;
import org.eclipse.core.runtime.IStatus;

public interface IJobsEventListener {

	void jobSchedule(InternalJob job, long delay, boolean reshedule);

	void jobChangeStatus(InternalJob job, int newState);

	void endJob(InternalJob job, IStatus status, boolean notify);

	void jobCanceled(InternalJob job);
}
