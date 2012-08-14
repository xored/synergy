package com.xored.x5.common;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

public class BinaryWriter {

	public BinaryWriter(ResourceSet resourceSet, OutputStream stream) {
		this.stream = stream;
		this.resourceSet = resourceSet;
	}

	public void write(EObject eObject) throws IOException {
		Resource resource = new X5BinaryResourceImpl();
		resource.setURI(URI.createURI("mem://" + resource.hashCode()));
		resourceSet.getResources().add(resource);
		resource.getContents().add(eObject);

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		resource.save(out, null);
		writeData(out.toByteArray());
	}

	private void writeData(byte[] data) throws IOException {
		DataOutputStream out = new DataOutputStream(stream);
		out.writeInt(data.length);
		out.write(data);
		out.flush();
	}

	private OutputStream stream;
	private ResourceSet resourceSet;

}
