package com.xored.x5.agent.core;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;

public interface Transport {

	void initialize(ResourceSet resourceSet) throws Exception;

	EObject send(EObject request) throws Exception;

}
