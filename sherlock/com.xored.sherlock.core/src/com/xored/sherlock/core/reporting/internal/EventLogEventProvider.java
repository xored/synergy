package com.xored.sherlock.core.reporting.internal;

import org.eclipse.core.runtime.ILogListener;
import org.eclipse.core.runtime.IStatus;

import com.xored.sherlock.core.SherlockCore;
import com.xored.sherlock.core.model.sherlock.EclipseStatus;
import com.xored.sherlock.core.model.sherlock.report.Event;
import com.xored.sherlock.core.reporting.AbstractEventProvider;
import com.xored.sherlock.core.reporting.IEventProvider;
import com.xored.sherlock.core.reporting.IReportBuilder;

public class EventLogEventProvider extends AbstractEventProvider implements
		IEventProvider, ILogListener {

	public static IStatus handledStatus;

	public EventLogEventProvider() {
	}

	@Override
	public void storeSnapshot(IReportBuilder builder, String id) {
	}

	@Override
	protected void doneBuilders() {
		SherlockCore.removeLogListener(this);
	}

	@Override
	public void logging(IStatus status, String plugin) {
		if (!status.equals(handledStatus)) {
			IReportBuilder[] builders = getListeners();
			for (IReportBuilder builder : builders) {
				Event event = builder.createEvent();
				EclipseStatus data = SherlockCore.convert(status);
				event.setData(data);
				data.setThreadName(Thread.currentThread().getName());
			}
		}
	}

	@Override
	protected void initializeBuilder(IReportBuilder builder) {
		SherlockCore.addLogListener(this, null, null);
	}
}
