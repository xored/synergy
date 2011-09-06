package com.xored.x5.internal.agent;

import java.util.concurrent.ExecutorService;

import org.eclipse.emf.ecore.EObject;

import com.xored.sherlock.core.DataSourceFactory;
import com.xored.sherlock.core.EventDataSource;
import com.xored.sherlock.core.EventListener;

class EventDataSourceSender extends BaseDataSourceSender<EventDataSource> implements EventListener {

	protected EventDataSourceSender(DataSourceFactory factory, ExecutorService executor) {
		super(factory, executor);
	}

	@Override
	protected void attachSource(EventDataSource source) {
		source.addEventListener(this);
	}

	@Override
	protected void detachSource(EventDataSource source) {
		source.removeEventListener(this);
	}

	@Override
	public void handle(EObject event) {
		push(event);
	}

}
