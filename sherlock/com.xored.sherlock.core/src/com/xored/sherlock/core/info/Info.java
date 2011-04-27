package com.xored.sherlock.core.info;

import java.util.Arrays;
import java.util.Dictionary;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IBundleGroup;
import org.osgi.framework.Bundle;
import org.osgi.framework.Constants;

import com.xored.sherlock.core.model.sherlock.EclipseFeature;
import com.xored.sherlock.core.model.sherlock.EclipseInfo;
import com.xored.sherlock.core.model.sherlock.EclipsePlugin;
import com.xored.sherlock.core.model.sherlock.JavaInfo;
import com.xored.sherlock.core.model.sherlock.JavaProperty;
import com.xored.sherlock.core.model.sherlock.SherlockFactory;
import com.xored.sherlock.core.model.sherlock.SystemInfo;
import com.xored.sherlock.core.model.sherlock.SystemVariable;

public final class Info {
	public static SystemInfo getSystem() {
		final SystemInfo info = SherlockFactory.eINSTANCE.createSystemInfo();
		info.setOsName(SystemInfoProvider.getOSName());
		info.setOsArch(SystemInfoProvider.getOSArch());
		info.setOsVersion(SystemInfoProvider.getOSVersion());
		info.setUsername(SystemInfoProvider.getUsername());

		final List<SystemVariable> vars = info.getVariables();
		for (Map.Entry<String, String> entry : SystemInfoProvider.getVariables().entrySet()) {
			final SystemVariable var = SherlockFactory.eINSTANCE.createSystemVariable();
			var.setName(entry.getKey());
			var.setValue(entry.getValue());
			vars.add(var);
		}

		return info;
	}

	public static JavaInfo getJava() {
		final JavaInfo info = SherlockFactory.eINSTANCE.createJavaInfo();
		info.setRuntimeName(JavaInfoProvider.getRuntimeName());
		info.setRuntimeVersion(JavaInfoProvider.getRuntimeVersion());
		info.setFreeMemory(JavaInfoProvider.getFreeMemory());
		info.setMaxMemory(JavaInfoProvider.getMaxMemory());
		info.setTotalMemory(JavaInfoProvider.getTotalMemory());

		final List<JavaProperty> props = info.getProperties();
		for (Map.Entry<String, String> entry : JavaInfoProvider.getProperties().entrySet()) {
			final JavaProperty prop = SherlockFactory.eINSTANCE.createJavaProperty();
			prop.setName(entry.getKey());
			prop.setValue(entry.getValue());
			props.add(prop);
		}

		return info;
	}

	public static EclipseInfo getEclipse() {
		final EclipseInfo info = SherlockFactory.eINSTANCE.createEclipseInfo();

		info.setBuildId(EclipseInfoProvider.getBuildId());
		info.setWorkspaceLocation(EclipseInfoProvider.getWorkspaceLocation());
		info.setUptime(EclipseInfoProvider.getUptime());
		info.setProductId(EclipseInfoProvider.getProductId());
		info.setApplicationId(EclipseInfoProvider.getApplicationId());
		info.getApplicationArgs().addAll(Arrays.asList(EclipseInfoProvider.getApplicationArgs()));

		for (IBundleGroup group : EclipseInfoProvider.getFeatures()) {
			final EclipseFeature feature = SherlockFactory.eINSTANCE.createEclipseFeature();
			feature.setId(group.getIdentifier());
			feature.setVersion(group.getVersion());
			feature.setProvider(group.getProviderName());
			feature.setName(group.getName());

			info.getFeatures().add(feature);
		}

		for (Bundle bundle : EclipseInfoProvider.getPlugins()) {
			@SuppressWarnings("unchecked")
			final Dictionary<String, String> headers = bundle.getHeaders();

			final EclipsePlugin plugin = SherlockFactory.eINSTANCE.createEclipsePlugin();
			plugin.setName(headers.get(Constants.BUNDLE_NAME));
			plugin.setProvider(headers.get(Constants.BUNDLE_VENDOR));
			plugin.setId(bundle.getSymbolicName());
			plugin.setVersion(headers.get(Constants.BUNDLE_VERSION));

			info.getPlugins().add(plugin);
		}

		return info;
	}

	private Info() {

	}
}
