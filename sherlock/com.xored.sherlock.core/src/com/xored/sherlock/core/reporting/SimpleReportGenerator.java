package com.xored.sherlock.core.reporting;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.xored.sherlock.core.model.sherlock.report.Event;
import com.xored.sherlock.core.model.sherlock.report.Node;
import com.xored.sherlock.core.model.sherlock.report.Report;
import com.xored.sherlock.core.model.sherlock.report.Snaphot;

public class SimpleReportGenerator {
	private static final String LINE_SEPARATOR = System
			.getProperty("line.separator");

	public String generateContent(Report report) {
		StringBuilder builder = new StringBuilder();
		Node nodes = report.getRoot();
		builder.append("Report:").append(LINE_SEPARATOR);

		EMap<String, String> list = report.getProperties();
		for (String key : list.keySet()) {
			appendTabs(builder, 0).append(key).append("=")
					.append(list.get(key)).append(LINE_SEPARATOR);
		}
		for (Node infoNode : nodes.getChildren()) {
			printNode(infoNode, builder, 1);
		}
		return builder.toString();
	}

	private void printNode(Node infoNode, StringBuilder stream, int tabs) {
		appendTabs(stream, tabs);
		stream.append(infoNode.getName());
		stream.append(" {").append(LINE_SEPARATOR);

		EMap<String, String> list = infoNode.getProperties();
		for (String key : list.keySet()) {
			appendTabs(stream, tabs + 1).append(key).append("=")
					.append(list.get(key)).append(LINE_SEPARATOR);
		}
		for (Node child : infoNode.getChildren()) {
			printNode(child, stream, tabs + 2);
		}
		for (Event child : infoNode.getEvents()) {
			printEvent(child, stream, tabs + 2);
		}

		for (Snaphot child : infoNode.getSnapshots()) {
			printSnapshot(child, stream, tabs + 2);
		}
		appendTabs(stream, tabs).append("}").append(LINE_SEPARATOR);
	}

	private void printEvent(Event child, StringBuilder stream, int tabs) {
		appendTabs(stream, tabs);
		stream.append(" <");
		stream.append(" object:").append(toString(child.getData()))
				.append(LINE_SEPARATOR);

		EMap<String, String> list = child.getProperties();
		for (String key : list.keySet()) {
			appendTabs(stream, tabs + 1).append(key).append("=")
					.append(list.get(key)).append(LINE_SEPARATOR);
		}
		appendTabs(stream, tabs).append(">").append(LINE_SEPARATOR);
	}

	private void printSnapshot(Snaphot child, StringBuilder stream, int tabs) {
		appendTabs(stream, tabs);
		stream.append(" %");
		stream.append(" object:").append(toString(child.getData()))
				.append(LINE_SEPARATOR);

		EMap<String, String> list = child.getProperties();
		for (String key : list.keySet()) {
			appendTabs(stream, tabs + 1).append(key).append("=")
					.append(list.get(key)).append(LINE_SEPARATOR);
		}
		appendTabs(stream, tabs).append("%").append(LINE_SEPARATOR);
	}

	private StringBuilder appendTabs(StringBuilder stream, int tabs) {
		for (int i = 0; i < tabs; ++i) {
			stream.append("  ");
		}
		return stream;
	}

	public String toString(EObject obj, String... ignores) {
		StringBuilder builder = new StringBuilder();
		EClass eClass = obj.eClass();
		EList<EStructuralFeature> features = eClass.getEAllStructuralFeatures();
		for (EStructuralFeature f : features) {
			Object eGet = obj.eGet(f);
			boolean needArg = true;
			Object defaultValue = f.getDefaultValue();
			needArg = (defaultValue == null || !defaultValue.equals(eGet));

			if (eGet instanceof List && ((List<?>) eGet).size() == 0) {
				needArg = false;
			}
			for (String ignore : ignores) {
				if (ignore.equals(f.getName())) {
					needArg = false;
					break;
				}
			}
			if (eGet != null && needArg) {
				builder.append(' ').append(f.getName()).append('=');
				if (eGet instanceof EObject) {
					builder.append('{')
							.append(toString((EObject) eGet, "eFactoryInstance"))
							.append('}');
				} else {
					builder.append('{').append(eGet).append('}');
				}
			}
		}
		return builder.toString();
	}
}
