package com.xored.sherlock.core;

public interface DataSourceListener {

	void handleAdd(DataSourceFactory factory);

	void handleRemove(DataSourceFactory factory);

}
