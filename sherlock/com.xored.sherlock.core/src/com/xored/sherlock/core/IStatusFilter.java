package com.xored.sherlock.core;

import org.eclipse.core.runtime.IStatus;

public interface IStatusFilter {
	boolean matches(IStatus status);
}
