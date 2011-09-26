package com.xored.x5.sample.transport;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.xored.x5.agent.core.Transport;

public class SampleAgentTransport implements Transport {

	public SampleAgentTransport(SampleServerTransport server) {
		this.server = server;
	}

	@Override
	public void initialize(ResourceSet resourceSet) throws Exception {
	}

	@Override
	public EObject send(EObject data) {
		return server.notify(data);
	}

	private SampleServerTransport server;

}
