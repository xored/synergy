package com.xored.sherlock.sample.ui;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public class FeatureValue {

	public FeatureValue(EObject owner, EStructuralFeature feature) {
		this.owner = owner;
		this.feature = feature;
	}

	public EObject getOwner() {
		return owner;
	}

	public EStructuralFeature getFeature() {
		return feature;
	}

	public Object getValue() {
		return owner.eGet(feature);
	}

	private EObject owner;
	private EStructuralFeature feature;

}
