package com.xored.x5.sample.transport;

import org.eclipse.emf.ecore.EObject;

import com.xored.sherlock.core.DataSourceFactory;
import com.xored.x5.agent.Transport;

public class SampleAgentTransport implements Transport {

	public SampleAgentTransport(SampleServerTransport server) {
		this.server = server;
	}

	@Override
	public void attach(DataSourceFactory factory) {
	}

	@Override
	public void detach(DataSourceFactory factory) {
	}

	@Override
	public void send(String id, EObject data) {
		server.push(data);
	}

	private SampleServerTransport server;

}
