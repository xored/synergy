package com.xored.sherlock.sample.sources.ui;

import java.util.Map;

import com.xored.sherlock.core.ProcessDataSource;
import com.xored.sherlock.core.ProcessListener;

public class SampleProcessSource implements ProcessDataSource {

	@Override
	public void addProcessListener(ProcessListener listener) {
		SampleRegistry.getInstance().addEventListener(listener);
	}

	@Override
	public void removeProcessListener(ProcessListener listener) {
		SampleRegistry.getInstance().removeEventListener(listener);
	}

	@Override
	public void initialize(Map<String, String> options) {
	}

}
