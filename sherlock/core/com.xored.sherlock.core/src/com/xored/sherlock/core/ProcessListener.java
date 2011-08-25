package com.xored.sherlock.core;

import org.eclipse.emf.ecore.EObject;

public interface ProcessListener {

	void handleStart(EObject data);

	void handleFinish(EObject data);

}
