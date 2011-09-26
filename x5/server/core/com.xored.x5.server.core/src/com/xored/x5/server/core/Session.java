package com.xored.x5.server.core;

import org.eclipse.emf.ecore.resource.ResourceSet;

public interface Session {

	void initialize(ResourceSet resourceSet) throws Exception;

	boolean handle(RequestHandler handler) throws Exception;

	void close();

}
