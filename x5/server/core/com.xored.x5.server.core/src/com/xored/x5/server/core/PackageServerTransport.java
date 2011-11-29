package com.xored.x5.server.core;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.xored.sherlock.status.StatusUtil;
import com.xored.x5.common.DataSourceEntry;
import com.xored.x5.common.PackageEntry;
import com.xored.x5.common.PingEntry;

public class PackageServerTransport implements ServerTransport {

	public PackageServerTransport(ServerTransport transport) {
		this.transport = transport;
	}

	@Override
	public Session accept() throws Exception {
		return new PackageSession(transport.accept());
	}

	@Override
	public void close() {
		transport.close();
	}

	private class PackageSession implements Session {

		public PackageSession(Session session) {
			this.session = session;
		}

		@Override
		public void initialize(ResourceSet resourceSet) throws Exception {
			this.resourceSet = resourceSet;
			session.initialize(resourceSet);
		}

		@Override
		public boolean handle(RequestHandler handler) throws Exception {
			return session.handle(new PackageRequestHandler(resourceSet, handler));
		}

		@Override
		public void close() {
			session.close();
		}

		private Session session;
		private ResourceSet resourceSet;

	}

	private class PackageRequestHandler implements RequestHandler {

		public PackageRequestHandler(ResourceSet resourceSet, RequestHandler handler) {
			this.resourceSet = resourceSet;
			this.handler = handler;
		}

		@Override
		public EObject handle(EObject request) {
			try {
				if (request instanceof DataSourceEntry) {
					DataSourceEntry entry = (DataSourceEntry) request;
					return handler.handle(entry.getContent());
				} else if (request instanceof PackageEntry) {
					EPackage ePackage = EcoreUtil.copy(((PackageEntry) request).getContent());
					Resource fake = new ResourceImpl(URI.createURI(ePackage.getNsURI()));
					fake.getContents().add(ePackage);
					resourceSet.getPackageRegistry().put(ePackage.getNsURI(), ePackage);
					resourceSet.getResources().add(fake);
					return StatusUtil.newOkStatus();
				} else if (request instanceof PingEntry) {
					// do nothing, just send OK
					return StatusUtil.newOkStatus();
				} else {
					return StatusUtil.newErrorStatus(TARGET, "Unexpected data: " + request);
				}
			} catch (Exception e) {
				return StatusUtil.newErrorStatus(TARGET, e, "Error while handle client request: " + request);
			}
		}

		private RequestHandler handler;
		private ResourceSet resourceSet;

	}

	private ServerTransport transport;

	private static final String TARGET = PackageServerTransport.class.getPackage().getName();

}
