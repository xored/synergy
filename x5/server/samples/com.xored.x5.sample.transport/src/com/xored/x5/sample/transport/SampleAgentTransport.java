package com.xored.x5.sample.transport;

import org.eclipse.emf.ecore.EObject;

import com.xored.x5.agent.AgentTransport;

public class SampleAgentTransport implements AgentTransport {

	public SampleAgentTransport(SampleServerTransport server) {
		this.server = server;
	}

	@Override
	public void connect() {
	}

	@Override
	public void close() {
	}

	@Override
	public EObject send(EObject data) {
		return server.push(data);
	}

	private SampleServerTransport server;

}
