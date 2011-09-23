package com.xored.x5.common.transport;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl;

public class BinaryReader {

	public BinaryReader(InputStream stream) {
		this.stream = stream;
	}

	public EObject read() throws IOException {
		Resource r = new BinaryResourceImpl();
		byte[] bytes = readBytes();
		if (bytes == null) {
			return null;
		}
		ByteArrayInputStream bin = new ByteArrayInputStream(bytes);
		r.load(bin, null);
		EObject obj = r.getContents().get(0);
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

}
