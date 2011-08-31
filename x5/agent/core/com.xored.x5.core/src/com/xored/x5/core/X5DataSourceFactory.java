package com.xored.x5.core;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;

import com.xored.sherlock.core.DataSourceFactory;
import com.xored.sherlock.core.DataSourceManager;
import com.xored.x5.internal.core.CompositeDSDescriptor;
import com.xored.x5.internal.core.DSDescriptor;
import com.xored.x5.internal.core.builders.DataLinkDescriptor;

public class X5DataSourceFactory implements DataSourceFactory {

	public X5DataSourceFactory(CompositeDataSource source, DataSourceManager manager) {
		descriptor = DSDescriptor.create(source, manager);
		pack = createPackage();
		addClasses(descriptor);
		EPackage.Registry.INSTANCE.put(pack.getNsURI(), pack);
	}

	@Override
	public EClass getEClass() {
		return descriptor.getEClass();
	}

	@Override
	public X5DataSource create(Map<String, String> options) {
		return descriptor.createSource();
	}

	public EPackage getEPackage() {
		return pack;
	}

	private EPackage createPackage() {
		EPackage p = EcoreFactory.eINSTANCE.createEPackage();
		p.setName("facts");
		p.setNsURI("http://xored.com/x5/dynamic.ecore");
		p.setNsPrefix("com.xored.x5.dynamic");
		return p;
	}

	private void addClasses(DSDescriptor descriptor) {
		if (descriptor instanceof CompositeDSDescriptor) {
			CompositeDSDescriptor cds = (CompositeDSDescriptor) descriptor;
			pack.getEClassifiers().add(cds.getEClass());
			for (DataLinkDescriptor link : cds.getLinks()) {
				addClasses(link.getDescriptor());
			}
		}
	}

	private EPackage pack;
	private CompositeDSDescriptor descriptor;

}
