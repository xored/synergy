package com.xored.sherlock.sample.ui;

import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.viewers.BaseLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.graphics.Image;

public class ELabelProvider extends BaseLabelProvider implements ILabelProvider {

	@Override
	public String getText(Object element) {
		if (element instanceof EObject) {
			return getClassName(((EObject) element).eClass());
		} else if (element instanceof FeatureValue) {
			FeatureValue fv = (FeatureValue) element;
			EStructuralFeature feature = fv.getFeature();
			StringBuilder result = new StringBuilder(feature.getName());
			if (!feature.isMany()) {
				result.append(": ");
				Object value = fv.getValue();
				if (feature instanceof EAttribute) {
					result.append(asString((EAttribute) feature, value));
				} else {
					EObject eObject = (EObject) value;
					result.append(eObject == null ? "null" : getClassName(eObject.eClass()));
				}
			}
			return result.toString();
		} else if (element instanceof FeatureElement) {
			FeatureElement fe = (FeatureElement) element;
			EStructuralFeature feature = fe.getFeature().getFeature();
			StringBuilder result = new StringBuilder();
			result.append(fe.getIndex());
			result.append(": ");
			if (feature instanceof EAttribute) {
				result.append(asString((EAttribute) feature, fe.getValue()));
			} else {
				EObject value = (EObject) fe.getValue();
				String text = inline(value);
				if (text != null) {
					result.append(text);
				} else {
					result.append(getClassName(value.eClass()));
				}
			}
			return result.toString();
		}
		return null;
	}

	@Override
	public Image getImage(Object element) {
		return null;
	}

	public static boolean canInline(EObject object) {
		List<EStructuralFeature> features = object.eClass().getEAllStructuralFeatures();
		if (features.size() > 4)
			return false;
		for (EStructuralFeature feature : features) {
			if (!(feature instanceof EAttribute))
				return false;
		}
		return true;
	}

	private static String inline(EObject object) {
		if (!canInline(object)) {
			return null;
		}
		List<EStructuralFeature> features = object.eClass().getEAllStructuralFeatures();
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

	private static String asString(EAttribute attr, Object value) {
		if (value == null)
			return "null";
		EDataType type = attr.getEAttributeType();
		EFactory factory = type.getEPackage().getEFactoryInstance();
		return factory.convertToString(type, value);
	}

}
