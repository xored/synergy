package com.xored.x5.server;

import org.eclipse.emf.ecore.EObject;

import com.xored.x5.core.EObjectQueue;

public interface ServerStrategy {

	void initialize(EObjectQueue queue);

	EObject push(EObject object);

}
