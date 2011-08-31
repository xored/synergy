package com.xored.x5.core;

import org.eclipse.emf.ecore.EObject;

public interface X5DataListener {

	void prepare(EObject object);

	void push(EObject object);

}
