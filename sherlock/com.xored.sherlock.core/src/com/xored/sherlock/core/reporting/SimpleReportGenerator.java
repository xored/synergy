package com.xored.sherlock.core.reporting;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.xored.sherlock.core.model.sherlock.EclipseStatus;
import com.xored.sherlock.core.model.sherlock.JavaException;
import com.xored.sherlock.core.model.sherlock.JavaStackTraceEntry;
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
		printNode(nodes, builder, 1);
		return builder.toString();
	}

	public void printNode(Node infoNode, StringBuilder stream, int tabs) {
		appendTabs(stream, tabs);
		stream.append(infoNode.getName())
				.append(" ")
				.append(Long.toString(infoNode.getEndTime()
						- infoNode.getStartTime()));
		stream.append(" {").append(LINE_SEPARATOR);

		EMap<String, EObject> list = infoNode.getProperties();
		for (String key : list.keySet()) {
			appendTabs(stream, tabs + 1).append(key).append("=")
					.append(asValue(list.get(key))).append(LINE_SEPARATOR);
		}
		for (Node child : infoNode.getChildren()) {
			printNode(child, stream, tabs + 2);
		}
		// if (!infoNode.getEvents().isEmpty()) {
		// appendTabs(stream, tabs + 1).append("events:").append(
		// LINE_SEPARATOR);
		// }
		// for (Event child : infoNode.getEvents()) {
		// printEvent(child, stream, tabs + 2);
		// }

		for (Snaphot child : infoNode.getSnapshots()) {
			printSnapshot(child, stream, tabs + 2);
		}
		appendTabs(stream, tabs).append("}").append(LINE_SEPARATOR);
	}

	private String asValue(EObject eObject) {
		StringBuilder b = new StringBuilder();
		toString(b, 0, eObject);
		return "(" + b.toString().replace("\n", "\\n") + ")";
	}

	public void printEvent(Event child, StringBuilder stream, int tabs) {
		appendTabs(stream, tabs);
		stream.append(" <" + child.getTime() + " ");
		boolean needPre = true;
		if (child.getData() != null) {
			stream.append("object:%").append(LINE_SEPARATOR);
			toString(stream, tabs + 1, child.getData()).append("%").append(
					LINE_SEPARATOR);
		} else {
			needPre = false;
		}

		EMap<String, EObject> list = child.getProperties();
		String[] set = list.keySet().toArray(new String[list.size()]);
		for (int i = 0; i < set.length; i++) {
			String key = set[i];
			StringBuilder a = needPre ? appendTabs(stream, tabs + 1) : stream;
			a.append(key).append("=").append(asValue(list.get(key)));
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

		EMap<String, EObject> list = child.getProperties();
		for (String key : list.keySet()) {
			appendTabs(stream, tabs + 1).append(key).append("=")
					.append(asValue(list.get(key))).append(LINE_SEPARATOR);
		}
		appendTabs(stream, tabs).append("%").append(LINE_SEPARATOR);
	}

	private StringBuilder appendTabs(StringBuilder stream, int tabs) {
		for (int i = 0; i < tabs; ++i) {
			stream.append("  ");
		}
		return stream;
	}

	private StringBuilder printStatus(EclipseStatus s, int tabs,
			StringBuilder builder) {
		int severity = s.getSeverity();
		if (severity == IStatus.ERROR) {
			appendTabs(builder, tabs).append("Error");
		}
		if (severity == IStatus.INFO) {
			appendTabs(builder, tabs).append("Info");
		}
		if (severity == IStatus.WARNING) {
			appendTabs(builder, tabs).append("Warning");
		}
		builder.append(" in plugin: ").append(s.getPlugin())
				.append(LINE_SEPARATOR);
		appendTabs(builder, tabs).append("message: ").append(s.getMessage())
				.append(LINE_SEPARATOR);
		if (s.getException() != null) {
			appendTabs(builder, tabs).append("exception: ").append(
					LINE_SEPARATOR);
			printJavaException(s.getException(), tabs + 2, builder);
		}
		return builder;
	}

	private StringBuilder printJavaException(JavaException e, int tabs,
			StringBuilder builder) {
		appendTabs(builder, tabs).append(e.getClassName());
		if (e.getMessage() != null && e.getMessage().length() > 0) {
			builder.append(":").append(e.getMessage());
		}
		builder.append(LINE_SEPARATOR);
		for (JavaStackTraceEntry st : e.getStackTrace()) {
			appendTabs(builder, tabs + 2).append("at ")
					.append(st.getClassName()).append(".")
					.append(st.getMethodName()).append("(")
					.append(st.getFileName()).append(":")
					.append(st.getLineNumber()).append(")")
					.append(LINE_SEPARATOR);
		}
		return builder;
	}

	public StringBuilder toString(StringBuilder builder, int tabs, EObject obj,
			String... ignores) {
		return toString(builder, tabs, obj, true, ignores);
	}

	public StringBuilder toString(StringBuilder builder, int tabs, EObject obj,
			boolean skipDefaults, String... ignores) {
		if (obj instanceof EclipseStatus) {
			return printStatus((EclipseStatus) obj, tabs, builder);
		}
		if (obj == null) {
			return builder;
		}
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
			if (!skipDefaults) {
				needArg = true;
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
					builder.append('{').append(LINE_SEPARATOR);
					toString(builder, tabs + 1, (EObject) eGet,
							"eFactoryInstance").append('}');
				} else if (eGet instanceof EList) {
					EList l = (EList) eGet;
					builder.append('[');
					for (int i = 0; i < l.size(); i++) {
						Object va = l.get(i);
						if (va instanceof EObject) {
							if (i != 0) {
								appendTabs(builder, tabs + 2);
							}
							builder.append('{').append(LINE_SEPARATOR);
							toString(builder, tabs + 4, (EObject) va,
									"eFactoryInstance");
							appendTabs(builder, tabs + 2).append('}').append(
									LINE_SEPARATOR);
						}
					}
					builder.append(']');
				} else {
					builder.append(eGet).append(LINE_SEPARATOR);
				}
			}
		}
		return builder;
	}
}
