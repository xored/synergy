package com.xored.x5.server.core;

import org.eclipse.emf.ecore.EObject;

public abstract class ServerTransport {

	protected void notify(EObject data) {
		handler.handle(data);
	}

	public void setHandler(RequestHandler handler) {
		this.handler = handler;
	}

	public void close() {

	}

	protected RequestHandler handler;

}
