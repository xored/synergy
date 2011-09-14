package com.xored.x5.agent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;

import com.xored.sherlock.core.DataSource;
import com.xored.sherlock.core.DataSourceFactory;
import com.xored.sherlock.core.EntityDataSource;
import com.xored.sherlock.core.EventDataSource;
import com.xored.sherlock.core.ProcessDataSource;
import com.xored.x5.internal.agent.sources.DataLink;
import com.xored.x5.internal.agent.sources.EntityDataBuilder;
import com.xored.x5.internal.agent.sources.ProcessDataBuilder;
import com.xored.x5.internal.agent.sources.X5DataSource;
import com.xored.x5.internal.agent.sources.X5EntityDataSource;
import com.xored.x5.internal.agent.sources.X5EventDataSource;
import com.xored.x5.internal.agent.sources.X5ProcessDataSource;

public class X5DataSourceFactory implements DataSourceFactory {

	public X5DataSourceFactory(String id, DataSourceFactory base, List<DataSourceReference> references, EClass eClass) {
		this(id, base, references);
		this.eClass = eClass;
		validateEClass();
	}

	public X5DataSourceFactory(String id, DataSourceFactory base, List<DataSourceReference> references, String name) {
		this(id, base, references);
		this.eClass = buildEClass(base, references, name);
	}

	public EPackage getEPackage() {
		if (ePackage == null) {
			ePackage = eClass.getEPackage() != null ? eClass.getEPackage() : buildEPackage();
		}
		return ePackage;
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
	public String getId() {
		return id;
	}

	private X5DataSourceFactory(String id, DataSourceFactory base, List<DataSourceReference> references) {
		this.id = id;
		this.base = base;
		this.references = new ArrayList<DataSourceReference>(references);
		this.clazz = findSourceClass(base);
	}

	private static EClass buildEClass(DataSourceFactory factory, List<DataSourceReference> references, String name) {
		EClass base = factory.getEClass();

		EClass eClass = EcoreFactory.eINSTANCE.createEClass();
		eClass.setName(name);
		eClass.getESuperTypes().add(base);

		for (DataSourceReference reference : references) {
			eClass.getEStructuralFeatures().add(reference.getEReference());
		}
		return eClass;
	}

	private static Class<? extends DataSource> findSourceClass(DataSourceFactory factory) {
		Class<? extends DataSource> clazz = factory.getSourceClass();
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

	private void validateEClass() {
		throw new UnsupportedOperationException();
	}

	@Override
	public X5DataSource create(Map<String, String> options) {
		DataSource base = this.base.create(options);
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

	private EPackage buildEPackage() {
		ePackage = EcoreFactory.eINSTANCE.createEPackage();
		ePackage.setName(getPackageName(id));
		ePackage.setNsURI("http://xored.com/x5/dynamic/" + id);
		ePackage.setNsPrefix(id);

		EPackage.Registry.INSTANCE.put(ePackage.getNsURI(), ePackage);
		for (EClass eClass : findAllClasses()) {
			if (eClass.getEPackage() != null) {
				throw new IllegalArgumentException("X5 EClass '" + eClass.getName() + "' already owned by '"
						+ eClass.getEPackage().getNsURI() + "' package");
			}
			ePackage.getEClassifiers().add(eClass);
		}
		return ePackage;
	}

	private String getPackageName(String id) {
		int index = id.lastIndexOf('.');
		if (index < 0 || index >= id.length() - 1) {
			return id;
		}
		return id.substring(index + 1);
	}

	private List<DataLink> createLinks() {
		List<DataLink> result = new ArrayList<DataLink>();
		for (DataSourceReference reference : references) {
			result.add(new DataLink(reference.getEReference(), reference.createSource()));
		}
		return result;
	}

	private List<EClass> findAllClasses() {
		List<EClass> result = new ArrayList<EClass>();
		result.add(getEClass());
		for (DataSourceReference reference : references) {
			DataSourceFactory factory = reference.getFactory();
			if (factory instanceof X5DataSourceFactory) {
				result.addAll(((X5DataSourceFactory) factory).findAllClasses());
			}
		}
		return result;
	}

	private String id;
	private EClass eClass;
	private Class<? extends DataSource> clazz;
	private DataSourceFactory base;
	private List<DataSourceReference> references;
	private EPackage ePackage;

}
