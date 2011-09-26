package com.xored.sherlock.status;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ExceptionUtil {

	public static JavaException convert(Throwable t) {
		final JavaException exception = StatusFactory.eINSTANCE.createJavaException();
		exception.setClassName(t.getClass().getName());
		exception.setMessage(t.getMessage());

		final Throwable cause = t.getCause();
		if (cause != null) {
			exception.setCause(convert(cause));
		}

		for (StackTraceElement element : t.getStackTrace()) {
			exception.getStacktrace().add(convert(element));
		}

		return exception;
	}

	public static Throwable convert(JavaException exception) {
		if (exception == null)
			return null;
		return new JavaExceptionWrapper(exception);
	}

	public static JavaStackTraceEntry convert(StackTraceElement element) {
		JavaStackTraceEntry entry = StatusFactory.eINSTANCE.createJavaStackTraceEntry();
		entry.setFileName(element.getFileName());
		entry.setClassName(element.getClassName());
		entry.setMethodName(element.getMethodName());
		entry.setLineNumber(element.getLineNumber());
		entry.setNative(element.isNativeMethod());
		return entry;
	}

	public static StackTraceElement convert(JavaStackTraceEntry entry) {
		return new StackTraceElement(entry.getClassName(), entry.getMethodName(), entry.getFileName(),
				entry.getLineNumber());
	}

	public static String asString(JavaException exception) {
		String s = exception.getClassName();
		String message = exception.getMessage();
		return (message != null) ? (s + ": " + message) : s;
	}

	public static String asString(JavaStackTraceEntry entry) {
		String fileName = entry.getFileName();
		int lineNumber = entry.getLineNumber();

		StringBuilder builder = new StringBuilder();
		builder.append(entry.getClassName());
		builder.append(".");
		builder.append(entry.getMethodName());

		if (entry.isNative()) {
			builder.append("(Native Method)");
		} else {
			if (fileName != null && lineNumber >= 0) {
				builder.append("(");
				builder.append(fileName);
				builder.append(":");
				builder.append(lineNumber);
				builder.append(")");
			} else {
				if (fileName != null) {
					builder.append("(");
					builder.append(fileName);
					builder.append(")");
				} else {
					builder.append("(Unknown Source)");
				}
			}
		}
		return builder.toString();
	}

	public static void printStackTrace(JavaException exception, PrintStream s) {
		synchronized (s) {
			List<String> lines = toLines(exception);
			for (String line : lines) {
				s.println(line);
			}
		}
	}

	public static void printStackTrace(JavaException exception, PrintWriter s) {
		synchronized (s) {
			List<String> lines = toLines(exception);
			for (String line : lines) {
				s.println(line);
			}
		}
	}

	private static List<String> toLines(JavaException exception) {
		List<String> lines = new ArrayList<String>();
		lines.add(asString(exception));
		List<JavaStackTraceEntry> trace = exception.getStacktrace();
		for (int i = 0; i < trace.size(); i++)
			lines.add("\tat " + asString(trace.get(i)));

		JavaException cause = exception.getCause();
		if (cause != null)
			lines.addAll(toCauseLines(cause, trace));
		return lines;
	}

	private static List<String> toCauseLines(JavaException exception, List<JavaStackTraceEntry> causedTrace) {
		List<String> lines = new ArrayList<String>();
		// Compute number of frames in common between this and caused
		List<JavaStackTraceEntry> trace = exception.getStacktrace();
		int m = trace.size() - 1, n = causedTrace.size() - 1;
		while (m >= 0 && n >= 0 && trace.get(m).equals(causedTrace.get(n))) {
			m--;
			n--;
		}
		int framesInCommon = trace.size() - 1 - m;

		lines.add("Caused by: " + asString(exception));
		for (int i = 0; i <= m; i++)
			lines.add("\tat " + asString(trace.get(i)));
		if (framesInCommon != 0)
			lines.add("\t... " + framesInCommon + " more");

		// Recurse if we have a cause
		JavaException ourCause = exception.getCause();
		if (ourCause != null)
			lines.addAll(toCauseLines(ourCause, trace));
		return lines;
	}

}
