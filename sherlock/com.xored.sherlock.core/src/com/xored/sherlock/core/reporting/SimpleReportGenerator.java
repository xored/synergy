package com.xored.sherlock.core.reporting;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.xored.sherlock.core.model.sherlock.report.Category;
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

		EList<Category> categories = report.getCategories();
		for (Category category : categories) {
			appendTabs(builder, 0).append("Category:" + category.getName())
					.append(LINE_SEPARATOR);
		}

		EMap<String, String> list = report.getProperties();
		for (String key : list.keySet()) {
			appendTabs(builder, 0).append(key).append("=")
					.append(list.get(key)).append(LINE_SEPARATOR);
		}

		printNode(nodes, builder, 1);
		return builder.toString();
	}

	private void printNode(Node infoNode, StringBuilder stream, int tabs) {
		appendTabs(stream, tabs);
		stream.append(infoNode.getName())
				.append(" ")
				.append(Long.toString(infoNode.getEndTime()
						- infoNode.getStartTime()));
		stream.append(" {").append(LINE_SEPARATOR);

		EMap<String, String> list = infoNode.getProperties();
		for (String key : list.keySet()) {
			appendTabs(stream, tabs + 1).append(key).append("=")
					.append(list.get(key)).append(LINE_SEPARATOR);
		}
		for (Node child : infoNode.getChildren()) {
			printNode(child, stream, tabs + 2);
		}
		if (!infoNode.getEvents().isEmpty()) {
			appendTabs(stream, tabs + 1).append("events:").append(
					LINE_SEPARATOR);
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
		stream.append(" <" + child.getTime() + " ");
		boolean needPre = true;
		if (child.getData() != null) {
			stream.append("object:");
			toString(stream, tabs + 1, child.getData()).append(LINE_SEPARATOR);
		} else {
			needPre = false;
		}

		EMap<String, String> list = child.getProperties();
		String[] set = list.keySet().toArray(new String[list.size()]);
		for (int i = 0; i < set.length; i++) {
			String key = set[i];
			StringBuilder a = needPre ? appendTabs(stream, tabs + 1) : stream;
			a.append(key).append("=").append(list.get(key));
			if (i != set.length - 1) {
				stream.append(LINE_SEPARATOR);
			}
			needPre = true;
		}
		stream.append(">").append(LINE_SEPARATOR);
	}

	private void printSnapshot(Snaphot child, StringBuilder stream, int tabs) {
		appendTabs(stream, tabs);
		stream.append(" %");
		stream.append(" object:").append(LINE_SEPARATOR);
		toString(stream, tabs + 1, child.getData()).append(LINE_SEPARATOR);

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

	public StringBuilder toString(StringBuilder builder, int tabs, EObject obj,
			String... ignores) {
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
				appendTabs(builder, tabs).append(f.getName()).append('=');
				if (eGet instanceof EObject) {
					builder.append('{');
					toString(builder, tabs + 1, (EObject) eGet,
							"eFactoryInstance").append('}');
				} else if (eGet instanceof EList) {
					EList l = (EList) eGet;
					for (int i = 0; i < l.size(); i++) {
						Object va = l.get(i);
						if (va instanceof EObject) {
							appendTabs(builder, tabs).append('{').append(
									LINE_SEPARATOR);
							toString(builder, tabs + 1, (EObject) va,
									"eFactoryInstance");
							appendTabs(builder, tabs).append('}').append(
									LINE_SEPARATOR);
						}
					}
				} else {
					builder.append('{').append(eGet).append('}')
							.append(LINE_SEPARATOR);
				}
			}
		}
		return builder;
	}
}
