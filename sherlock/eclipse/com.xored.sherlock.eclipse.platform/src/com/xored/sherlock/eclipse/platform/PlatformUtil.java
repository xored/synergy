package com.xored.sherlock.eclipse.platform;

import org.eclipse.core.runtime.IStatus;

import com.xored.sherlock.status.Severity;
import com.xored.sherlock.status.Status;
import com.xored.sherlock.status.StatusFactory;
import com.xored.sherlock.status.StatusUtil;

public class PlatformUtil {

	public static Status convert(IStatus s) {
		final Status status = StatusFactory.eINSTANCE.createStatus();
		status.setCode(s.getCode());
		status.setMessage(s.getMessage());
		status.setTarget(s.getPlugin());
		status.setSeverity(convertSeverity(s));

		final Throwable exception = s.getException();
		if (exception != null) {
			status.setException(StatusUtil.convert(exception));
		}

		for (IStatus child : s.getChildren()) {
			status.getChildren().add(convert(child));
		}

		return status;
	}

	private static Severity convertSeverity(IStatus s) {
		switch (s.getSeverity()) {
		case IStatus.OK:
			return Severity.OK;
		case IStatus.INFO:
			return Severity.INFO;
		case IStatus.WARNING:
			return Severity.WARNING;
		case IStatus.CANCEL:
			return Severity.CANCEL;
		default:
			return Severity.ERROR;
		}
	}

}
