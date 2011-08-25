package com.xored.sherlock.sample.sources;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import com.xored.sherlock.core.IntervalDataSource;

public class DurationDataSource implements IntervalDataSource {

	@Override
	public void initialize(Map<String, String> options) {
	}

	@Override
	public void start() {
		start = System.currentTimeMillis();
	}

	@Override
	public EObject finish() {
		long time = System.currentTimeMillis() - start;
		duration = SourcesFactory.eINSTANCE.createDuration();
		duration.setTime(time);
		start = -1;
		return duration;
	}

	private long start;
	private Duration duration;

}
