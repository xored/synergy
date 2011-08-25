package com.xored.sherlock.sample.ui;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Tree;
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
		tree = new Tree(parent, SWT.BORDER);
		tree.setLayoutData(new GridData(GridData.FILL_BOTH));

		SherlockCore.getManager().addListener(new DataSourceListener() {
			@Override
			public void handleRemove(String id, DataSourceFactory source) {
				removeSource(id);
			}

			@Override
			public void handleAdd(String id, DataSourceFactory source) {
				addSource(id, SherlockCore.getManager().getSource(id));
			}
		});
		List<String> sources = SherlockCore.getManager().getSources();
		for (String id : sources) {
			addSource(id, SherlockCore.getManager().getSource(id));
		}
	}

	@Override
	public void dispose() {
		for (Entry<String, SourceInfo> entry : sources.entrySet()) {
			removeItem(entry.getValue());
		}
		sources.clear();
		super.dispose();
	}

	private void addSource(final String id, final DataSource source) {
		runInUI(new Runnable() {

			@Override
			public void run() {
				final TreeItem item = new TreeItem(tree, SWT.LEFT);
				item.setText(id);

				SourceInfo info = new SourceInfo();
				info.source = source;
				info.item = item;
				sources.put(id, info);

				if (source instanceof EntityDataSource) {
					addObject(item, ((EntityDataSource) source).getData());
				} else if (source instanceof EventDataSource) {
					EventDataSource es = (EventDataSource) source;
					EventListener listener = new EventListener() {
						@Override
						public void handle(final EObject event) {
							runInUI(new Runnable() {
								@Override
								public void run() {
									addObject(item, event).setExpanded(true);
								}
							});
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
							runInUI(new Runnable() {
								@Override
								public void run() {
									pending = new TreeItem(item, 0);
									pending.setText("process...");
								}
							});
						}

						@Override
						public void handleFinish(final EObject data) {
							runInUI(new Runnable() {
								@Override
								public void run() {
									pending.dispose();
									addObject(item, data).setExpanded(true);
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
		runInUI(new Runnable() {
			@Override
			public void run() {
				SourceInfo info = sources.remove(id);
				if (info != null) {
					removeItem(info);
				}
			}
		});
	}

	private void runInUI(Runnable runnable) {
		Display display = Display.getDefault();
		if (Thread.currentThread() == display.getThread()) {
			runnable.run();
		} else {
			display.asyncExec(runnable);
		}
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

	private TreeItem addObject(TreeItem parent, EObject eObject) {
		TreeItem kid = new TreeItem(parent, 0);
		if (eObject == null) {
			kid.setText("null");
		} else {
			kid.setText(getClassName(eObject.eClass()));
			showInTree(kid, eObject);
		}
		return kid;
	}

	private String getClassName(EClass eClass) {
		StringBuilder builder = new StringBuilder();
		builder.append(eClass.getName());
		List<EClass> types = eClass.getEAllSuperTypes();
		if (types.size() > 0) {
			builder.append(" : ");
			builder.append(types.get(0).getName());
			for (int i = 1; i < types.size(); i++) {
				builder.append(", ");
				builder.append(types.get(i).getName());
			}
		}
		return builder.toString();
	}

	private void showInTree(TreeItem parent, EObject object) {
		for (EAttribute attr : object.eClass().getEAllAttributes()) {
			TreeItem kid = new TreeItem(parent, 0);
			Object value = object.eGet(attr);
			if (attr.isMany()) {
				kid.setText(attr.getName());
				List<?> list = (List<?>) value;
				for (Object element : list) {
					TreeItem kk = new TreeItem(kid, 0);
					kk.setText(asString(attr, element));
				}
			} else {
				String text = asString(attr, value);
				kid.setText(attr.getName() + ": " + text);
			}
		}
		for (EReference ref : object.eClass().getEAllReferences()) {
			TreeItem kid = new TreeItem(parent, 0);
			Object value = object.eGet(ref);
			if (ref.isMany()) {
				kid.setText(ref.getName());
				List<?> list = (List<?>) value;
				for (int i = 0; i < list.size(); i++) {
					TreeItem kk = new TreeItem(kid, 0);
					EObject val = (EObject) list.get(i);
					String text = inline(val);
					if (text != null) {
						kk.setText(text);
					} else {
						kk.setText(Integer.toString(i));
						showInTree(kk, val);
					}
				}
			} else {
				EObject eObject = (EObject) value;
				if (eObject != null) {
					kid.setText(ref.getName() + ": " + getClassName(eObject.eClass()));
					showInTree(kid, eObject);
				} else {
					kid.setText(ref.getName() + ": null");
				}
			}
		}
	}

	private String inline(EObject object) {
		List<EStructuralFeature> features = object.eClass().getEAllStructuralFeatures();
		if (features.size() > 4)
			return null;
		for (EStructuralFeature feature : features) {
			if (!(feature instanceof EAttribute))
				return null;
		}
		StringBuilder builder = new StringBuilder();
		builder.append("{");
		for (int i = 0; i < features.size(); i++) {
			if (i > 0)
				builder.append(", ");
			EAttribute attr = (EAttribute) features.get(i);
			builder.append(attr.getName());
			builder.append(": ");
			builder.append(asString(attr, object.eGet(attr)));
		}
		builder.append("}");
		return builder.toString();
	}

	private static String asString(EAttribute attr, Object value) {
		if (value == null)
			return "null";
		EDataType type = attr.getEAttributeType();
		EFactory factory = type.getEPackage().getEFactoryInstance();
		return factory.convertToString(type, value);
	}

	@Override
	public void setFocus() {
		tree.setFocus();
	}

	private class SourceInfo {
		TreeItem item;
		DataSource source;
		Object listener;
	}

	private Map<String, SourceInfo> sources = new HashMap<String, SherlockView.SourceInfo>();

	private Tree tree;

}
