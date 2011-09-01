package com.xored.x5.agent;

import com.xored.x5.core.EObjectQueue;
import com.xored.x5.core.X5DataListener;

public interface AgentStrategy extends X5DataListener {

	void initialize(EObjectQueue queue);

}
