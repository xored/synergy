package com.xored.x5.internal.agent.sources;

import org.eclipse.emf.ecore.EReference;

public class DataLinkDescriptor {

	public DataLinkDescriptor(EReference reference, DSDescriptor descriptor) {
		this.reference = reference;
		this.descriptor = descriptor;
	}

	public EReference getReference() {
		return reference;
	}

	public DSDescriptor getDescriptor() {
		return descriptor;
	}

	public DataLink createLink() {
		return new DataLink(reference, descriptor.createSource());
	}

	private EReference reference;
	private DSDescriptor descriptor;

}
