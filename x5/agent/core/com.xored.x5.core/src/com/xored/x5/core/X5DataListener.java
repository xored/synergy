package com.xored.x5.core;

import org.eclipse.emf.ecore.EObject;

public interface X5DataListener extends EObjectQueue {

	void prepare(EObject object);

}
