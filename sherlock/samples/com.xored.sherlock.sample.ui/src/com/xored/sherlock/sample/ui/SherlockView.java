package com.xored.sherlock.sample.ui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.part.ViewPart;

import com.xored.sherlock.core.DataSource;
import com.xored.sherlock.core.DataSourceFactory;
import com.xored.sherlock.core.DataSourceListener;
import com.xored.sherlock.core.DataSourceRegistry;
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
		viewer = new TreeViewer(parent);
		viewer.getTree().setLayoutData(new GridData(GridData.FILL_BOTH));
		viewer.setContentProvider(new SourceContentProvider());
		viewer.setLabelProvider(new SourceLabelProvider());
		listener = new DataSourceListener() {
			@Override
			public void handleRemove(final DataSourceFactory factory) {
				runInUI(new Runnable() {
					@Override
					public void run() {
						removeSource(factory.getId());
					}
				});
			}

			@Override
			public void handleAdd(final DataSourceFactory factory) {
				runInUI(new Runnable() {
					@Override
					public void run() {
						addSource(factory);
						viewer.refresh();
					}
				});
			}
		};
		DataSourceRegistry registry = SherlockCore.getRegistry();
		Collection<DataSourceFactory> factories;
		synchronized (registry) {
			factories = registry.getFactories();
			registry.addListener(listener);
		}
		for (DataSourceFactory factory : factories) {
			addSource(factory);
		}
		viewer.setInput(sources);
	}

	@Override
	public void dispose() {
		SherlockCore.getRegistry().removeListener(listener);
		for (Entry<String, SourceInfo> entry : sources.entrySet()) {
			removeItem(entry.getValue());
		}
		sources.clear();
		super.dispose();
	}

	private void addSource(DataSourceFactory factory) {
		final String id = factory.getId();
		final DataSource source = SherlockCore.getRegistry().getSource(id);
		final SourceInfo info = new SourceInfo(id, source);
		sources.put(id, info);

		if (source instanceof EntityDataSource) {
			info.content.add(((EntityDataSource) source).getData());
		} else if (source instanceof EventDataSource) {
			EventDataSource es = (EventDataSource) source;
			EventListener listener = new EventListener() {
				@Override
				public void handle(final EObject event) {
					runInUI(new Runnable() {

						@Override
						public void run() {
							info.content.add(event);
							viewer.refresh(info, false);
						}
					});
				}
			};
			info.listener = listener;
			es.addEventListener(listener);
		} else if (source instanceof ProcessDataSource) {
			ProcessDataSource es = (ProcessDataSource) source;
			ProcessListener listener = new ProcessListener() {

				@Override
				public void handleStart(EObject data) {
				}

				@Override
				public void handleFinish(final EObject data) {
					runInUI(new Runnable() {
						@Override
						public void run() {
							info.content.add(data);
							viewer.refresh(info, false);
						}
					});
				}
			};
			info.listener = listener;
			es.addProcessListener(listener);
		}
	}

	private void removeSource(final String id) {
		SourceInfo info = sources.remove(id);
		if (info != null) {
			removeItem(info);
			viewer.refresh(info, false);
		}
	}

	private void removeItem(SourceInfo info) {
		info.dispose();
	}

	@Override
	public void setFocus() {
		viewer.getTree().setFocus();
	}

	public void runInUI(final Runnable runnable) {
		Tree tree = viewer.getTree();
		if (!tree.isDisposed()) {
			Display display = tree.getDisplay();
			if (Thread.currentThread() == display.getThread()) {
				runnable.run();
			} else {
				display.asyncExec(new Runnable() {
					@Override
					public void run() {
						if (!viewer.getTree().isDisposed()) {
							runnable.run();
						}
					}
				});
			}
		}
	}

	private class SourceInfo {

		SourceInfo(String id, DataSource source) {
			this.id = id;
			this.source = source;
		}

		String id;
		DataSource source;
		List<EObject> content = new ArrayList<EObject>();
		Object listener;

		void dispose() {
			if (source instanceof EventDataSource) {
				EventListener listener = (EventListener) this.listener;
				((EventDataSource) source).removeEventListener(listener);
			} else if (source instanceof ProcessDataSource) {
				ProcessListener listener = (ProcessListener) this.listener;
				((ProcessDataSource) source).removeProcessListener(listener);
			}
		}
	}

	private class SourceContentProvider extends EContentProvider {

		@Override
		public Object[] getElements(Object inputElement) {
			return sources.values().toArray();
		}

		@Override
		public Object[] getChildren(Object parent) {
			if (parent instanceof SourceInfo) {
				return ((SourceInfo) parent).content.toArray();
			}
			return super.getChildren(parent);
		}

	}

	private class SourceLabelProvider extends ELabelProvider {
		@Override
		public String getText(Object element) {
			if (element instanceof SourceInfo) {
				return ((SourceInfo) element).id;
			}
			return super.getText(element);
		}
	}

	private Map<String, SourceInfo> sources = new LinkedHashMap<String, SherlockView.SourceInfo>();
	private DataSourceListener listener;
	private TreeViewer viewer;

}
