package com.xored.sherlock.aspects.jobs.internal;

import java.util.ArrayList;
import java.util.List;

public class JobsEventManager {
	private static JobsEventManager INSTANCE = null;
	private List<IJobsEventListener> listeners = new ArrayList<IJobsEventListener>();

	public JobsEventManager() {
	}

	public static JobsEventManager getDefault() {
		if (INSTANCE == null) {
			INSTANCE = new JobsEventManager();
		}
		return INSTANCE;
	}

	public void addListener(IJobsEventListener listener) {
		synchronized (listeners) {
			if (!listeners.contains(listener)) {
				listeners.add(listener);
			}
		}
	}

	public void removeListener(IJobsEventListener listener) {
		synchronized (listeners) {
			listeners.remove(listener);
		}
	}

	public IJobsEventListener[] getListeners() {
		synchronized (listeners) {
			return new ArrayList<IJobsEventListener>(listeners)
					.toArray(new IJobsEventListener[listeners.size()]);
		}
	}
}
