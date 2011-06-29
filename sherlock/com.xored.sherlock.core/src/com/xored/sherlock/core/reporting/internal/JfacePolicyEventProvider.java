package com.xored.sherlock.core.reporting.internal;

import org.eclipse.core.runtime.ILogListener;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.util.ILogger;
import org.eclipse.jface.util.Policy;

import com.xored.sherlock.core.SherlockCore;
import com.xored.sherlock.core.model.sherlock.EclipseStatus;
import com.xored.sherlock.core.model.sherlock.report.Event;
import com.xored.sherlock.core.reporting.AbstractEventProvider;
import com.xored.sherlock.core.reporting.IEventProvider;
import com.xored.sherlock.core.reporting.IReportBuilder;

public class JfacePolicyEventProvider extends AbstractEventProvider implements
		IEventProvider, ILogListener {

	private static SherlockJfaceLogger fJFaceLogger;
	private static ILogger fJfaceNativeLogger;

	public JfacePolicyEventProvider() {
		fJFaceLogger = new SherlockJfaceLogger(this);
	}

	@Override
	public void storeSnapshot(IReportBuilder builder, String type) {
	}

	@Override
	public void logging(IStatus status, String plugin) {
		IReportBuilder[] builders = getListeners();
		for (IReportBuilder builder : builders) {
			Event event = builder.createEvent();
			EclipseStatus data = SherlockCore.convert(status);
			event.setData(data);
			data.setThreadName(Thread.currentThread().getName());
		}
	}

	@Override
	protected void initializeBuilder(IReportBuilder builder) {
		fJfaceNativeLogger = Policy.getLog();
		Policy.setLog(fJFaceLogger);
	}

	@Override
	protected void doneBuilders() {
		Policy.setLog(fJfaceNativeLogger);
	}

	private class SherlockJfaceLogger implements ILogger {
		private final JfacePolicyEventProvider fSherlockEventProvider;

		public SherlockJfaceLogger(
				JfacePolicyEventProvider sherlockEventProvider) {
			fSherlockEventProvider = sherlockEventProvider;
		}

		public void log(IStatus status) {
			EventLogEventProvider.handledStatus = status;
			fSherlockEventProvider.logging(status, "org.eclipse.jface");
			fJfaceNativeLogger.log(status);
		}
	};

}
