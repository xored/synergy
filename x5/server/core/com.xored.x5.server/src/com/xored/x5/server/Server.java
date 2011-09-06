package com.xored.x5.server;

import org.eclipse.emf.ecore.EObject;

public abstract class Server {

	public Server(ServerTransport transport) {
		this(transport, new BaseServerStrategy());
	}

	public Server(ServerTransport transport, ServerStrategy strategy) {
		this.transport = transport;
		this.strategy = strategy;
	}

	protected abstract void handle(EObject object);

	public void initialize() {
		transport.setHandler(new Handler());
		strategy.initialize(new EObjectQueue() {

			@Override
			public void push(EObject object) {
				handle(object);
			}
		});
	}

	private class Handler implements RequestHandler {

		@Override
		public EObject handle(EObject data) {
			return strategy.push(data);
		}

	}

	private ServerTransport transport;
	private ServerStrategy strategy;

}
