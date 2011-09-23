package com.xored.x5.agent.core;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.xored.sherlock.core.DataSourceFactory;
import com.xored.sherlock.core.DataSourceListener;
import com.xored.sherlock.core.DataSourceRegistry;
import com.xored.x5.internal.agent.core.DataSourceDispatcher;
import com.xored.x5.internal.agent.core.DataSourceSender;

public class X5Agent {

	public X5Agent(Transport transport, DataSourceRegistry registry) {
		this(transport, registry, DefaultLog.INSTANCE);
	}

	public X5Agent(Transport transport, DataSourceRegistry registry, Log log) {
		this.transport = transport;
		this.registry = registry;
		this.log = log;
	}

	public void initialize() {
		senders = Collections.synchronizedMap(new HashMap<DataSourceFactory, DataSourceSender>());
		executor = Executors.newFixedThreadPool(1);
		Collection<DataSourceFactory> factories;
		synchronized (registry) {
			factories = registry.getFactories();
			registry.addListener(listener);
		}
		for (DataSourceFactory factory : factories) {
			attach(factory);
		}
	}

	public void close() {
		registry.removeListener(listener);
		for (DataSourceSender sender : senders.values()) {
			try {
				sender.detach();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		executor.shutdown();
	}

	private void attach(DataSourceFactory factory) {
		DataSourceSender sender = DataSourceDispatcher.create(factory, executor, log);
		if (sender != null) {
			senders.put(factory, sender);
			sender.attachTo(transport);
		}
	}

	private void detach(final DataSourceFactory factory) {
		DataSourceSender sender = senders.remove(factory);
		if (sender != null) {
			sender.detach();
		}
	}

	private RegistryListener listener = new RegistryListener();

	private class RegistryListener implements DataSourceListener {

		@Override
		public void handleAdd(DataSourceFactory factory) {
			attach(factory);
		}

		@Override
		public void handleRemove(DataSourceFactory factory) {
			detach(factory);
		}

	}

	private Transport transport;
	private DataSourceRegistry registry;
	private Log log;
	private Map<DataSourceFactory, DataSourceSender> senders;
	private ExecutorService executor;

}
