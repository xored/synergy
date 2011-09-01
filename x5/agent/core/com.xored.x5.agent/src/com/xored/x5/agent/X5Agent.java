package com.xored.x5.agent;

import org.eclipse.emf.ecore.EObject;

import com.xored.x5.core.EObjectQueue;
import com.xored.x5.core.X5DataSource;

public class X5Agent {

	public X5Agent(AgentTransport transport, X5DataSource source) {
		this(transport, source, new BaseAgentStrategy());
	}

	public X5Agent(AgentTransport transport, X5DataSource source, AgentStrategy strategy) {
		this.transport = transport;
		this.strategy = strategy;
		this.source = source;
	}

	public void connect() {
		transport.connect();
		strategy.initialize(new Queue());
		source.addDataListener(strategy);
	}

	public void close() {
		source.removeDataListener(strategy);
		transport.close();
	}

	private class Queue implements EObjectQueue {

		@Override
		public void push(EObject object) {
			transport.send(object);
		}

	}

	private AgentTransport transport;
	private AgentStrategy strategy;
	private X5DataSource source;

}
