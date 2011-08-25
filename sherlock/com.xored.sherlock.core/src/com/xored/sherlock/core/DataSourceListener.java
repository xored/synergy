package com.xored.sherlock.core;

public interface DataSourceListener {

	void handleAdd(String id, DataSourceFactory source);

	void handleRemove(String id, DataSourceFactory source);

}
