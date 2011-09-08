package com.xored.sherlock.sample.ui;

import java.util.List;

public class FeatureElement {

	private FeatureValue feature;
	private int index;

	public FeatureElement(FeatureValue feature, int index) {
		this.feature = feature;
		this.index = index;
	}

	public FeatureValue getFeature() {
		return feature;
	}

	public int getIndex() {
		return index;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((feature == null) ? 0 : feature.hashCode());
		result = prime * result + index;
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
		FeatureElement other = (FeatureElement) obj;
		if (feature == null) {
			if (other.feature != null)
				return false;
		} else if (!feature.equals(other.feature))
			return false;
		if (index != other.index)
			return false;
		return true;
	}

	public Object getValue() {
		return ((List<?>) feature.getValue()).get(index);
	}

}
