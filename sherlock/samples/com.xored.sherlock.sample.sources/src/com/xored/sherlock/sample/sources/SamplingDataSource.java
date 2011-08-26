package com.xored.sherlock.sample.sources;

import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import com.xored.sherlock.core.BaseEventDataSource;

public class SamplingDataSource extends BaseEventDataSource {

	@Override
	protected void start() {
		task = new TimerTask() {
			@Override
			public void run() {
				fire(SourcesFactory.eINSTANCE.createSample());
			}
		};
		timer.schedule(task, delay, period);
	}

	@Override
	protected void finish() {
		task.cancel();
		timer.purge();
	}

	@Override
	public void initialize(Map<String, String> options) {
		String d = options.get(DELAY_OPTION);
		if (d != null) {
			delay = Long.parseLong(d);
		}
		String p = options.get(PERIOD_OPTION);
		if (p != null) {
			period = Long.parseLong(p);
		}
	}

	private static final String DELAY_OPTION = "delay";
	private static final String PERIOD_OPTION = "period";

	private long delay = 0;
	private long period = 1000;
	private Timer timer = new Timer();
	private TimerTask task;

}
