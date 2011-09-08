package com.xored.x5.agent.tcp;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl;

import com.xored.x5.agent.Transport;

public class TcpAgentTransport implements Transport {

	public TcpAgentTransport(int port) throws IOException {
		this(port, InetAddress.getLocalHost(), 0);
	}

	public TcpAgentTransport(int port, String host) throws IOException {
		this(port, host, 0);
	}

	public TcpAgentTransport(int port, String host, int timeout) throws IOException {
		this(port, InetAddress.getByName(host), timeout);
	}

	public TcpAgentTransport(int port, InetAddress host) throws IOException {
		this(port, host, 0);
	}

	public TcpAgentTransport(int port, InetAddress host, int timeout) throws IOException {
		InetSocketAddress addr = new InetSocketAddress(host, port);
		socket = new Socket();
		socket.connect(addr, timeout);
	}

	public void send(EObject object) {
		try {
			writeObject(object);
		} catch (IOException e) {
			throw new RuntimeException("Can't send object '" + object + "'", e);
		}
	}

	private void writeObject(EObject obj) throws IOException {
		Resource r = new BinaryResourceImpl();
		r.getContents().add(obj);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		r.save(out, null);
		writeData(out.toByteArray());
	}

	private void writeData(byte[] data) throws IOException {
		DataOutputStream out = new DataOutputStream(socket.getOutputStream());
		out.writeInt(data.length);
		out.write(data);
		out.flush();
	}

	private Socket socket;

}
