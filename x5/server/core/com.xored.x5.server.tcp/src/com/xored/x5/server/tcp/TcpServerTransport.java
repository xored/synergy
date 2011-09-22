package com.xored.x5.server.tcp;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl;

import com.xored.x5.server.core.ServerTransport;

public class TcpServerTransport extends ServerTransport {

	public TcpServerTransport(int port) throws IOException {
		final ServerSocket server = new ServerSocket(port);
		final ExecutorService executor = Executors.newCachedThreadPool();
		executor.submit(new Runnable() {

			public void run() {
				try {
					while (true) {
						final Socket client = server.accept();
						executor.submit(new Runnable() {
							@Override
							public void run() {
								try {
									EObject object;
									while ((object = readObject(client)) != null) {
										TcpServerTransport.this.notify(object);
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
					}
				} catch (IOException e) {
					e.printStackTrace();
					executor.shutdown();
				}
			}
		});
	}

	private static EObject readObject(Socket socket) throws IOException {
		Resource r = new BinaryResourceImpl();
		byte[] bytes = readBytes(socket);
		if (bytes == null) {
			return null;
		}
		ByteArrayInputStream bin = new ByteArrayInputStream(bytes);
		r.load(bin, null);
		EObject obj = r.getContents().get(0);
		return obj;
	}

	private static byte[] readBytes(Socket socket) throws IOException {
		DataInputStream in = new DataInputStream(socket.getInputStream());
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

}
