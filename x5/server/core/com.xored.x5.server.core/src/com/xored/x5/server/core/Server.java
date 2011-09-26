package com.xored.x5.server.core;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import com.xored.sherlock.status.StatusUtil;
import com.xored.x5.common.CommonPackage;
import com.xored.x5.common.Log;

public abstract class Server {

	public Server(Log log) {
		this.log = log;
		executor = Executors.newCachedThreadPool();
	}

	public void start(final ServerTransport transport) {
		TransportTask task = new TransportTask(transport);
		TransportTask oldTask = tasks.put(transport, task);
		if (oldTask != null) {
			oldTask.stop();
		}
		executor.submit(task);
	}

	public void stop(final ServerTransport transport) {
		TransportTask task = tasks.remove(transport);
		if (task != null) {
			task.stop();
		}
	}

	protected abstract EObject handle(EObject object);

	public void close() {
		executor.shutdownNow();
	}

	private class TransportTask implements Runnable {

		private ServerTransport transport;
		private Thread thread;
		private boolean stop;

		public TransportTask(ServerTransport transport) {
			this.transport = transport;
		}

		@Override
		public void run() {
			try {
				synchronized (this) {
					if (stop) {
						safeClose();
						return;
					}
					thread = Thread.currentThread();
				}
				while (true) {
					Session session = transport.accept();
					executor.submit(new SessionTask(transport, session));
				}
			} catch (InterruptedException e) {
				safeClose();
			} catch (Exception e) {
				safeClose();
				handleTransportException(transport, e);
			}
		}

		public synchronized void stop() {
			if (thread != null) {
				thread.interrupt();
			} else {
				stop = true;
			}
		}

		private void safeClose() {
			try {
				transport.close();
			} catch (Exception e) {
				// ignore any closing exception
			}
		}

	}

	private class SessionTask implements Runnable {

		public SessionTask(ServerTransport transport, Session session) {
			this.transport = transport;
			this.session = session;
		}

		@Override
		public void run() {
			try {
				try {
					resourceSet = new ResourceSetImpl();
					resourceSet.getPackageRegistry().put("http://xored.com/x5/common.ecore", CommonPackage.eINSTANCE);
					session.initialize(resourceSet);
					RequestHandler handler = new RequestHandler() {
						@Override
						public EObject handle(EObject request) {
							return Server.this.handle(request);
						}
					};
					while (session.handle(handler)) {
					}
				} catch (InterruptedException e) {
					// ignore. it's normal shutdown
				} catch (Exception e) {
					handleTransportException(transport, e);
				}
			} finally {
				safeClose();
			}
		}

		private void safeClose() {
			try {
				session.close();
			} catch (Exception e) {
				// ignore any closing exception
			}
		}

		private ResourceSet resourceSet;
		private Session session;
		private ServerTransport transport;

	}

	private void handleTransportException(ServerTransport transport, Exception e) {
		e.printStackTrace();
		log.log(StatusUtil.newErrorStatus("com.xored.x5.server.core", e, "Server transport error: " + transport));
	}

	private final ExecutorService executor;
	private Map<ServerTransport, TransportTask> tasks = Collections
			.synchronizedMap(new HashMap<ServerTransport, TransportTask>());

	private Log log;

}
