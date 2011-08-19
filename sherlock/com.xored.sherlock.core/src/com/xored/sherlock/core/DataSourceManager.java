package com.xored.sherlock.core;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
			throw new IllegalArgumentException("Data source '" + id
					+ "' is not registered");
		}
		try {
			DataSource source = type.create();
			if (options != null) {
				source.initialize(options);
			}
			return source;
		} catch (Exception e) {
			throw new IllegalArgumentException("Data source '"
					+ "' can't be instantiated", e);
		}
	}

	public void add(String id, DataSourceFactory source) {
		if (!sources.containsKey(id))
			sources.put(id, source);
	}

	public void remove(String id) {
		sources.remove(id);
	}

	private LinkedHashMap<String, DataSourceFactory> sources = new LinkedHashMap<String, DataSourceFactory>();

}
