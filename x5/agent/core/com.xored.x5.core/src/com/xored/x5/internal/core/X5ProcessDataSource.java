package com.xored.x5.internal.core;

import org.eclipse.emf.ecore.EObject;

import com.xored.sherlock.core.ProcessDataSource;
import com.xored.sherlock.core.ProcessListener;
import com.xored.sherlock.core.base.BaseProcessDataSource;
import com.xored.x5.core.X5DataListener;
import com.xored.x5.core.X5DataSource;
import com.xored.x5.internal.core.builders.ProcessDataBuilder;

public class X5ProcessDataSource extends BaseProcessDataSource implements ProcessListener, X5DataSource {

	public X5ProcessDataSource(ProcessDataSource source, ProcessDataBuilder builder) {
		this.source = source;
		this.builder = builder;
	}

	@Override
	protected void attach() {
		source.addProcessListener(this);
	}

	@Override
	protected void detach() {
		source.removeProcessListener(this);
	}

	@Override
	public void handleStart(EObject data) {
		fireStart(builder.start(data));
	}

	@Override
	public void handleFinish(EObject output) {
		fireFinish(builder.finish(output));
	}

	@Override
	public void addDataListener(X5DataListener listener) {
		if (builder.addDataListener(listener)) {
			addProcessListener(fake);
		}
	}

	@Override
	public void removeDataListener(X5DataListener listener) {
		if (builder.removeDataListener(listener)) {
			removeProcessListener(fake);
		}
	}

	private ProcessListener fake = new ProcessListener() {

		@Override
		public void handleStart(EObject data) {
		}

		@Override
		public void handleFinish(EObject data) {
		}
	};

	private ProcessDataSource source;
	private ProcessDataBuilder builder;

}
