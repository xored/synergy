package com.xored.sherlock.sample.ui;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.part.ViewPart;

import com.xored.sherlock.core.DataSource;
import com.xored.sherlock.core.DataSourceFactory;
import com.xored.sherlock.core.DataSourceListener;
import com.xored.sherlock.core.EntityDataSource;
import com.xored.sherlock.core.EventDataSource;
import com.xored.sherlock.core.EventListener;
import com.xored.sherlock.core.ProcessDataSource;
import com.xored.sherlock.core.ProcessListener;
import com.xored.sherlock.eclipse.core.SherlockCore;

public class SherlockView extends ViewPart {

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout(1, false));
		tree = new BaseEObjectTree(parent);
		tree.getTree().setLayoutData(new GridData(GridData.FILL_BOTH));
		listener = new DataSourceListener() {
			@Override
			public void handleRemove(DataSourceFactory factory) {
				removeSource(factory.getId());
			}

			@Override
			public void handleAdd(DataSourceFactory factory) {
				addSource(factory);
			}
		};
		SherlockCore.getManager().addListener(listener);
		for (DataSourceFactory factory : SherlockCore.getManager().getFactories()) {
			addSource(factory);
		}
	}

	@Override
	public void dispose() {
		SherlockCore.getManager().removeListener(listener);
		for (Entry<String, SourceInfo> entry : sources.entrySet()) {
			removeItem(entry.getValue());
		}
		sources.clear();
		super.dispose();
	}

	private void addSource(DataSourceFactory factory) {
		final String id = factory.getId();
		final DataSource source = SherlockCore.getManager().getSource(id);
		tree.runInUI(new Runnable() {

			@Override
			public void run() {
				final TreeItem item = new TreeItem(tree.getTree(), SWT.LEFT);
				item.setText(id);

				SourceInfo info = new SourceInfo();
				info.source = source;
				info.item = item;
				sources.put(id, info);

				if (source instanceof EntityDataSource) {
					tree.addObject(((EntityDataSource) source).getData(), item);
				} else if (source instanceof EventDataSource) {
					EventDataSource es = (EventDataSource) source;
					EventListener listener = new EventListener() {
						@Override
						public void handle(final EObject event) {
							tree.addObject(event, item);
						}
					};
					info.listener = listener;
					es.addEventListener(listener);
				} else if (source instanceof ProcessDataSource) {
					ProcessDataSource es = (ProcessDataSource) source;
					ProcessListener listener = new ProcessListener() {

						private TreeItem pending;

						@Override
						public void handleStart(EObject data) {
							tree.runInUI(new Runnable() {
								@Override
								public void run() {
									pending = new TreeItem(item, 0);
									pending.setText("process...");
								}
							});
						}

						@Override
						public void handleFinish(final EObject data) {
							tree.runInUI(new Runnable() {
								@Override
								public void run() {
									pending.dispose();
									tree.addObject(data, item);
								}
							});
						}
					};
					info.listener = listener;
					es.addProcessListener(listener);
				}
			}
		});
	}

	private void removeSource(final String id) {
		tree.runInUI(new Runnable() {
			@Override
			public void run() {
				SourceInfo info = sources.remove(id);
				if (info != null) {
					removeItem(info);
				}
			}
		});
	}

	private void removeItem(SourceInfo info) {
		DataSource source = info.source;
		if (source instanceof EventDataSource) {
			EventListener listener = (EventListener) info.listener;
			((EventDataSource) source).removeEventListener(listener);
		} else if (source instanceof ProcessDataSource) {
			ProcessListener listener = (ProcessListener) info.listener;
			((ProcessDataSource) source).removeProcessListener(listener);
		}
		TreeItem item = info.item;
		if (!item.isDisposed()) {
			item.dispose();
		}
	}

	@Override
	public void setFocus() {
		tree.focus();
	}

	private class SourceInfo {
		TreeItem item;
		DataSource source;
		Object listener;
	}

	private Map<String, SourceInfo> sources = new HashMap<String, SherlockView.SourceInfo>();
	private DataSourceListener listener;
	private BaseEObjectTree tree;

}
