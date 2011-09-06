package com.xored.x5.internal.agent.util;

import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public class EUtil {

	public static void copy(EObject from, EObject to) {
		for (EStructuralFeature feature : from.eClass().getEAllStructuralFeatures()) {
			copyFeature(from, to, feature);
		}
	}

	public static void copyFeature(EObject from, EObject to, EStructuralFeature feature) {
		EMapper mapper = feature instanceof EAttribute ? EMapper.attribute : EMapper.reference;
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

	public static boolean haveEqualFeature(EObject o1, EObject o2, EStructuralFeature feature) {
		X5EqualityHelper helper = new X5EqualityHelper();
		return helper.haveEqualFeature(o1, o2, feature);
	}

}
