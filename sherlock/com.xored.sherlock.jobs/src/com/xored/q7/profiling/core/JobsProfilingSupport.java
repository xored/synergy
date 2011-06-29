package com.xored.q7.profiling.core;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

import org.eclipse.core.internal.jobs.InternalJob;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.IJobChangeListener;
import org.eclipse.core.runtime.jobs.Job;

import com.xored.sherlock.aspects.jobs.internal.IJobsEventListener;
import com.xored.sherlock.core.model.sherlock.report.Event;
import com.xored.sherlock.core.model.sherlock.report.EventKind;
import com.xored.sherlock.core.model.sherlock.report.EventSource;
import com.xored.sherlock.core.reporting.IReportBuilder;
import com.xored.sherlock.jobs.jobs.JobEventInfo;
import com.xored.sherlock.jobs.jobs.JobEventKind;
import com.xored.sherlock.jobs.jobs.JobInfo;
import com.xored.sherlock.jobs.jobs.JobsFactory;

public class JobsProfilingSupport implements IJobsEventListener,
		IJobChangeListener {

	private Map<IReportBuilder, Map<Object, EventSource>> sources = new HashMap<IReportBuilder, Map<Object, EventSource>>();

	private JobsEventProvider provider;

	public JobsProfilingSupport(JobsEventProvider jobsEventProvider) {
		this.provider = jobsEventProvider;
	}

	private Map<Object, EventSource> getSources(IReportBuilder builder) {
		Map<Object, EventSource> map = sources.get(builder);

		if (map == null) {
			map = new WeakHashMap<Object, EventSource>();
			sources.put(builder, map);
		}
		return map;
	}

	public void jobSchedule(InternalJob job, long delay, boolean reshedule) {
		IReportBuilder[] builders = provider.getListeners();
		for (IReportBuilder builder : builders) {
			JobInfo jobInfo = JobsFactory.eINSTANCE.createJobInfo();
			String jname = job.getClass().getName();
			// if (jname.contains("org.eclipse.ecl")) {
			// return;
			// }
			jobInfo.setJobClassName(jname);

			Map<Thread, StackTraceElement[]> stackTraces = Thread
					.getAllStackTraces();
			Object object = ReflectionUtils.getThis(job);
			for (Thread t : stackTraces.keySet()) {
				if (!t.equals(Thread.currentThread())) {
					continue;
				}
				// Out thread
				StackTraceElement[] traceElements = stackTraces.get(t);
				boolean next = false;
				for (StackTraceElement stackTraceElement : traceElements) {
					if (next) {
						jobInfo.setSourceMethod(stackTraceElement
								.getMethodName());
						jobInfo.setSourceClass(stackTraceElement.getClassName());
						String fName = stackTraceElement.getFileName();
						if (fName != null) {
							jobInfo.setSourceFile(fName + ":"
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
				if (!(jobInfo.getSourceClass() != null && jobInfo
						.getSourceClass().equals(tname))) {
					jobInfo.setThisClassName(tname);
				}
				// if (tname
				// .contains("org.eclipse.ui.internal.progress.AnimationManager")
				// ||
				// tname.contains("org.eclipse.ui.internal.progress.ProgressViewUpdater"))
				// {
				// return;
				// }
			}
			if (jobInfo.getJobClassName() != null
					&& jobInfo.getSourceClass() != null) {
				if (jobInfo.getJobClassName().startsWith(
						jobInfo.getSourceClass())) {
					jobInfo.setJobClassName(jobInfo.getJobClassName()
							.substring(jobInfo.getSourceClass().length()));
				}
			}

			EventSource source = builder.findSource(SherlockJobsCore.JOBS,
					jobInfo);

			if (source == null) {
				source = builder.registerEventSource("job:"
						+ job.getClass().getSimpleName());
				source.getProperties().put(SherlockJobsCore.JOBS, jobInfo);
			}
			getSources(builder).put(job, source);

			Event event = builder.createEvent();
			event.setSource(source);
			JobEventInfo eventInfo = JobsFactory.eINSTANCE
					.createJobEventInfo();
			event.setData(eventInfo);
			// eventInfo.
			eventInfo.setKind(JobEventKind.SHEDULED);
		}
	}

	public void jobChangeStatus(InternalJob job, int newState) {
		IReportBuilder[] builders = provider.getListeners();
		for (IReportBuilder builder : builders) {
			if (getSources(builder).get(job) == null) {
				return;
			}
			Event event = builder.createEvent();
			event.setSource(getSources(builder).get(job));
			JobEventInfo eventInfo = JobsFactory.eINSTANCE
					.createJobEventInfo();
			event.setData(eventInfo);
			if (newState == Job.RUNNING || newState == 0x10) {
				eventInfo.setKind(JobEventKind.RUNNING);
				event.setKind(EventKind.BEGIN);
			} else if (newState == Job.SLEEPING) {
				eventInfo.setKind(JobEventKind.SLEPPING);
			} else if (newState == Job.WAITING || newState == 0x08
					|| newState == 0x40 || newState == 0x20) {
				eventInfo.setKind(JobEventKind.WAITING);
			}
		}
	}

	public void endJob(InternalJob job, IStatus status, boolean notify) {
		IReportBuilder[] builders = provider.getListeners();
		for (IReportBuilder builder : builders) {
			if (getSources(builder).get(job) == null) {
				return;
			}
			Event event = builder.createEvent();
			event.setSource(getSources(builder).get(job));
			JobEventInfo eventInfo = JobsFactory.eINSTANCE
					.createJobEventInfo();
			event.setData(eventInfo);
			if (status != null && Job.ASYNC_FINISH.equals(status)) {
				event.setKind(EventKind.END);
				eventInfo.setKind(JobEventKind.ASYNC_FINISH);

				// Add async wait pair
				Event event2 = builder.createEvent();
				event2.setSource(getSources(builder).get(job));
				JobEventInfo eventInfo2 = JobsFactory.eINSTANCE
						.createJobEventInfo();
				eventInfo2.setKind(JobEventKind.ASYNC_FINISH);
				event2.setKind(EventKind.BEGIN);
				event2.setData(eventInfo2);
			} else {
				event.setKind(EventKind.END);
				eventInfo.setKind(JobEventKind.FINISHED);
			}
		}
	}

	public void aboutToRun(IJobChangeEvent event) {
	}

	public void awake(IJobChangeEvent event) {
	}

	public void done(IJobChangeEvent event) {
	}

	public void running(IJobChangeEvent event) {
	}

	public void scheduled(IJobChangeEvent event) {
	}

	public void sleeping(IJobChangeEvent event) {
	}

	public void register() {
		Job.getJobManager().addJobChangeListener(this);
	}

	public void unregister() {
		Job.getJobManager().removeJobChangeListener(this);
	}

	public void jobCanceled(InternalJob job) {
		IReportBuilder[] builders = provider.getListeners();
		for (IReportBuilder builder : builders) {
			if (getSources(builder).get(job) == null) {
				return;
			}
			Event event = builder.createEvent();
			event.setSource(getSources(builder).get(job));
			JobEventInfo eventInfo = JobsFactory.eINSTANCE
					.createJobEventInfo();
			event.setData(eventInfo);
			eventInfo.setKind(JobEventKind.CANCELED);
			event.setKind(EventKind.END);
		}
	}

	public void clear() {
	}
}