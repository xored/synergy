package com.xored.q7.profiling.core;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

import com.xored.sherlock.aspects.asyncs.IAsyncEventListener;
import com.xored.sherlock.core.model.sherlock.report.Event;
import com.xored.sherlock.core.model.sherlock.report.EventKind;
import com.xored.sherlock.core.model.sherlock.report.EventSource;
import com.xored.sherlock.core.reporting.IReportBuilder;
import com.xored.sherlock.jobs.jobs.AsyncEventInfo;
import com.xored.sherlock.jobs.jobs.AsyncEventKind;
import com.xored.sherlock.jobs.jobs.AsyncInfo;
import com.xored.sherlock.jobs.jobs.JobsFactory;

final class AsyncProfilingSupport implements IAsyncEventListener {
	private Map<IReportBuilder, Map<Runnable, EventSource>> sources = new HashMap<IReportBuilder, Map<Runnable, EventSource>>();
	private JobsEventProvider provider;

	public AsyncProfilingSupport(JobsEventProvider jobsEventProvider) {
		this.provider = jobsEventProvider;
	}

	public synchronized void timerAdded(Runnable async) {
	}

	public synchronized void asyncRunning(Runnable async) {
		IReportBuilder[] builders = provider.getListeners();
		for (IReportBuilder builder : builders) {
			if (getSources(builder).get(async) == null) {
				return;
			}
			Event event = builder.createEvent();
			event.setSource(getSources(builder).get(async));
			AsyncEventInfo eventInfo = JobsFactory.eINSTANCE
					.createAsyncEventInfo();
			event.setData(eventInfo);
			event.setKind(EventKind.BEGIN);
			eventInfo.setKind(AsyncEventKind.RUNNING);
		}
	}

	private Map<Runnable, EventSource> getSources(IReportBuilder builder) {
		Map<Runnable, EventSource> map = sources.get(builder);

		if (map == null) {
			map = new WeakHashMap<Runnable, EventSource>();
			sources.put(builder, map);
		}
		return map;
	}

	public synchronized void asyncDone(Runnable async) {
		IReportBuilder[] builders = provider.getListeners();
		for (IReportBuilder builder : builders) {

			if (getSources(builder).get(async) == null) {
				return;
			}
			Event event = builder.createEvent();
			event.setKind(EventKind.END);
			event.setSource(getSources(builder).get(async));
			AsyncEventInfo eventInfo = JobsFactory.eINSTANCE
					.createAsyncEventInfo();
			event.setData(eventInfo);
			eventInfo.setKind(AsyncEventKind.DONE);
			getSources(builder).remove(async);
		}
	}

	public synchronized void asyncAdded(Runnable async, boolean sync) {
		IReportBuilder[] builders = provider.getListeners();
		for (IReportBuilder builder : builders) {
			String cName = async.getClass().getName();
			// if (cName.contains("com.xored.q7")
			// || cName.contains("com.xored.tesla")) {
			// return;
			// }
			AsyncInfo info = JobsFactory.eINSTANCE.createAsyncInfo();
			info.setRunnableClass(async.getClass().getName());
			info.setSync(sync);
			Map<Thread, StackTraceElement[]> stackTraces = Thread
					.getAllStackTraces();
			Object object = ReflectionUtils.getThis(async);
			for (Thread t : stackTraces.keySet()) {
				if (!t.equals(Thread.currentThread())) {
					continue;
				}
				// Out thread
				StackTraceElement[] traceElements = stackTraces.get(t);
				boolean next = false;
				for (StackTraceElement stackTraceElement : traceElements) {
					if (next) {
						info.setSourceMethod(stackTraceElement.getMethodName());
						info.setSourceClass(stackTraceElement.getClassName());
						String fName = stackTraceElement.getFileName();
						if (fName != null) {
							info.setSourceFile(fName + ":"
									+ stackTraceElement.getLineNumber());
						}
						break;
					}
					if (stackTraceElement.getClassName().equals(
							"org.eclipse.swt.widgets.Display")) {
						next = true;
					}
				}
			}
			if (object != null) {
				String tname = object.getClass().getName();
				if (!(info.getSourceClass() != null && info.getSourceClass()
						.equals(tname))) {
					info.setThisClassName(tname);
				}
				// if (tname
				// .contains("org.eclipse.ui.internal.progress.AnimationManager")
				// ||
				// tname.contains("org.eclipse.ui.internal.progress.ProgressViewUpdater"))
				// {
				// return;
				// }
			}
			if (info.getRunnableClass() != null
					&& info.getSourceClass() != null) {
				if (info.getRunnableClass().startsWith(info.getSourceClass())) {
					info.setRunnableClass(info.getRunnableClass().substring(
							info.getSourceClass().length()));
				}
			}

			EventSource source = builder
					.findSource(SherlockJobsCore.JOBS, info);

			if (source == null) {
				source = builder.registerEventSource("async:"
						+ async.getClass().getSimpleName());
				source.getProperties().put(SherlockJobsCore.JOBS, info);
			}
			getSources(builder).put(async, source);

			Event event = builder.createEvent();
			event.setSource(source);
			AsyncEventInfo eventInfo = JobsFactory.eINSTANCE
					.createAsyncEventInfo();
			event.setData(eventInfo);
			eventInfo.setKind(AsyncEventKind.STARTING);
		}
	}

	public void clear() {
		sources.clear();
	}
}