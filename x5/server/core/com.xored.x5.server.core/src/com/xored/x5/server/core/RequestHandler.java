package com.xored.x5.server.core;

import org.eclipse.emf.ecore.EObject;

public interface RequestHandler {

	EObject handle(EObject request);

}
