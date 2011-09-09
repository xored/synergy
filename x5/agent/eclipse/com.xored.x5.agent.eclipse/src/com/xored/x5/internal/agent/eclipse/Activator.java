package com.xored.x5.internal.agent.eclipse;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.xored.sherlock.eclipse.core.SherlockCore;
import com.xored.x5.agent.Transport;
import com.xored.x5.agent.X5Agent;
import com.xored.x5.agent.tcp.TcpAgentTransport;

public class Activator implements BundleActivator {

	private static BundleContext context;

	private X5Agent agent;

	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext
	 * )
	 */
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		Transport transport = new TcpAgentTransport(7887);
		agent = new X5Agent(transport, SherlockCore.getRegistry());
		agent.initialize();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		agent.close();
		agent = null;
	}

}
