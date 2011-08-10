package com.xored.sherlock.core;

import java.util.Dictionary;
import java.util.List;

import org.eclipse.core.runtime.IBundleGroup;
import org.eclipse.core.runtime.ILogListener;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;

import com.xored.sherlock.core.internal.SherlockLogListener;
import com.xored.sherlock.core.model.sherlock.EclipseStatus;
import com.xored.sherlock.core.model.sherlock.JavaException;
import com.xored.sherlock.core.model.sherlock.JavaStackTraceEntry;
import com.xored.sherlock.core.model.sherlock.SherlockFactory;

public class SherlockCore extends Plugin {
	public static final String PLUGIN_ID = "com.xored.sherlock.core";

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

	public static void addLogListener(ILogListener listener,
			IStatusFilter statusFilter, IPluginFilter pluginFilter) {
		getDefault().logListener.addLogListener(listener, statusFilter,
				pluginFilter);
	}

	public static void removeLogListener(ILogListener listener) {
		getDefault().logListener.removeLogListener(listener);
	}

	// Converters
	public static EclipseStatus convert(IStatus status) {
		return convert(status, null);
	}

	public static EclipseStatus convert(IStatus status,
			List<IBundleGroup> features) {
		final EclipseStatus eclipseStatus = SherlockFactory.eINSTANCE
				.createEclipseStatus();
		eclipseStatus.setCode(status.getCode());
		eclipseStatus.setMessage(status.getMessage());

		eclipseStatus.setPlugin(status.getPlugin());
		Bundle bundle = Platform.getBundle(status.getPlugin());
		if (bundle != null) {
			@SuppressWarnings("unchecked")
			final Dictionary<String, String> headers = bundle.getHeaders();
			eclipseStatus.setPluginVersion(headers
					.get(Constants.BUNDLE_VERSION));
		}

		if (features != null) {
			for (IBundleGroup feature : features) {

				for (Bundle b : feature.getBundles()) {
					if (b.getSymbolicName().equals(plugin)) {
						eclipseStatus.getFeatureGuess().add(
								feature.getIdentifier());
						break;
					}
				}

			}
		}

		eclipseStatus.setSeverity(status.getSeverity());

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
		final JavaException javaException = SherlockFactory.eINSTANCE
				.createJavaException();

		javaException.setClassName(th.getClass().getName());
		javaException.setMessage(th.getMessage());

		final Throwable cause = th.getCause();
		if (cause != null && cause != th) {
			javaException.setCause(convert(cause));
		}

		for (StackTraceElement element : th.getStackTrace()) {
			javaException.getStacktrace().add(convert(element));
		}

		return javaException;
	}

	public static JavaStackTraceEntry convert(StackTraceElement element) {
		JavaStackTraceEntry entry = SherlockFactory.eINSTANCE
				.createJavaStackTraceEntry();
		entry.setFileName(element.getFileName());
		entry.setClassName(element.getClassName());
		entry.setMethodName(element.getMethodName());
		entry.setLineNumber(element.getLineNumber());
		entry.setNative(element.isNativeMethod());
		return entry;
	}

	public static void log(String msg) {
		getDefault().getLog().log(
				new Status(IStatus.ERROR, PLUGIN_ID, msg, null));
	}

	public static void log(Throwable e) {
		getDefault().getLog().log(
				new Status(IStatus.ERROR, PLUGIN_ID, e.getMessage(), e));
	}

	public static void log(String msg, Throwable e) {
		getDefault().getLog().log(new Status(IStatus.ERROR, PLUGIN_ID, msg, e));
	}

	public static String getID(String value) {
		if (value == null) {
			return null;
		}
		String textResult = "";
		for (char c : value.toCharArray()) {
			if (!Character.isLetterOrDigit(c)) {
				textResult += '_';
			} else {
				textResult += c;
			}
		}
		return textResult;
	}
}
