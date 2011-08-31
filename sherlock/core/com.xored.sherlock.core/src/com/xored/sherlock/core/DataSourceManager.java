package com.xored.sherlock.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CopyOnWriteArrayList;

import org.eclipse.emf.ecore.EClass;

public class DataSourceManager {

	public DataSource getSource(String id) {
		Map<String, String> options = Collections.emptyMap();
		return getSource(id, options);
	}

	public DataSource getSource(String id, Map<String, String> options) {
		DataSourceFactory type = sources.get(id);
		if (type == null) {
			throw new IllegalArgumentException("Data source '" + id + "' is not registered");
		}
		try {
			return type.create(options);
		} catch (Exception e) {
			throw new IllegalArgumentException("Data source '" + "' can't be instantiated", e);
		}
	}

	public EClass getSourceType(String id) {
		DataSourceFactory factory = sources.get(id);
		if (factory == null) {
			throw new IllegalArgumentException("Data source '" + id + "' is not registered");
		}
		return factory.getEClass();
	}

	public List<String> getSourceIds() {
		return new ArrayList<String>(sources.keySet());
	}

	public void add(String id, DataSourceFactory source) {
		if (sources.putIfAbsent(id, source) == null) {
			for (DataSourceListener listener : listeners) {
				listener.handleAdd(id);
			}
		} else {
			throw new IllegalArgumentException("Data source with '" + id + "' id is already registered");
		}
	}

	public void remove(String id) {
		if (sources.remove(id) != null) {
			for (DataSourceListener listener : listeners) {
				listener.handleRemove(id);
			}
		}
	}

	public void addListener(DataSourceListener listener) {
		listeners.addIfAbsent(listener);
	}

	public void removeListener(DataSourceListener listener) {
		listeners.remove(listener);
	}

	private ConcurrentSkipListMap<String, DataSourceFactory> sources = new ConcurrentSkipListMap<String, DataSourceFactory>();
	private CopyOnWriteArrayList<DataSourceListener> listeners = new CopyOnWriteArrayList<DataSourceListener>();

}
