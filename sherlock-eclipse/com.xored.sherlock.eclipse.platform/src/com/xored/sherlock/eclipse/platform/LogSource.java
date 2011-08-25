package com.xored.sherlock.eclipse.platform;

import org.eclipse.core.runtime.ILogListener;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;

import com.xored.sherlock.core.BaseEventDataSource;

public class LogSource extends BaseEventDataSource implements ILogListener {

	@Override
	protected void start() {
		Platform.addLogListener(this);
	}

	@Override
	protected void finish() {
		Platform.removeLogListener(this);
	}

	@Override
	public void logging(IStatus s, String plugin) {
		fire(createStatus(s));
	}

	private Status createStatus(IStatus s) {
		final Status status = PlatformFactory.eINSTANCE.createStatus();
		status.setCode(s.getCode());
		status.setMessage(s.getMessage());
		status.setPlugin(s.getPlugin());
		status.setSeverity(s.getSeverity());

		final Throwable exception = s.getException();
		if (exception != null) {
			status.setException(createException(exception));
		}

		for (IStatus child : s.getChildren()) {
			status.getChildren().add(createStatus(child));
		}

		return status;
	}

	private JavaException createException(Throwable t) {
		final JavaException exception = PlatformFactory.eINSTANCE.createJavaException();
		exception.setClassName(t.getClass().getName());
		exception.setMessage(t.getMessage());

		final Throwable cause = t.getCause();
		if (cause != null) {
			exception.setCause(createException(cause));
		}

		for (StackTraceElement element : t.getStackTrace()) {
			exception.getStacktrace().add(createEntry(element));
		}

		return exception;
	}

	private static JavaStackTraceEntry createEntry(StackTraceElement element) {
		JavaStackTraceEntry entry = PlatformFactory.eINSTANCE.createJavaStackTraceEntry();
		entry.setFileName(element.getFileName());
		entry.setClassName(element.getClassName());
		entry.setMethodName(element.getMethodName());
		entry.setLineNumber(element.getLineNumber());
		entry.setNative(element.isNativeMethod());
		return entry;
	}

}
