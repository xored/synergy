package com.xored.sherlock.eclipse.platform;

import org.eclipse.core.runtime.IStatus;

public class PlatformUtil {

	public static Status convert(IStatus s) {
		final Status status = PlatformFactory.eINSTANCE.createStatus();
		status.setCode(s.getCode());
		status.setMessage(s.getMessage());
		status.setPlugin(s.getPlugin());
		status.setSeverity(s.getSeverity());

		final Throwable exception = s.getException();
		if (exception != null) {
			status.setException(convert(exception));
		}

		for (IStatus child : s.getChildren()) {
			status.getChildren().add(convert(child));
		}

		return status;
	}

	public static JavaException convert(Throwable t) {
		final JavaException exception = PlatformFactory.eINSTANCE.createJavaException();
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

	public static JavaStackTraceEntry convert(StackTraceElement element) {
		JavaStackTraceEntry entry = PlatformFactory.eINSTANCE.createJavaStackTraceEntry();
		entry.setFileName(element.getFileName());
		entry.setClassName(element.getClassName());
		entry.setMethodName(element.getMethodName());
		entry.setLineNumber(element.getLineNumber());
		entry.setNative(element.isNativeMethod());
		return entry;
	}

}
