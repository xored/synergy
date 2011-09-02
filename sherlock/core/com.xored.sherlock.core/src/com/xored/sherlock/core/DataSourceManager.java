package com.xored.sherlock.core;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class DataSourceManager {

	public DataSource getSource(String id) {
		Map<String, String> options = Collections.emptyMap();
		return getSource(id, options);
	}

	public DataSource getSource(String id, Map<String, String> options) {
		DataSourceFactory factory = factories.get(id);
		if (factory == null) {
			throw new IllegalArgumentException("Data source '" + id + "' is not registered");
		}
		try {
			return factory.create(options);
		} catch (Exception e) {
			throw new IllegalArgumentException("Data source '" + "' can't be instantiated", e);
		}
	}

	public DataSourceFactory getFactory(String id) {
		DataSourceFactory factory = factories.get(id);
		if (factory != null)
			return factory;
		throw new IllegalArgumentException("Data source '" + id + "' is not registered");
	}

	public Collection<DataSourceFactory> getFactories() {
		return Collections.unmodifiableCollection(factories.values());
	}

	public void add(DataSourceFactory factory) {
		String id = factory.getId();
		if (factories.putIfAbsent(id, factory) == null) {
			for (DataSourceListener listener : listeners) {
				listener.handleAdd(factory);
			}
		} else {
			throw new IllegalArgumentException("Data source with '" + id + "' id is already registered");
		}
	}

	public boolean remove(DataSourceFactory factory) {
		if (factories.remove(factory.getId(), factory)) {
			for (DataSourceListener listener : listeners) {
				listener.handleRemove(factory);
			}
			return true;
		}
		return false;
	}

	public void addListener(DataSourceListener listener) {
		listeners.addIfAbsent(listener);
	}

	public void removeListener(DataSourceListener listener) {
		listeners.remove(listener);
	}

	private ConcurrentSkipListMap<String, DataSourceFactory> factories = new ConcurrentSkipListMap<String, DataSourceFactory>();
	private CopyOnWriteArrayList<DataSourceListener> listeners = new CopyOnWriteArrayList<DataSourceListener>();

}
