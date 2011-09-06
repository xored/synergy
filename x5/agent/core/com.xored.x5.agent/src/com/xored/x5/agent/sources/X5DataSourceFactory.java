package com.xored.x5.agent.sources;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;

import com.xored.sherlock.core.DataSource;
import com.xored.sherlock.core.DataSourceFactory;
import com.xored.sherlock.core.DataSourceRegistry;
import com.xored.x5.core.CompositeDataSource;
import com.xored.x5.internal.agent.sources.CompositeDSDescriptor;
import com.xored.x5.internal.agent.sources.DSDescriptor;
import com.xored.x5.internal.agent.sources.DataLinkDescriptor;
import com.xored.x5.internal.agent.sources.X5DataSource;

public class X5DataSourceFactory implements DataSourceFactory {

	public X5DataSourceFactory(CompositeDataSource source, DataSourceRegistry manager) {
		this.source = source;
		descriptor = DSDescriptor.create(source, manager);
		pack = createPackage(source);
		addClasses(descriptor);
		EPackage.Registry.INSTANCE.put(pack.getNsURI(), pack);
	}

	@Override
	public EClass getEClass() {
		return descriptor.getEClass();
	}

	@Override
	public Class<? extends DataSource> getSourceClass() {
		return descriptor.getSourceClass();
	}

	@Override
	public String getId() {
		return source.getId();
	}

	@Override
	public X5DataSource create(Map<String, String> options) {
		return descriptor.createSource();
	}

	public EPackage getEPackage() {
		return pack;
	}

	private EPackage createPackage(CompositeDataSource source) {
		EPackage p = EcoreFactory.eINSTANCE.createEPackage();
		p.setName(source.getName());
		p.setNsURI("http://xored.com/x5/" + source.getId() + "/dynamic.ecore");
		p.setNsPrefix(source.getId());
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
	private CompositeDataSource source;

}
