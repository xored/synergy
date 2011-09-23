package com.xored.x5.agent.tcp;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.xored.x5.agent.core.Transport;
import com.xored.x5.common.BinaryReader;
import com.xored.x5.common.BinaryWriter;

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

	@Override
	public void initialize(ResourceSet resourceSet) throws IOException {
		reader = new BinaryReader(resourceSet, socket.getInputStream());
		writer = new BinaryWriter(resourceSet, socket.getOutputStream());
	}

	public TcpAgentTransport(int port, InetAddress host, int timeout) throws IOException {
		InetSocketAddress addr = new InetSocketAddress(host, port);
		socket = new Socket();
		socket.connect(addr, timeout);
	}

	public EObject send(EObject eObject) throws IOException {
		writer.write(eObject);
		return reader.read();
	}

	private BinaryReader reader;
	private BinaryWriter writer;

	private Socket socket;

}
