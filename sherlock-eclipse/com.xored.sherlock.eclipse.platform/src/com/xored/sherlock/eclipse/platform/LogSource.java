package com.xored.sherlock.eclipse.platform;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import org.eclipse.core.runtime.ILogListener;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;

import com.xored.sherlock.core.EventDataSource;
import com.xored.sherlock.core.EventListener;

public class LogSource implements EventDataSource, ILogListener {

	@Override
	public void addEventListener(EventListener listener) {
		listeners.add(listener);
		if (!listen) {
			Platform.addLogListener(this);
			listen = true;
		}
	}

	@Override
	public void removeEventListener(EventListener listener) {
		listeners.remove(listener);
		if (listen && listeners.isEmpty()) {
			Platform.removeLogListener(this);
			listen = false;
		}
	}

	@Override
	public void logging(IStatus s, String plugin) {
		Status status = createStatus(s);
		for (EventListener listener : listeners) {
			listener.handle(status);
		}
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

	@Override
	public void initialize(Map<String, String> options) {
	}

	private List<EventListener> listeners = new CopyOnWriteArrayList<EventListener>();
	private boolean listen = false;

}
