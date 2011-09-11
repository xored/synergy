package com.xored.sherlock.core.base;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.xored.sherlock.core.DataSource;
import com.xored.sherlock.core.DataSourceFactory;
import com.xored.sherlock.core.DataSourceListener;
import com.xored.sherlock.core.DataSourceRegistry;

public class FixedDataSourceRegistry implements DataSourceRegistry {

	public FixedDataSourceRegistry(List<DataSourceFactory> factories) {
		for (DataSourceFactory factory : factories) {
			this.factories.put(factory.getId(), factory);
		}
	}

	@Override
	public DataSource getSource(String id) {
		Map<String, String> options = Collections.emptyMap();
		return getSource(id, options);
	}

	@Override
	public DataSource getSource(String id, Map<String, String> options) {
		return getFactory(id).create(options);
	}

	@Override
	public DataSourceFactory getFactory(String id) {
		return factories.get(id);
	}

	@Override
	public Collection<DataSourceFactory> getFactories() {
		return factories.values();
	}

	@Override
	public boolean addFactory(DataSourceFactory factory) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean removeFactory(DataSourceFactory factory) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Collection<DataSourceFactory> addListener(DataSourceListener listener) {
		return getFactories();
	}

	@Override
	public boolean removeListener(DataSourceListener listener) {
		return true;
	}

	private Map<String, DataSourceFactory> factories = new LinkedHashMap<String, DataSourceFactory>();

}
