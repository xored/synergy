package com.xored.x5.internal.core.builders;

import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.xored.sherlock.core.EntityDataSource;

public class EntityDataBuilder extends DataBuilder {

	public EntityDataBuilder(EClass eClass, List<DataLink> links) {
		super(eClass, links);
	}

	public EObject build(EObject data) {
		EObject result = createInstance();
		copy(data, result);
		firePrepare(result);
		for (DataLink link : links) {
			EntityDataSource source = (EntityDataSource) link.getSource();
			result.eSet(link.getEReference(), source.getData());
		}
		firePush(result);
		return result;
	}

	protected void copy(EObject from, EObject to) {
		for (EStructuralFeature feature : from.eClass().getEAllStructuralFeatures()) {
			EMapper mapper = feature instanceof EAttribute ? attribute : reference;
			if (feature.isMany()) {
				@SuppressWarnings("unchecked")
				List<Object> resList = (List<Object>) to.eGet(feature);
				@SuppressWarnings("unchecked")
				List<Object> objList = (List<Object>) from.eGet(feature);
				for (Object obj : objList) {
					resList.add(mapper.map(obj));
				}
			} else {
				to.eSet(feature, mapper.map(from.eGet(feature)));
			}
		}
	}

	interface EMapper {

		Object map(Object o);

	}

	static class AttrMapper implements EMapper {
		@Override
		public Object map(Object o) {
			return o;
		}
	}

	static class RefMapper implements EMapper {
		@Override
		public Object map(Object o) {
			return EcoreUtil.copy((EObject) o);
		}
	}

	static AttrMapper attribute = new AttrMapper();

	static RefMapper reference = new RefMapper();

}
