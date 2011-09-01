package com.xored.x5.sample.transport;

import org.eclipse.emf.ecore.EObject;

import com.xored.x5.server.RequestHandler;
import com.xored.x5.server.ServerTransport;

public class SampleServerTransport implements ServerTransport {

	@Override
	public void setHandler(RequestHandler handler) {
		this.handler = handler;
	}

	public EObject push(EObject object) {
		return handler.handle(object);
	}

	private RequestHandler handler;

}
