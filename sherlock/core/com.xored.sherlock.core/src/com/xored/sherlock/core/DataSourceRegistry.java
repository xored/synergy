package com.xored.sherlock.core;

import java.util.Collection;
import java.util.Map;

public interface DataSourceRegistry {

	DataSource getSource(String id);

	DataSource getSource(String id, Map<String, String> options);

	DataSourceFactory getFactory(String id);

	Collection<DataSourceFactory> getFactories();

	boolean addFactory(DataSourceFactory factory);

	boolean removeFactory(DataSourceFactory factory);

	Collection<DataSourceFactory> addListener(DataSourceListener listener);

	boolean removeListener(DataSourceListener listener);

}
