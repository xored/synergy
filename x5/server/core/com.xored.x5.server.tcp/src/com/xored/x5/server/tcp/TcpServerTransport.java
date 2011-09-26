package com.xored.x5.server.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.xored.x5.common.BinaryReader;
import com.xored.x5.common.BinaryWriter;
import com.xored.x5.server.core.ServerTransport;
import com.xored.x5.server.core.Session;

public class TcpServerTransport implements ServerTransport {

	public TcpServerTransport(int port) throws IOException {
		this.port = port;
		server = new ServerSocket(port);
	}

	@Override
	public String toString() {
		return "TCP server (port=" + port + ")";
	}

	@Override
	public Session accept() throws Exception {
		return new TcpSession(server.accept());
	}

	@Override
	public void close() {
		try {
			server.close();
		} catch (Exception e) {
			// ignore close exception
		}
	}

	private static class TcpSession implements Session {

		public TcpSession(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void initialize(ResourceSet resourceSet) throws Exception {
			reader = new BinaryReader(resourceSet, socket.getInputStream());
			writer = new BinaryWriter(resourceSet, socket.getOutputStream());
		}

		@Override
		public EObject getRequest() throws Exception {
			return reader.read();
		}

		@Override
		public void setResponse(EObject eObject) throws Exception {
			writer.write(eObject);
		}

		@Override
		public void close() {
			try {
				socket.close();
			} catch (IOException e) {
				// ignore close exceptions
			}
		}

		private BinaryReader reader;
		private BinaryWriter writer;

		private Socket socket;

	}

	private ServerSocket server;
	private int port;

}
