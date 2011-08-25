package com.xored.x5.internal.core;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;

import com.xored.sherlock.core.DataSource;
import com.xored.sherlock.core.DataSourceManager;
import com.xored.x5.core.BaseDataSource;
import com.xored.x5.core.CompositeDataSource;
import com.xored.x5.core.DataSourceReference;
import com.xored.x5.core.X5SourceFactory;

public class X5DataSource implements DataSource {

	public X5DataSource(DataSourceManager manager, CompositeDataSource descriptor) {
		this.manager = manager;
		this.descriptor = descriptor;
	}

	protected EObject createData(EObject object) {
		EClass base = object.eClass();
		EClass eClass = createClass(base);
		DynamicFactPackage.getInstance().addClass(eClass);

		DynamicEObjectImpl result = new DynamicEObjectImpl(eClass);
		for (EStructuralFeature feature : base.getEAllStructuralFeatures()) {
			EMapper mapper = feature instanceof EAttribute ? EMapper.attribute : EMapper.reference;
			if (feature.isMany()) {
				@SuppressWarnings("unchecked")
				List<Object> resList = (List<Object>) result.eGet(feature);
				@SuppressWarnings("unchecked")
				List<Object> objList = (List<Object>) object.eGet(feature);
				for (Object obj : objList) {
					resList.add(mapper.map(obj));
				}
			} else {
				result.eSet(feature, mapper.map(object.eGet(feature)));
			}
		}

		return result;
	}

	protected DataSource getSource(BaseDataSource source) {
		return X5SourceFactory.create(manager, source);
	}

	protected EClass createClass(EClass base) {
		EClass eClass = EcoreFactory.eINSTANCE.createEClass();
		eClass.setName(descriptor.getName());
		eClass.getESuperTypes().add(base);

		for (DataSourceReference reference : descriptor.getReferences()) {
			eClass.getEStructuralFeatures().add(createReference(reference));
		}
		return eClass;
	}

	protected EReference createReference(DataSourceReference reference) {
		EReference ref = EcoreFactory.eINSTANCE.createEReference();
		ref.setName(reference.getName());
		ref.setContainment(true);
		return ref;
	}

	@Override
	public void initialize(Map<String, String> options) {
	}

	protected CompositeDataSource descriptor;
	protected DataSourceManager manager;

}
