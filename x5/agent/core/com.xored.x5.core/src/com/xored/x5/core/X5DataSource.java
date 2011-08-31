package com.xored.x5.core;

import com.xored.sherlock.core.DataSource;

public interface X5DataSource extends DataSource {

	void addDataListener(X5DataListener listener);

	void removeDataListener(X5DataListener listener);

}
