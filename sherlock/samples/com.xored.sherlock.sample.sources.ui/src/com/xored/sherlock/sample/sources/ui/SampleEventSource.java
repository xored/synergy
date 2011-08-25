package com.xored.sherlock.sample.sources.ui;

import java.util.Map;

import com.xored.sherlock.core.EventDataSource;
import com.xored.sherlock.core.EventListener;

public class SampleEventSource implements EventDataSource {

	@Override
	public void addEventListener(EventListener listener) {
		SampleRegistry.getInstance().addEventListener(listener);
	}

	@Override
	public void removeEventListener(EventListener listener) {
		SampleRegistry.getInstance().removeEventListener(listener);
	}

	@Override
	public void initialize(Map<String, String> options) {
	}

}
