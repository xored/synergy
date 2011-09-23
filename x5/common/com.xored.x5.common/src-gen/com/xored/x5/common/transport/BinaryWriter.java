package com.xored.x5.common.transport;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl;

public class BinaryWriter {

	public BinaryWriter(OutputStream stream) {
		this.stream = stream;
	}

	public void write(EObject eObject) throws IOException {
		Resource r = new BinaryResourceImpl();
		r.getContents().add(eObject);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		r.save(out, null);
		writeData(out.toByteArray());
	}

	private void writeData(byte[] data) throws IOException {
		DataOutputStream out = new DataOutputStream(stream);
		out.writeInt(data.length);
		out.write(data);
		out.flush();
	}

	private OutputStream stream;

}
