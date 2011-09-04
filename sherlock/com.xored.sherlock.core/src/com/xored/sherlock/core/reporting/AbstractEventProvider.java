package com.xored.sherlock.core.reporting;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractEventProvider implements IEventProvider {

	private List<IReportBuilder> listeners = new ArrayList<IReportBuilder>();

	public AbstractEventProvider() {
		super();
	}

	public void addListener(IReportBuilder builder) {
		synchronized (listeners) {
			listeners.add(builder);
		}
		initializeBuilder(builder);
	}

	protected abstract void initializeBuilder(IReportBuilder builder);

	public void removeListener(IReportBuilder builder) {
		synchronized (listeners) {
			listeners.remove(builder);
			if (listeners.isEmpty()) {
				doneBuilders();
			}
		}
	}

	protected void doneBuilders() {
	}

	protected IReportBuilder[] getListeners() {
		IReportBuilder[] result = null;
		synchronized (listeners) {
			result = (IReportBuilder[]) listeners
					.toArray(new IReportBuilder[listeners.size()]);
		}
		return result;
	}

}