package com.xored.x5.internal.agent.sources;

import org.eclipse.emf.ecore.EReference;

import com.xored.sherlock.core.DataSource;

public class DataLink {

	public DataLink(EReference eRef, DataSource source) {
		this.eRef = eRef;
		this.source = source;
	}

	public DataSource getSource() {
		return source;
	}

	public EReference getEReference() {
		return eRef;
	}

	private EReference eRef;
	private DataSource source;

}
