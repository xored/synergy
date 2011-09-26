package com.xored.x5.sample.transport;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.xored.sherlock.status.StatusUtil;
import com.xored.x5.server.core.RequestHandler;
import com.xored.x5.server.core.ServerTransport;
import com.xored.x5.server.core.Session;

public class SampleServerTransport implements ServerTransport {

	@Override
	public Session accept() throws Exception {
		return new SampleSession(queue.take());
	}

	@Override
	public void close() {
	}

	public EObject notify(EObject data) {
		queue.add(data);
		return StatusUtil.newOkStatus();
	}

	private BlockingQueue<EObject> queue = new LinkedBlockingQueue<EObject>();

	private class SampleSession implements Session {

		public SampleSession(EObject data) {
			this.data = data;
		}

		@Override
		public void initialize(ResourceSet resourceSet) throws Exception {
		}

		@Override
		public boolean handle(RequestHandler handler) throws Exception {
			if (data != null) {
				handler.handle(data);
				data = null;
				return true;
			}
			return false;
		}

		@Override
		public void close() {
		}

		private EObject data;

	}

}
