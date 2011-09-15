package com.xored.x5.internal.agent.core.sources;

import com.xored.sherlock.core.DataSource;

public interface X5DataSource extends DataSource {

	void addDataListener(X5DataListener listener);

	void removeDataListener(X5DataListener listener);

}
