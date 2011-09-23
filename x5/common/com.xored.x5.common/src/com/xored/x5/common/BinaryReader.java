package com.xored.x5.common;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl;

public class BinaryReader {

	public BinaryReader(ResourceSet resourceSet, InputStream stream) {
		this.stream = stream;
		this.resourceSet = resourceSet;
	}

	public EObject read() throws IOException {
		Resource resource = new BinaryResourceImpl();
		resource.setURI(URI.createURI("mem://" + resource.hashCode()));
		resourceSet.getResources().add(resource);

		byte[] bytes = readBytes();
		if (bytes == null) {
			return null;
		}
		ByteArrayInputStream bin = new ByteArrayInputStream(bytes);
		resource.load(bin, null);
		EObject obj = resource.getContents().get(0);
		return obj;
	}

	private byte[] readBytes() throws IOException {
		DataInputStream in = new DataInputStream(stream);
		int len;
		try {
			len = in.readInt();
		} catch (Exception e) {
			// connection was closed
			return null;
		}
		byte[] result = new byte[len];
		in.readFully(result);
		return result;
	}

	private InputStream stream;
	private ResourceSet resourceSet;

}
