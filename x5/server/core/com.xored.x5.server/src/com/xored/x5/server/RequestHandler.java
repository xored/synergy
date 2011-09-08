package com.xored.x5.server;

import org.eclipse.emf.ecore.EObject;

public interface RequestHandler {

	void handle(EObject data);

}
