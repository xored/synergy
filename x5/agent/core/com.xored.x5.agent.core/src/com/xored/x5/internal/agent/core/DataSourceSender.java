package com.xored.x5.internal.agent.core;

import com.xored.x5.agent.core.Transport;

public interface DataSourceSender {

	void attachTo(Transport transport);

	void detach();

}
