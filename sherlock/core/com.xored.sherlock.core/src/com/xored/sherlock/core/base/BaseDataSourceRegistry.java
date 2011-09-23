package com.xored.sherlock.core.base;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import com.xored.sherlock.core.DataSource;
import com.xored.sherlock.core.DataSourceFactory;
import com.xored.sherlock.core.DataSourceListener;
import com.xored.sherlock.core.DataSourceRegistry;

public class BaseDataSourceRegistry implements DataSourceRegistry {

	public DataSource getSource(String id) {
		Map<String, String> options = Collections.emptyMap();
		return getSource(id, options);
	}

	public DataSource getSource(String id, Map<String, String> options) {
		DataSourceFactory factory = getFactory(id);
		try {
			return factory.create(options);
		} catch (Exception e) {
			throw new IllegalArgumentException("Data source '" + "' can't be instantiated", e);
		}
	}

	public synchronized DataSourceFactory getFactory(String id) {
		DataSourceFactory factory = factories.get(id);
		if (factory != null)
			return factory;
		throw new IllegalArgumentException("Data source '" + id + "' is not registered");
	}

	public synchronized Collection<DataSourceFactory> getFactories() {
		return new ArrayList<DataSourceFactory>(factories.values());
	}

	public boolean addFactory(DataSourceFactory factory) {
		synchronized (this) {
			String id = factory.getId();
			if (factories.containsKey(id)) {
				return false;
			}
			factories.put(id, factory);
		}
		for (DataSourceListener listener : listeners) {
			listener.handleAdd(factory);
		}
		return true;
	}

	public boolean removeFactory(DataSourceFactory factory) {
		synchronized (this) {
			String id = factory.getId();
			DataSourceFactory check = factories.get(id);
			if (check != factory)
				return false;
			factories.remove(id);
		}
		for (DataSourceListener listener : listeners) {
			listener.handleRemove(factory);
		}
		return true;
	}

	public boolean addListener(DataSourceListener listener) {
		return listeners.addIfAbsent(listener);
	}

	public boolean removeListener(DataSourceListener listener) {
		return listeners.remove(listener);
	}

	private LinkedHashMap<String, DataSourceFactory> factories = new LinkedHashMap<String, DataSourceFactory>();
	private CopyOnWriteArrayList<DataSourceListener> listeners = new CopyOnWriteArrayList<DataSourceListener>();

}
