package com.xored.sherlock.core.info;

import java.io.File;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IBundleGroup;
import org.osgi.framework.Bundle;
import org.osgi.framework.Constants;
import org.osgi.service.prefs.Preferences;

import com.xored.sherlock.core.model.sherlock.EclipseFeature;
import com.xored.sherlock.core.model.sherlock.EclipseInfo;
import com.xored.sherlock.core.model.sherlock.EclipsePlugin;
import com.xored.sherlock.core.model.sherlock.EclipsePreference;
import com.xored.sherlock.core.model.sherlock.JavaInfo;
import com.xored.sherlock.core.model.sherlock.SherlockFactory;
import com.xored.sherlock.core.model.sherlock.SystemInfo;

public final class Info {
	public static SystemInfo getSystem() {
		final SystemInfo info = SherlockFactory.eINSTANCE.createSystemInfo();
		info.setOsName(SystemInfoProvider.getOSName());
		info.setOsArch(SystemInfoProvider.getOSArch());
		info.setOsVersion(SystemInfoProvider.getOSVersion());
		info.setUsername(SystemInfoProvider.getUsername());
		info.getVariables().putAll(SystemInfoProvider.getVariables());
		return info;
	}

	public static JavaInfo getJava() {
		final JavaInfo info = SherlockFactory.eINSTANCE.createJavaInfo();
		info.setRuntimeName(JavaInfoProvider.getRuntimeName());
		info.setRuntimeVersion(JavaInfoProvider.getRuntimeVersion());
		info.setFreeMemory(JavaInfoProvider.getFreeMemory());
		info.setMaxMemory(JavaInfoProvider.getMaxMemory());
		info.setTotalMemory(JavaInfoProvider.getTotalMemory());
		info.getProperties().putAll(JavaInfoProvider.getProperties());
		return info;
	}

	public static EclipseInfo getEclipse() {
		return getEclipse(EclipseInfoProvider.getFeatures());
	}

	public static EclipseInfo getEclipse(List<IBundleGroup> features) {
		final EclipseInfo info = SherlockFactory.eINSTANCE.createEclipseInfo();

		info.setBuildId(EclipseInfoProvider.getBuildId());
		String workspace = EclipseInfoProvider.getWorkspaceLocation();
		info.setWorkspaceLocation(workspace);

		if (workspace != null) {
			try {
				File workspaceDir = new File(workspace);
				info.setWorkspacePartitionTotalDiskspace(workspaceDir
						.getTotalSpace());
				info.setWorkspacePartitionUsableDiskspace(workspaceDir
						.getUsableSpace());
				info.setWorkspacePartitionFreeDiskspace(workspaceDir
						.getFreeSpace());
			} catch (Throwable t) {
			}
		}

		info.setUptime(EclipseInfoProvider.getUptime());
		info.setProductId(EclipseInfoProvider.getProductId());
		info.setApplicationId(EclipseInfoProvider.getApplicationId());
		info.getApplicationArgs().addAll(
				Arrays.asList(EclipseInfoProvider.getApplicationArgs()));

		for (IBundleGroup group : features) {
			final EclipseFeature feature = SherlockFactory.eINSTANCE
					.createEclipseFeature();
			feature.setId(group.getIdentifier());
			feature.setVersion(group.getVersion());
			feature.setProvider(group.getProviderName());
			feature.setName(group.getName());

			info.getFeatures().add(feature);
		}

		for (Bundle bundle : EclipseInfoProvider.getPlugins()) {
			@SuppressWarnings("unchecked")
			final Dictionary<String, String> headers = bundle.getHeaders();

			final EclipsePlugin plugin = SherlockFactory.eINSTANCE
					.createEclipsePlugin();
			plugin.setName(headers.get(Constants.BUNDLE_NAME));
			plugin.setProvider(headers.get(Constants.BUNDLE_VENDOR));
			plugin.setId(bundle.getSymbolicName());
			plugin.setVersion(headers.get(Constants.BUNDLE_VERSION));

			info.getPlugins().add(plugin);
		}

		List<Preferences> unprocessed = new LinkedList<Preferences>();
		unprocessed.add(EclipseInfoProvider.getPreferencesRoot());

		try {
			while (unprocessed.size() > 0) {
				Preferences p = unprocessed.get(0);
				unprocessed.remove(0);

				String absolutePath = p.absolutePath();
				for (String childName : p.childrenNames()) {
					unprocessed.add(0, p.node(childName));
				}
				for (String key : p.keys()) {
					final EclipsePreference pref = SherlockFactory.eINSTANCE
							.createEclipsePreference();
					pref.setName(key);
					pref.setValue(p.get(key, ""));
					pref.setPath(absolutePath);
					info.getPreferences().add(pref);
				}
			}
		} catch (Throwable t) {
		}

		return info;
	}

	private Info() {

	}
}
