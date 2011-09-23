package com.xored.x5.internal.agent.core;

import java.util.concurrent.ExecutorService;

import org.eclipse.emf.ecore.EObject;

import com.xored.sherlock.core.DataSourceFactory;
import com.xored.sherlock.core.ProcessDataSource;
import com.xored.sherlock.core.ProcessListener;
import com.xored.x5.common.Log;

public class ProcessDataSourceSender extends BaseDataSourceSender<ProcessDataSource> implements ProcessListener {

	protected ProcessDataSourceSender(DataSourceFactory factory, ExecutorService executor, Log log) {
		super(factory, executor, log);
	}

	@Override
	protected void attachSource(ProcessDataSource source) {
		source.addProcessListener(this);
	}

	@Override
	protected void detachSource(ProcessDataSource source) {
		source.removeProcessListener(this);
	}

	@Override
	public void handleFinish(EObject data) {
		push(data);
	}

	@Override
	public void handleStart(EObject data) {
	}

}
