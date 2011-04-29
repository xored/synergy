package com.xored.emfjson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public class Emf2Json {

	private static final String CLASS_ATTRIBUTE = EClass.class.getName();

	public static JsonObject serialize(EObject object) {
		return toJsonObject(object, true);
	}

	public static JsonObject toJsonObject(EObject object, boolean saveClass) {

		EClass eClass = object.eClass();
		JsonObject jsonObject = new JsonObject();
		if (saveClass) {
			jsonObject.addProperty(CLASS_ATTRIBUTE, eClass.getEPackage()
					.getName() + ":" + eClass.getName());
		}

		for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
			Object value = object.eGet(feature);
			if (feature.isMany()) {
				JsonArray jsonArray = new JsonArray();

				if (value != null) {
					List<?> list = (List<?>) value;
					for (Object item : list) {
						jsonArray.add(handleFeature(feature, item));
					}
					jsonObject.add(feature.getName(), jsonArray);
				}
			} else {
				jsonObject
						.add(feature.getName(), handleFeature(feature, value));
			}
		}
		return jsonObject;
	}

	private static JsonElement handleFeature(EStructuralFeature feature,
			Object value) {
		if (feature instanceof EAttribute) {
			return adaptAttribute(value);
		} else if (feature instanceof EReference) {
			if (value == null) {
				return JSON_NULL;
			}
			EReference ref = (EReference) feature;

			EObject eValue = (EObject) value;

			if (ref.isContainment()) {
				return toJsonObject(eValue,
						!eValue.eClass().equals(feature.getEType()));
			} else {
				return new JsonPrimitive(generateLink(eValue));
			}
		} else {
			return JSON_NULL;
		}
	}

	private static final JsonElement JSON_NULL = new JsonNull();

	private static String generateLink(EObject eValue) {
		List<PathLocation> path = new ArrayList<PathLocation>();
		generatePath(eValue, path);

		Collections.reverse(path);

		Iterator<PathLocation> it = path.iterator();

		StringBuilder link = new StringBuilder("@");

		if (it.hasNext()) {
			link.append(it.next());
			while (it.hasNext()) {
				link.append("/").append(it.next());
			}
		}
		return link.toString();
	}

	private static void generatePath(EObject eValue, List<PathLocation> path) {
		EObject container = eValue.eContainer();
		if (container != null) {
			int index;
			if (container instanceof EList) {
				index = ((EList<?>) container).indexOf(eValue);
			} else {
				index = 0;
			}
			EReference containmentFeature = eValue.eContainmentFeature();
			path.add(new PathLocation(containmentFeature.getName(), index));
			generatePath(container, path);
		}
	}

	private static JsonElement adaptAttribute(Object value) {
		if (value == null) {
			return new JsonNull();
		}
		if (value instanceof Enumerator) {
			return new JsonPrimitive(((Enumerator) value).getLiteral());
		}
		return new JsonPrimitive(value.toString());
	}

	public static EObject deserialize(JsonObject jsonObject) {
		throw new UnsupportedOperationException();
	}

	private static class PathLocation {
		private final String name;
		private final int index;

		public PathLocation(String name, int index) {
			this.name = name;
			this.index = index;
		}

		@Override
		public String toString() {
			return name + "." + index;
		}
	}
}
