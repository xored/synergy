package com.xored.x5.sample.agent;

import java.io.IOException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;

import com.xored.sherlock.eclipse.core.SherlockCore;
import com.xored.x5.agent.Transport;
import com.xored.x5.agent.X5Agent;
import com.xored.x5.agent.tcp.TcpAgentTransport;

public class SampleAgentView extends ViewPart {

	@Override
	public void init(IViewSite site) throws PartInitException {
		super.init(site);
		try {
			transport = new TcpAgentTransport(7887);
		} catch (IOException e) {
			throw new PartInitException("Can't initialize tcp transport", e);
		}
	}

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout(1, false));
		text = new Text(parent, SWT.BORDER);
		agent = new X5Agent(transport, SherlockCore.getRegistry());
		agent.initialize();
	}

	@Override
	public void dispose() {
		agent.close();
		super.dispose();
	}

	@Override
	public void setFocus() {
		text.setFocus();
	}

	private Text text;
	private X5Agent agent;
	private Transport transport;

}
