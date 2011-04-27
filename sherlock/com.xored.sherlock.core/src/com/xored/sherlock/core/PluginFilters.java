package com.xored.sherlock.core;

public class PluginFilters {
	private static enum AllPluginFilter implements IPluginFilter {
		INSTANCE;

		@Override
		public boolean matches(String plugin) {
			return true;
		}
	}

	public static IPluginFilter all() {
		return AllPluginFilter.INSTANCE;
	}

	private static class ExactPluginFilter implements IPluginFilter {
		private final String plugin;

		public ExactPluginFilter(String plugin) {
			this.plugin = plugin;
		}

		@Override
		public boolean matches(String plugin) {
			return this.plugin.equals(plugin);
		}
	}

	public static IPluginFilter exact(String plugin) {
		return new ExactPluginFilter(plugin);
	}

	public static IPluginFilter regex(String regex) {
		throw new AssertionError();
	}
}
