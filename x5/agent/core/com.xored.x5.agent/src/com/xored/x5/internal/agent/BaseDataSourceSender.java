package com.xored.x5.internal.agent;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ExecutorService;

import org.eclipse.emf.ecore.EObject;

import com.xored.sherlock.core.DataSource;
import com.xored.sherlock.core.DataSourceFactory;
import com.xored.x5.agent.Transport;

abstract class BaseDataSourceSender<T extends DataSource> implements DataSourceSender {

	protected BaseDataSourceSender(DataSourceFactory factory, ExecutorService executor) {
		this.factory = factory;
		this.executor = executor;
	}

	public void attachTo(Transport transport) {
		detach();
		this.transport = transport;
		attach();
	}

	public void detach() {
		if (source != null) {
			detachSource(source);
			source = null;
		}
		if (transport != null) {
			final Transport t = transport;
			executor.submit(new Runnable() {

				@Override
				public void run() {
					t.detach(factory);
				}
			});
			transport = null;
		}
	}

	abstract protected void attachSource(T source);

	abstract protected void detachSource(T source);

	protected void push(final EObject data) {
		executor.submit(new Runnable() {

			@Override
			public void run() {
				transport.send(factory.getId(), data);
			}
		});
	}

	@SuppressWarnings("unchecked")
	private void attach() {
		executor.submit(new Runnable() {

			@Override
			public void run() {
				transport.attach(factory);
			}
		});
		Map<String, String> options = Collections.emptyMap();
		source = (T) factory.create(options);
		attachSource(source);
	}

	private T source;
	private DataSourceFactory factory;
	private Transport transport;
	private ExecutorService executor;

}
