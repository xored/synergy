package com.xored.sherlock.status;

public class StatusUtil {

	public static boolean isOk(Status status) {
		return status.getSeverity() == Severity.OK;
	}

	public static Status newOkStatus() {
		return newOkStatus("unknown");
	}

	public static Status newOkStatus(String target) {
		Status status = StatusFactory.eINSTANCE.createStatus();
		status.setTarget(target);
		return status;
	}

	public static Status newErrorStatus(String target, Exception e) {
		return newErrorStatus(target, e, e.getMessage());
	}

	public static Status newErrorStatus(String target, String message) {
		return newErrorStatus(target, null, message);
	}

	public static Status newErrorStatus(String target, Exception e, String message) {
		Status status = newOkStatus(target);
		status.setSeverity(Severity.ERROR);
		if (message == null && e != null) {
			message = e.getMessage();
		}
		status.setMessage(message);
		if (e != null) {
			status.setException(StatusUtil.convert(e));
		}
		return status;
	}

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

	public static JavaStackTraceEntry convert(StackTraceElement element) {
		JavaStackTraceEntry entry = StatusFactory.eINSTANCE.createJavaStackTraceEntry();
		entry.setFileName(element.getFileName());
		entry.setClassName(element.getClassName());
		entry.setMethodName(element.getMethodName());
		entry.setLineNumber(element.getLineNumber());
		entry.setNative(element.isNativeMethod());
		return entry;
	}

}