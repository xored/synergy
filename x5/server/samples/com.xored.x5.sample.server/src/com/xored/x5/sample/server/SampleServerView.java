package com.xored.x5.sample.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.part.ViewPart;

import com.xored.sherlock.sample.ui.EContentProvider;
import com.xored.sherlock.sample.ui.ELabelProvider;
import com.xored.sherlock.status.StatusUtil;
import com.xored.x5.common.DefaultLog;
import com.xored.x5.server.core.Server;
import com.xored.x5.server.tcp.TcpServerTransport;

public class SampleServerView extends ViewPart {

	@Override
	public void init(IViewSite site) throws PartInitException {
		super.init(site);
		try {
			transport = new TcpServerTransport("com.xored.x5.sample.server", 7887);
		} catch (IOException e) {
			throw new PartInitException("Can't initialize tcp transport", e);
		}
	}

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout(1, false));

		tree = new FilteredTree(parent, SWT.BORDER, new WeakPatternFilter(), true);
		final TreeViewer viewer = tree.getViewer();
		viewer.setContentProvider(new ServerContentProvider());
		viewer.setLabelProvider(new ServerLabelProvider());

		viewer.getTree().setLayoutData(new GridData(GridData.FILL_BOTH));

		server = new Server(DefaultLog.INSTANCE) {

			@Override
			protected EObject handle(final String id, final EObject object) {
				runInUI(new Runnable() {

					@Override
					public void run() {
						DataEntity entry = new DataEntity(id, object);
						entities.add(entry);
						viewer.add(entities, entry);
					}
				});
				return StatusUtil.newOkStatus();
			}
		};
		server.start(transport);
		viewer.setInput(entities);
	}

	@Override
	public void dispose() {
		server.close();
		super.dispose();
	}

	@Override
	public void setFocus() {
		tree.getViewer().getTree().setFocus();
	}

	public void runInUI(final Runnable runnable) {
		final Tree tree = this.tree.getViewer().getTree();
		if (!tree.isDisposed()) {
			Display display = tree.getDisplay();
			if (Thread.currentThread() == display.getThread()) {
				runnable.run();
			} else {
				display.asyncExec(new Runnable() {
					@Override
					public void run() {
						if (!tree.isDisposed()) {
							runnable.run();
						}
					}
				});
			}
		}
	}

	private class DataEntity {

		public DataEntity(String id, EObject data) {
			this.id = id;
			this.data = data;
		}

		private EObject data;
		private String id;

	}

	private List<DataEntity> entities = new ArrayList<DataEntity>();

	private class ServerContentProvider extends EContentProvider {

		@Override
		public Object[] getElements(Object inputElement) {
			return entities.toArray();
		}

		@Override
		public Object[] getChildren(Object parent) {
			if (parent instanceof DataEntity) {
				parent = ((DataEntity) parent).data;
			}
			return super.getChildren(parent);
		}

	}

	private class ServerLabelProvider extends ELabelProvider {

		@Override
		public String getText(Object element) {
			if (element instanceof DataEntity) {
				DataEntity entity = (DataEntity) element;
				return entity.id + ": " + super.getText(entity.data);
			}
			return super.getText(element);
		}

	}

	private FilteredTree tree;
	private Server server;
	private TcpServerTransport transport;

}
