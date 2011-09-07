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

	public Object getValue() {
		return ((List<?>) feature.getValue()).get(index);
	}

}
