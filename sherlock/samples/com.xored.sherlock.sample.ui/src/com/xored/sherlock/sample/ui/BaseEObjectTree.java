package com.xored.sherlock.sample.ui;

import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

public class BaseEObjectTree {

	public BaseEObjectTree(Composite parent) {
		tree = new Tree(parent, SWT.BORDER);
	}

	public void focus() {
		tree.setFocus();
	}

	public void runInUI(Runnable runnable) {
		if (!tree.isDisposed()) {
			Display display = tree.getDisplay();
			if (Thread.currentThread() == display.getThread()) {
				runnable.run();
			} else {
				display.asyncExec(runnable);
			}
		}
	}

	public void addObject(final EObject eObject, final TreeItem parent) {
		if (!parent.isDisposed()) {
			runInUI(new Runnable() {

				@Override
				public void run() {
					if (!parent.isDisposed()) {
						fill(new TreeItem(parent, 0), eObject);
					}
				}
			});
		}
	}

	public void addObject(final EObject eObject) {
		runInUI(new Runnable() {

			@Override
			public void run() {
				fill(new TreeItem(tree, 0), eObject);
			}
		});
	}

	private void fill(final TreeItem item, final EObject eObject) {
		if (eObject == null) {
			item.setText("null");
		} else {
			item.setText(getClassName(eObject.eClass()));
			showInTree(item, eObject);
		}
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
			if (!ref.isContainment())
				continue;
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

	public Tree getTree() {
		return tree;
	}

	private Tree tree;

}
