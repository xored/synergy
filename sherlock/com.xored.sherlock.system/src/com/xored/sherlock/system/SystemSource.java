package com.xored.sherlock.system;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import com.xored.sherlock.core.EntityDataSource;

public class SystemSource implements EntityDataSource {

	@Override
	public EObject getData() {
		return SystemFactory.eINSTANCE.createSystem();
	}

	@Override
	public void initialize(Map<String, String> options) {
	}
}
