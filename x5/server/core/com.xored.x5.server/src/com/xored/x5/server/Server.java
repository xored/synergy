package com.xored.x5.server;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.xored.x5.common.CommonPackage;
import com.xored.x5.common.DataSourceEntry;
import com.xored.x5.common.PackageEntry;

public abstract class Server {

	public Server(ServerTransport transport) {
		this.transport = transport;
		EPackage.Registry.INSTANCE.put("http://xored.com/x5/common.ecore", CommonPackage.eINSTANCE);
	}

	protected abstract void handle(String id, EObject object);

	public void initialize() {
		transport.setHandler(new Handler());
	}

	public void close() {
		transport.close();
	}

	private class Handler implements RequestHandler {

		@Override
		public void handle(EObject data) {
			if (data instanceof DataSourceEntry) {
				DataSourceEntry entry = (DataSourceEntry) data;
				Server.this.handle(entry.getSource(), entry.getContent());
			} else if (data instanceof PackageEntry) {
				EPackage ePackage = EcoreUtil.copy(((PackageEntry) data).getContent());
				Resource fake = new ResourceImpl(URI.createURI(ePackage.getNsURI()));
				fake.getContents().add(ePackage);
				EPackage.Registry.INSTANCE.put(ePackage.getNsURI(), ePackage);
			}
		}

	}

	private ServerTransport transport;

}
