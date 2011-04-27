package com.xored.sherlock.core;

import org.eclipse.core.runtime.ILogListener;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

import com.xored.sherlock.core.internal.SherlockLogListener;
import com.xored.sherlock.core.model.sherlock.EclipseStatus;
import com.xored.sherlock.core.model.sherlock.JavaException;
import com.xored.sherlock.core.model.sherlock.JavaStackTraceEntry;
import com.xored.sherlock.core.model.sherlock.SherlockFactory;

public class SherlockCore extends Plugin {
	public static final String PLUGIN_ID = "com.cisco.surf.commons.support.runtime";

	private static SherlockCore plugin;

	public SherlockCore() {
	}

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		Platform.addLogListener(logListener);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		Platform.removeLogListener(logListener);
		plugin = null;
		super.stop(context);
	}

	public static SherlockCore getDefault() {
		return plugin;
	}

	// ILogListener
	private final SherlockLogListener logListener = new SherlockLogListener();

	public static void addLogListener(ILogListener listener, IStatusFilter statusFilter, IPluginFilter pluginFilter) {
		getDefault().logListener.addLogListener(listener, statusFilter, pluginFilter);
	}

	public static void removeLogListener(ILogListener listener) {
		getDefault().logListener.removeLogListener(listener);
	}

	// Converters
	public static EclipseStatus convert(IStatus status) {
		final EclipseStatus eclipseStatus = SherlockFactory.eINSTANCE.createEclipseStatus();
		eclipseStatus.setCode(status.getCode());
		eclipseStatus.setMessage(status.getMessage());
		eclipseStatus.setPlugin(status.getPlugin());
		eclipseStatus.setSevirity(status.getSeverity());

		final Throwable exception = status.getException();
		if (exception != null) {
			eclipseStatus.setException(convert(exception));
		}

		for (IStatus child : status.getChildren()) {
			eclipseStatus.getChildren().add(convert(child));
		}

		return eclipseStatus;
	}

	public static JavaException convert(Throwable th) {
		final JavaException javaException = SherlockFactory.eINSTANCE.createJavaException();

		javaException.setClassName(th.getClass().getName());
		javaException.setMessage(th.getMessage());

		final Throwable cause = th.getCause();
		if (cause != null) {
			javaException.setCause(convert(cause));
		}

		for (StackTraceElement element : th.getStackTrace()) {
			javaException.getStackTrace().add(convert(element));
		}

		return javaException;
	}

	public static JavaStackTraceEntry convert(StackTraceElement element) {
		final JavaStackTraceEntry entry = SherlockFactory.eINSTANCE.createJavaStackTraceEntry();
		entry.setClassName(element.getClassName());
		entry.setFileName(element.getFileName());
		entry.setLineNumber(element.getLineNumber());
		entry.setMethodName(element.getMethodName());
		entry.setNativeMethod(element.isNativeMethod());
		return entry;
	}
}
