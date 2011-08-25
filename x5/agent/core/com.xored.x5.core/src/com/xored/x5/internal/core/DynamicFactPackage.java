package com.xored.x5.internal.core;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;

public class DynamicFactPackage {

	public static DynamicFactPackage getInstance() {
		return instance;
	}

	public void addClass(EClass eClass) {
		pack.getEClassifiers().add(eClass);
	}

	private DynamicFactPackage() {
		pack = createPackage();
		EPackage.Registry.INSTANCE.put(pack.getNsURI(), pack);
	}

	private EPackage createPackage() {
		EPackage p = EcoreFactory.eINSTANCE.createEPackage();
		p.setName("facts");
		p.setNsURI("http://xored.com/x5/dynamic.ecore");
		p.setNsPrefix("com.xored.x5.dynamic");
		return p;
	}

	private EPackage pack;

	private static DynamicFactPackage instance = new DynamicFactPackage();

}
