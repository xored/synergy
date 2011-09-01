package com.xored.x5.server;

import org.eclipse.emf.ecore.EObject;

import com.xored.x5.core.EObjectQueue;

public class BaseServerStrategy implements ServerStrategy {

	@Override
	public void initialize(EObjectQueue queue) {
		this.queue = queue;
	}

	@Override
	public EObject push(EObject object) {
		queue.push(object);
		return null;
	}

	private EObjectQueue queue;

}
