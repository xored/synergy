package com.xored.sherlock.sample.sources;

import java.util.Map;

import com.xored.sherlock.core.IntervalDataSource;

public class DurationDataSource implements IntervalDataSource<Duration> {

	@Override
	public void initialize(Map<String, String> options) {
	}

	@Override
	public Duration start() {
		Duration duration = SourcesFactory.eINSTANCE.createDuration();
		duration.setStart(System.currentTimeMillis());
		return duration;
	}

	@Override
	public void finish(Duration object) {
		object.setDuration(System.currentTimeMillis() - object.getStart());
	}

}
