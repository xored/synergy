package com.xored.sherlock.core;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class DataSourceManager {

	public List<String> getSources() {
		return new ArrayList<String>(sources.keySet());
	}

	public DataSource getSource(String id) {
		return getSource(id, null);
	}

	public DataSource getSource(String id, Map<String, String> options) {
		DataSourceFactory type = sources.get(id);
		if (type == null) {
			throw new IllegalArgumentException("Data source '" + id + "' is not registered");
		}
		try {
			DataSource source = type.create();
			if (options != null) {
				source.initialize(options);
			}
			return source;
		} catch (Exception e) {
			throw new IllegalArgumentException("Data source '" + "' can't be instantiated", e);
		}
	}

	public void add(String id, DataSourceFactory source) {
		if (!sources.containsKey(id)) {
			sources.put(id, source);
			for (DataSourceListener listener : listeners) {
				listener.handleAdd(id, source);
			}
		}
	}

	public void remove(String id) {
		DataSourceFactory source = sources.remove(id);
		if (source != null) {
			for (DataSourceListener listener : listeners) {
				listener.handleRemove(id, source);
			}
		}
	}

	public void addListener(DataSourceListener listener) {
		listeners.addIfAbsent(listener);
	}

	public void removeListener(DataSourceListener listener) {
		listeners.remove(listener);
	}

	private LinkedHashMap<String, DataSourceFactory> sources = new LinkedHashMap<String, DataSourceFactory>();
	private CopyOnWriteArrayList<DataSourceListener> listeners = new CopyOnWriteArrayList<DataSourceListener>();

}
