package com.xored.x5.agent.core;

import org.eclipse.emf.ecore.EObject;

public interface Transport {

	EObject send(EObject request) throws Exception;

}
