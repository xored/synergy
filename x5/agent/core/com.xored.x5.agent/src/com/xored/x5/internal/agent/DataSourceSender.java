package com.xored.x5.internal.agent;

import com.xored.x5.agent.Transport;

public interface DataSourceSender {

	void attachTo(Transport transport);

	void detach();

}
