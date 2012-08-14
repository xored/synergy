package com.xored.x5.common;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

public class BinaryReader {

	public BinaryReader(ResourceSet resourceSet, InputStream stream) {
		this.stream = stream;
		this.resourceSet = resourceSet;
	}

	public EObject read() throws IOException {
		Resource resource = new X5BinaryResourceImpl();
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
		if (len < 0) {
			throw new IOException("Expect size of data block but found: " + len);
		}
		try {
			byte[] result = new byte[len];
			in.readFully(result);
			return result;
		} catch (OutOfMemoryError e) {
			throw new IOException(
					"Couldn't allocate data block with the following size: "
							+ len, e);
		}
	}

	private InputStream stream;
	private ResourceSet resourceSet;

}
