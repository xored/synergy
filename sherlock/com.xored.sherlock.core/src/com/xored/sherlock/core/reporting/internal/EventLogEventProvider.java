package com.xored.sherlock.core.reporting.internal;

import org.eclipse.core.runtime.ILogListener;
import org.eclipse.core.runtime.IStatus;

import com.xored.sherlock.core.SherlockCore;
import com.xored.sherlock.core.model.sherlock.report.Event;
import com.xored.sherlock.core.reporting.AbstractEventProvider;
import com.xored.sherlock.core.reporting.IEventProvider;
import com.xored.sherlock.core.reporting.IReportBuilder;

public class EventLogEventProvider extends AbstractEventProvider implements
		IEventProvider, ILogListener {
	private static final String LOG_CATEGORY = "com.xored.sherlock.core.event.provider";

	public EventLogEventProvider() {
		SherlockCore.addLogListener(this, null, null);
	}

	@Override
	public void storeSnapshot(IReportBuilder builder, String id) {
	}

	@Override
	public void logging(IStatus status, String plugin) {
		IReportBuilder[] builders = getListeners();
		for (IReportBuilder builder : builders) {
			Event event = builder.createEvent();
			event.setCategory(builder.getCategory(LOG_CATEGORY));
			event.setData(SherlockCore.convert(status));
			event.getProperties().put("plugin", plugin);
			event.getProperties().put("thread.name",
					Thread.currentThread().getName());
		}
	}

	@Override
	protected void initializeBuilder(IReportBuilder builder) {
		builder.registerCategory(LOG_CATEGORY, "Log Events");
	}
}
