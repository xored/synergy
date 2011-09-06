package com.xored.x5.sample.transport;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import com.xored.sherlock.core.DataSource;
import com.xored.sherlock.core.DataSourceFactory;
import com.xored.sherlock.core.DataSourceListener;
import com.xored.sherlock.eclipse.core.SherlockCore;
import com.xored.sherlock.sample.ui.BaseEObjectTree;
import com.xored.x5.agent.X5Agent;
import com.xored.x5.server.Server;

public class SampleServerView extends ViewPart {

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout(2, false));

		combo = new Combo(parent, SWT.READ_ONLY);
		combo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String id = combo.getItem(combo.getSelectionIndex());
				source = sources.get(id);
				if (source != null) {
					button.setEnabled(true);
					button.setText("Start");
				} else {
					button.setEnabled(false);
				}
			}
		});
		combo.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		button = new Button(parent, SWT.LEFT);
		button.setText("Start");
		button.setEnabled(false);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (agent != null) {
					agent.close();
					agent = null;
					if (source == null) {
						button.setEnabled(false);
					} else {
						button.setEnabled(true);
						button.setText("Start");
					}
				} else if (source != null) {
					button.setText("Finish");
					agent = new X5Agent(agentTransport, SherlockCore.getRegistry());
					agent.initialize();
				}
			}
		});

		tree = new BaseEObjectTree(parent);
		tree.getTree().setLayoutData(GridDataFactory.fillDefaults().grab(true, true).span(2, 1).create());

		server = new Server(serverTransport) {

			@Override
			protected void handle(EObject object) {
				tree.addObject(object);
			}
		};
		server.initialize();
		listen();
	}

	protected void listen() {
		listener = new DataSourceListener() {
			@Override
			public void handleRemove(DataSourceFactory factory) {
			}

			@Override
			public void handleAdd(DataSourceFactory factory) {
				addSource(factory);
			}
		};
		SherlockCore.getRegistry().addListener(listener);
		for (DataSourceFactory factory : SherlockCore.getRegistry().getFactories()) {
			addSource(factory);
		}
	}

	protected void addSource(DataSourceFactory factory) {
		final String id = factory.getId();
		final DataSource source = SherlockCore.getRegistry().getSource(id);
		tree.runInUI(new Runnable() {

			@Override
			public void run() {
				sources.put(id, source);
				combo.add(id);
				combo.select(combo.getItemCount() - 1);
			}
		});
	}

	@Override
	public void dispose() {
		SherlockCore.getRegistry().removeListener(listener);
		if (agent != null) {
			agent.close();
		}
		super.dispose();
	}

	@Override
	public void setFocus() {
		tree.focus();
	}

	private BaseEObjectTree tree;
	private SampleServerTransport serverTransport = new SampleServerTransport();
	private SampleAgentTransport agentTransport = new SampleAgentTransport(serverTransport);
	private Server server;
	private Combo combo;
	private Button button;
	private DataSource source;
	private X5Agent agent;
	private Map<String, DataSource> sources = new HashMap<String, DataSource>();
	private DataSourceListener listener;

}
