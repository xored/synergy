package com.xored.q7.profiling.core;

import com.xored.sherlock.aspects.asyncs.AsyncEventManager;
import com.xored.sherlock.aspects.jobs.internal.JobsEventManager;
import com.xored.sherlock.core.reporting.AbstractEventProvider;
import com.xored.sherlock.core.reporting.IReportBuilder;

public class JobsEventProvider extends AbstractEventProvider {
	AsyncProfilingSupport profilingListener = new AsyncProfilingSupport(this);
	JobsProfilingSupport profilingJobListener = new JobsProfilingSupport(this);

	@Override
	public IReportBuilder[] getListeners() {
		return super.getListeners();
	}

	public JobsEventProvider() {
	}

	public void storeSnapshot(IReportBuilder builder, String type) {
	}

	@Override
	protected void initializeBuilder(IReportBuilder builder) {
		AsyncEventManager.getDefault().addListener(profilingListener);
		JobsEventManager.getDefault().addListener(profilingJobListener);
		profilingJobListener.register();
	}

	@Override
	protected void doneBuilders() {
		AsyncEventManager.getDefault().removeListener(profilingListener);
		JobsEventManager.getDefault().removeListener(profilingJobListener);
		profilingJobListener.clear();
		profilingListener.clear();

		profilingJobListener.unregister();
	}
}
