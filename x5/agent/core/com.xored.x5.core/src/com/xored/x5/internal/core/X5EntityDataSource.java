package com.xored.x5.internal.core;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import com.xored.sherlock.core.DataSourceManager;
import com.xored.sherlock.core.EntityDataSource;
import com.xored.x5.core.CompositeDataSource;
import com.xored.x5.core.DataSourceReference;

public class X5EntityDataSource extends X5DataSource implements EntityDataSource {

	public X5EntityDataSource(DataSourceManager manager, CompositeDataSource descriptor, EntityDataSource source) {
		super(manager, descriptor);
		this.source = source;
	}

	@Override
	public EObject getData() {
		EObject data = source.getData();
		EObject result = createData(data);
		EClass eClass = result.eClass();
		for (DataSourceReference reference : descriptor.getReferences()) {
			EntityDataSource source = (EntityDataSource) getSource(reference.getSource());
			EObject object = source.getData();
			EReference ref = (EReference) eClass.getEStructuralFeature(reference.getName());
			ref.setEType(object.eClass());
			result.eSet(ref, object);
		}
		return result;
	}

	private EntityDataSource source;

}
