package com.xored.x5.internal.agent.sources;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;

import com.xored.sherlock.core.DataSource;
import com.xored.sherlock.core.DataSourceRegistry;
import com.xored.sherlock.core.EntityDataSource;
import com.xored.sherlock.core.EventDataSource;
import com.xored.sherlock.core.ProcessDataSource;
import com.xored.x5.core.BaseDataSource;
import com.xored.x5.core.CompositeDataSource;
import com.xored.x5.core.DataSourceReference;

public class CompositeDSDescriptor extends DSDescriptor {

	CompositeDSDescriptor(CompositeDataSource source, DataSourceRegistry manager) {
		super(source, manager);
		base = DSDescriptor.create(source.getBase(), manager);
		eClass = buildClass();
		clazz = findSourceClass();
	}

	@Override
	public EClass getEClass() {
		return eClass;
	}

	@Override
	public Class<? extends DataSource> getSourceClass() {
		return clazz;
	}

	@Override
	public X5DataSource createSource() {
		DataSource base = this.base.createSource();
		if (base instanceof EventDataSource) {
			EntityDataBuilder builder = new EntityDataBuilder(getEClass(), createLinks());
			return new X5EventDataSource((EventDataSource) base, builder);
		} else if (base instanceof EntityDataSource) {
			EntityDataBuilder builder = new EntityDataBuilder(getEClass(), createLinks());
			return new X5EntityDataSource((EntityDataSource) base, builder);
		} else if (base instanceof ProcessDataSource) {
			ProcessDataBuilder builder = new ProcessDataBuilder(getEClass(), createLinks());
			return new X5ProcessDataSource((ProcessDataSource) base, builder);
		}
		throw new IllegalArgumentException();
	}

	private Class<? extends DataSource> findSourceClass() {
		clazz = this.base.getSourceClass();
		if (EventDataSource.class.isAssignableFrom(clazz)) {
			return X5EventDataSource.class;
		} else if (EntityDataSource.class.isAssignableFrom(clazz)) {
			return X5EntityDataSource.class;
		} else if (ProcessDataSource.class.isAssignableFrom(clazz)) {
			return X5ProcessDataSource.class;
		}
		throw new IllegalArgumentException(
				"Base class of composite data source doesn't implement any known data sources: " + clazz.getName()
						+ ". Should implement EventDataSource, EntityDataSource or ProcessDataSource.");
	}

	public List<DataLinkDescriptor> getLinks() {
		return Collections.unmodifiableList(links);
	}

	protected CompositeDataSource getSource() {
		return (CompositeDataSource) source;
	}

	private EClass buildClass() {
		EClass base = this.base.getEClass();

		EClass eClass = EcoreFactory.eINSTANCE.createEClass();
		eClass.setName(getSource().getName());
		eClass.getESuperTypes().add(base);

		for (DataSourceReference reference : getSource().getReferences()) {
			DataLinkDescriptor link = createLink(reference);
			eClass.getEStructuralFeatures().add(link.getReference());
			links.add(link);
		}
		return eClass;
	}

	private DataLinkDescriptor createLink(DataSourceReference reference) {
		BaseDataSource source = reference.getSource();
		DSDescriptor descriptor = DSDescriptor.create(source, manager);

		EReference ref = EcoreFactory.eINSTANCE.createEReference();
		ref.setName(reference.getName());
		ref.setContainment(true);
		if (isMany(descriptor)) {
			ref.setUpperBound(-1);
		}
		ref.setEType(descriptor.getEClass());
		return new DataLinkDescriptor(ref, descriptor);
	}

	private boolean isMany(DSDescriptor descriptor) {
		return EventDataSource.class.isAssignableFrom(descriptor.getSourceClass());
	}

	private List<DataLink> createLinks() {
		List<DataLink> result = new ArrayList<DataLink>();
		for (DataLinkDescriptor descriptor : links) {
			result.add(descriptor.createLink());
		}
		return result;
	}

	private EClass eClass;
	private Class<? extends DataSource> clazz;
	private List<DataLinkDescriptor> links = new ArrayList<DataLinkDescriptor>();
	private DSDescriptor base;

}
