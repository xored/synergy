package com.xored.sherlock.core;

import org.eclipse.core.runtime.IStatus;

public class StatusFilters {
	private static enum AllStatusFilter implements IStatusFilter {
		INSTANCE;

		@Override
		public boolean matches(IStatus status) {
			return true;
		}
	}

	public static IStatusFilter all() {
		return AllStatusFilter.INSTANCE;
	}

	private static class SevirityStatusFilter implements IStatusFilter {
		private final int severityMask;

		public SevirityStatusFilter(int severityMask) {
			this.severityMask = severityMask;
		}

		@Override
		public boolean matches(IStatus status) {
			return status.matches(severityMask);
		}
	}

	public static IStatusFilter sevirity(int severityMask) {
		return new SevirityStatusFilter(severityMask);
	}
}
