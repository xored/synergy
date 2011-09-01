package com.xored.x5.internal.core;

import org.eclipse.emf.ecore.EObject;

import com.xored.sherlock.core.EventDataSource;
import com.xored.sherlock.core.EventListener;
import com.xored.sherlock.core.base.BaseEventDataSource;
import com.xored.x5.core.X5DataListener;
import com.xored.x5.core.X5DataSource;
import com.xored.x5.internal.core.builders.EntityDataBuilder;

public class X5EventDataSource extends BaseEventDataSource implements EventListener, X5DataSource {

	public X5EventDataSource(EventDataSource source, EntityDataBuilder builder) {
		this.source = source;
		this.builder = builder;
	}

	@Override
	protected void attach() {
		source.addEventListener(this);
	}

	@Override
	protected void detach() {
		source.removeEventListener(this);
	}

	@Override
	public void handle(EObject event) {
		fire(builder.build(event));
	}

	@Override
	public void addDataListener(X5DataListener listener) {
		if (builder.addDataListener(listener)) {
			addEventListener(fake);
		}
	}

	@Override
	public void removeDataListener(X5DataListener listener) {
		if (builder.removeDataListener(listener)) {
			removeEventListener(fake);
		}
	}

	private EventListener fake = new EventListener() {
		@Override
		public void handle(EObject event) {
		}
	};

	private EventDataSource source;
	private EntityDataBuilder builder;

}
