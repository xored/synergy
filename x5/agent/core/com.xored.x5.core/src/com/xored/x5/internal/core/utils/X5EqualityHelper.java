package com.xored.x5.internal.core.utils;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil.EqualityHelper;

public class X5EqualityHelper extends EqualityHelper {

	private static final long serialVersionUID = 1L;

	@Override
	public boolean haveEqualFeature(EObject eObject1, EObject eObject2, EStructuralFeature feature) {
		return super.haveEqualFeature(eObject1, eObject2, feature);
	}

}
