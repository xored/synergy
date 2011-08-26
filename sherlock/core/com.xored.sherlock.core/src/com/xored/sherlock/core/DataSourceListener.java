package com.xored.sherlock.core;

public interface DataSourceListener {

	void handleAdd(String id);

	void handleRemove(String id);

}
