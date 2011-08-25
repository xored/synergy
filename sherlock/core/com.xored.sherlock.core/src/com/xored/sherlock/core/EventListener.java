package com.xored.sherlock.core;

import org.eclipse.emf.ecore.EObject;

public interface EventListener {

	void handle(EObject event);

}
