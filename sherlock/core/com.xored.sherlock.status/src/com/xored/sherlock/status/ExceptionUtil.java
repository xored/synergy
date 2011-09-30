package com.xored.sherlock.status;

import java.io.PrintStream;
import java.io.PrintWriter;
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

	public static void print(JavaException exception, PrintStream s) {
		synchronized (s) {
			printException(exception, new TextPrinter.Stream(s));
		}
	}

	public static void print(JavaException exception, PrintWriter s) {
		synchronized (s) {
			printException(exception, new TextPrinter.Writer(s));
		}
	}

	static void printException(JavaException exception, TextPrinter priner) {
		priner.println(asString(exception));
		List<JavaStackTraceEntry> trace = exception.getStacktrace();
		for (int i = 0; i < trace.size(); i++)
			priner.println("\tat " + asString(trace.get(i)));

		JavaException cause = exception.getCause();
		if (cause != null)
			printCause(cause, trace, priner);
	}

	static void printCause(JavaException exception, List<JavaStackTraceEntry> causedTrace, TextPrinter priner) {
		// Compute number of frames in common between this and caused
		List<JavaStackTraceEntry> trace = exception.getStacktrace();
		int m = trace.size() - 1, n = causedTrace.size() - 1;
		while (m >= 0 && n >= 0 && trace.get(m).equals(causedTrace.get(n))) {
			m--;
			n--;
		}
		int framesInCommon = trace.size() - 1 - m;

		priner.println("Caused by: " + asString(exception));
		for (int i = 0; i <= m; i++)
			priner.println("\tat " + asString(trace.get(i)));
		if (framesInCommon != 0)
			priner.println("\t... " + framesInCommon + " more");

		// Recurse if we have a cause
		JavaException ourCause = exception.getCause();
		if (ourCause != null)
			printCause(ourCause, trace, priner);
	}

}
