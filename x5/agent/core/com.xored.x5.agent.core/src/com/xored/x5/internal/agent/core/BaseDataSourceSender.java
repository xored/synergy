package com.xored.x5.internal.agent.core;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ExecutorService;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import com.xored.sherlock.core.DataSource;
import com.xored.sherlock.core.DataSourceFactory;
import com.xored.sherlock.status.Status;
import com.xored.sherlock.status.StatusUtil;
import com.xored.x5.agent.core.Transport;
import com.xored.x5.common.Log;

abstract class BaseDataSourceSender<T extends DataSource> implements DataSourceSender {

	protected BaseDataSourceSender(DataSourceFactory factory, ExecutorService executor, Log log) {
		this.factory = factory;
		this.executor = executor;
		this.log = log;
	}

	public void attachTo(Transport transport) {
		detach();
		this.transport = transport;
		try {
			transport.initialize(new ResourceSetImpl());
		} catch (Exception e) {
			StatusUtil.newErrorStatus("com.xored.x5.agent.core", e);
		}
		attach();
	}

	public void detach() {
		if (source != null) {
			detachSource(source);
			source = null;
		}
		if (transport != null) {
			transport = null;
		}
	}

	abstract protected void attachSource(T source);

	abstract protected void detachSource(T source);

	protected void push(final EObject data) {
		executor.submit(new Runnable() {

			@Override
			public void run() {
				send(data);
			}
		});
	}

	private void send(EObject request) {
		Status status = null;
		try {
			EObject response = transport.send(request);
			if (response instanceof Status) {
				status = (Status) response;
			}
		} catch (Exception e) {
			// TODO remove print stack trace
			e.printStackTrace();
			status = StatusUtil.newErrorStatus("com.xored.x5.agent.core", e, "Can't send data: " + request);
		}
		if (status != null && !StatusUtil.isOk(status)) {
			log.log(status);
		}
	}

	@SuppressWarnings("unchecked")
	private void attach() {
		Map<String, String> options = Collections.emptyMap();
		source = (T) factory.create(options);
		attachSource(source);
	}

	private T source;
	private Log log;
	private DataSourceFactory factory;
	private Transport transport;
	private ExecutorService executor;

}
