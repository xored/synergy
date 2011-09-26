package com.xored.sherlock.eclipse.platform;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;

import com.xored.sherlock.status.ExceptionUtil;
import com.xored.sherlock.status.Severity;
import com.xored.sherlock.status.Status;
import com.xored.sherlock.status.StatusFactory;

public class PlatformUtil {

	public static Status convert(IStatus s) {
		final Status status = StatusFactory.eINSTANCE.createStatus();
		status.setCode(s.getCode());
		status.setMessage(s.getMessage());
		status.setTarget(s.getPlugin());
		status.setSeverity(convertSeverity(s));

		final Throwable exception = s.getException();
		if (exception != null) {
			status.setException(ExceptionUtil.convert(exception));
		}

		for (IStatus child : s.getChildren()) {
			status.getChildren().add(convert(child));
		}

		return status;
	}

	public static IStatus convert(Status status) {
		List<Status> children = status.getChildren();
		if (children.size() == 0) {
			return new org.eclipse.core.runtime.Status(status.getSeverity().getValue(), status.getTarget(),
					status.getCode(), status.getMessage(), ExceptionUtil.convert(status.getException()));
		} else {
			IStatus[] newChildren = new IStatus[children.size()];
			for (int i = 0; i < newChildren.length; i++) {
				newChildren[i] = convert(children.get(i));
			}
			return new MultiStatus(status.getTarget(), status.getCode(), newChildren, status.getMessage(),
					ExceptionUtil.convert(status.getException()));
		}
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
