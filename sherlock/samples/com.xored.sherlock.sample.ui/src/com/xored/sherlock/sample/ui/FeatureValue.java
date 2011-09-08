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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((feature == null) ? 0 : feature.hashCode());
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FeatureValue other = (FeatureValue) obj;
		if (feature == null) {
			if (other.feature != null)
				return false;
		} else if (!feature.equals(other.feature))
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		return true;
	}

	private EObject owner;
	private EStructuralFeature feature;

}
