package com.xored.sherlock.status;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.List;

class JavaExceptionWrapper extends Exception {

	public JavaExceptionWrapper(JavaException exception) {
		this.exception = exception;
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

	private JavaException exception;

	private static final long serialVersionUID = 1L;

}
