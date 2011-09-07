package com.xored.x5.sample.transport;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import com.xored.sherlock.eclipse.core.SherlockCore;
import com.xored.sherlock.sample.ui.BaseEObjectTree;
import com.xored.sherlock.sample.ui.EContentProvider;
import com.xored.x5.agent.X5Agent;
import com.xored.x5.server.Server;

public class SampleServerView extends ViewPart {

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout(2, false));

		tree = new BaseEObjectTree(parent);
		tree.getTree().setLayoutData(GridDataFactory.fillDefaults().grab(true, true).span(2, 1).create());

		server = new Server(serverTransport) {

			@Override
			protected void handle(EObject object) {
				tree.addObject(object);
			}
		};
		server.initialize();

		agent = new X5Agent(agentTransport, SherlockCore.getRegistry());
		agent.initialize();
	}

	@Override
	public void dispose() {
		if (agent != null) {
			agent.close();
			agent = null;
		}
		super.dispose();
	}

	@Override
	public void setFocus() {
		tree.focus();
	}
	
	private class ServerContentProvider extends EContentProvider {
		
	}

	private BaseEObjectTree tree;
	private SampleServerTransport serverTransport = new SampleServerTransport();
	private SampleAgentTransport agentTransport = new SampleAgentTransport(serverTransport);
	private Server server;
	private X5Agent agent;

}
