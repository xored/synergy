package com.xored.x5.internal.core.builders;

import org.eclipse.emf.ecore.EReference;

import com.xored.x5.internal.core.DSDescriptor;

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
