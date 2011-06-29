package com.xored.sherlock.aspects.jobs;

import org.eclipse.core.internal.jobs.InternalJob;
import org.eclipse.core.runtime.IStatus;

import com.xored.sherlock.aspects.jobs.internal.IJobsEventListener;
import com.xored.sherlock.aspects.jobs.internal.JobsEventManager;

public aspect JobsAspect {
	public JobsAspect() {
	}

	/**
	 * Used to determine finished ui job's.
	 */
	before(org.eclipse.core.internal.jobs.JobManager mgr,
			org.eclipse.core.internal.jobs.InternalJob job, IStatus status,
			boolean notify):
		execution(void org.eclipse.core.internal.jobs.JobManager.endJob(org.eclipse.core.internal.jobs.InternalJob, IStatus, boolean)) 
		&& target(mgr) && args(job, status, notify) {
		IJobsEventListener[] listeners = JobsEventManager
				.getDefault().getListeners();
		for (IJobsEventListener l : listeners) {
			l.endJob(job, status, notify);
		}
	}

	// Profiling
	before(org.eclipse.core.internal.jobs.InternalJob job, long delay,
			boolean reshedule):
				execution(void org.eclipse.core.internal.jobs.JobManager.schedule(InternalJob, long, boolean))
				&& args(job, delay, reshedule){
		IJobsEventListener[] listeners = JobsEventManager
				.getDefault().getListeners();
		for (IJobsEventListener l : listeners) {
			l.jobSchedule(job, delay, reshedule);
		}
	}

	before(org.eclipse.core.internal.jobs.InternalJob job, int newState):
		execution(void org.eclipse.core.internal.jobs.JobManager.changeState(InternalJob, int)) && args(job, newState) {
		IJobsEventListener[] listeners = JobsEventManager
				.getDefault().getListeners();
		for (IJobsEventListener l : listeners) {
			l.jobChangeStatus(job, newState);
		}
	}

	before(org.eclipse.core.internal.jobs.InternalJob job):
		execution(void org.eclipse.core.internal.jobs.JobManager.cancel(InternalJob)) && args(job) {
		IJobsEventListener[] listeners = JobsEventManager
				.getDefault().getListeners();
		for (IJobsEventListener l : listeners) {
			l.jobCanceled(job);
		}
	}
}
