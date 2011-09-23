package com.xored.x5.server.core;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;

public interface Session {

	void initialize(ResourceSet resourceSet) throws Exception;

	EObject getRequest() throws Exception;

	void setResponse(EObject eObject) throws Exception;

	void close();

}
