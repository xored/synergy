package com.xored.x5.sample.transport;

import org.eclipse.emf.ecore.EObject;

import com.xored.sherlock.status.StatusUtil;
import com.xored.x5.agent.core.Transport;

public class SampleAgentTransport implements Transport {

	public SampleAgentTransport(SampleServerTransport server) {
		this.server = server;
	}

	@Override
	public EObject send(EObject data) {
		server.notify(data);
		return StatusUtil.newOkStatus();
	}

	private SampleServerTransport server;

}
