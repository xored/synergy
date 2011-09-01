package com.xored.x5.agent;

import org.eclipse.emf.ecore.EObject;

import com.xored.x5.core.EObjectQueue;

public class BaseAgentStrategy implements AgentStrategy {

	@Override
	public void initialize(EObjectQueue queue) {
		this.queue = queue;
	}

	@Override
	public void prepare(EObject object) {
	}

	@Override
	public void push(EObject object) {
		queue.push(object);
	}

	private EObjectQueue queue;

}
