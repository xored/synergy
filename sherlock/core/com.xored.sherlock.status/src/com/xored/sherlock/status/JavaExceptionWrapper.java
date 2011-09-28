package com.xored.sherlock.status;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.List;

class JavaExceptionWrapper extends Exception {

	public JavaExceptionWrapper(JavaException exception) {
		this.exception = exception;
		if (exception.getCause() != null) {
			cause = new JavaExceptionWrapper(exception.getCause());
		}
	}

	@Override
	public String getMessage() {
		return exception.getMessage();
	}

	@Override
	public Throwable getCause() {
		return cause;
	}

	@Override
	public void printStackTrace(PrintStream s) {
		ExceptionUtil.printStackTrace(exception, s);
	}

	@Override
	public void printStackTrace(PrintWriter s) {
		ExceptionUtil.printStackTrace(exception, s);
	}

	@Override
	public StackTraceElement[] getStackTrace() {
		List<JavaStackTraceEntry> entries = exception.getStacktrace();
		StackTraceElement[] trace = new StackTraceElement[entries.size()];
		for (int i = 0; i < trace.length; i++) {
			trace[i] = ExceptionUtil.convert(entries.get(i));
		}
		return trace;
	}

	@Override
	public String toString() {
		String s = exception.getClassName();
		String message = exception.getMessage();
		return (message != null) ? (s + ": " + message) : s;
	}

	private JavaException exception;
	private Throwable cause;

	private static final long serialVersionUID = 1L;

}
