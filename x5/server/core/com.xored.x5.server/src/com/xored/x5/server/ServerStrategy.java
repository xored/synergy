package com.xored.x5.server;

import org.eclipse.emf.ecore.EObject;

public interface ServerStrategy {

	void initialize(EObjectQueue queue);

	EObject push(EObject object);

}
