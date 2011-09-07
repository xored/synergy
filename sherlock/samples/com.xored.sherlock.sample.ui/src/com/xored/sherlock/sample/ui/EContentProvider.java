package com.xored.sherlock.sample.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class EContentProvider implements ITreeContentProvider {

	@Override
	public Object[] getElements(Object inputElement) {
		return null;
	}

	@Override
	public Object[] getChildren(Object parent) {
		if (parent instanceof EObject) {
			EObject object = (EObject) parent;
			List<Object> kids = new ArrayList<Object>();
			for (EAttribute attribute : object.eClass().getEAllAttributes()) {
				kids.add(new FeatureValue(object, attribute));
			}
			for (EReference reference : object.eClass().getEAllReferences()) {
				if (reference.isContainment()) {
					kids.add(new FeatureValue(object, reference));
				}
			}
			return kids.toArray();
		} else if (parent instanceof FeatureValue) {
			FeatureValue value = (FeatureValue) parent;
			if (value.getFeature().isMany()) {
				Object[] result = new Object[((List<?>) value.getValue()).size()];
				for (int i = 0; i < result.length; i++) {
					result[i] = new FeatureElement(value, i);
				}
				return result;
			} else {
				if (value.getFeature() instanceof EReference) {
					EObject object = (EObject) value.getValue();
					if (object != null) {
						return getChildren(object);
					}
				}
			}
		} else if (parent instanceof FeatureElement) {
			FeatureElement element = (FeatureElement) parent;
			EStructuralFeature feature = element.getFeature().getFeature();
			if (feature instanceof EReference) {
				EObject object = (EObject) element.getValue();
				if (!ELabelProvider.canInline(object)) {
					return getChildren(object);
				}
			}
		}
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		Object[] kids = getChildren(element);
		return kids != null && kids.length > 0;
	}

	@Override
	public Object getParent(Object element) {
		return null;
	}

	@Override
	public void dispose() {
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}

}
