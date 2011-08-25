package com.xored.sherlock.eclipse.platform;

import java.util.Arrays;
import java.util.Dictionary;
import java.util.Map;

import org.eclipse.core.runtime.IBundleGroup;
import org.eclipse.core.runtime.IBundleGroupProvider;
import org.eclipse.core.runtime.IProduct;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.IPreferenceNodeVisitor;
import org.eclipse.emf.ecore.EObject;
import org.osgi.framework.Bundle;
import org.osgi.framework.Constants;
import org.osgi.service.prefs.BackingStoreException;

import com.xored.sherlock.core.EntityDataSource;
import com.xored.sherlock.internal.eclipse.platform.Activator;

public class PlatformSource implements EntityDataSource {

	@Override
	public EObject getData() {
		final Platform platform = PlatformFactory.eINSTANCE.createPlatform();

		// product
		IProduct product = org.eclipse.core.runtime.Platform.getProduct();
		if (product != null) {
			platform.setApplicationId(product.getApplication());
			platform.setProductId(product.getId());
			platform.setBuildId(System.getProperty(BUILD_ID, null));
		}

		platform.setUptime(System.currentTimeMillis() - Long.parseLong(System.getProperty(START_TIME)));
		platform.getApplicationArgs().addAll(Arrays.asList(org.eclipse.core.runtime.Platform.getApplicationArgs()));

		// features
		IBundleGroupProvider[] providers = org.eclipse.core.runtime.Platform.getBundleGroupProviders();
		if (providers != null) {
			for (IBundleGroupProvider provider : providers) {
				IBundleGroup[] groups = provider.getBundleGroups();
				for (IBundleGroup group : groups) {
					Feature feature = PlatformFactory.eINSTANCE.createFeature();
					feature.setId(group.getIdentifier());
					feature.setVersion(group.getVersion());
					feature.setName(group.getName());
					feature.setProvider(group.getProviderName());
					platform.getFeatures().add(feature);
				}
			}
		}

		// plugins
		for (Bundle bundle : Activator.getContext().getBundles()) {
			final Dictionary<String, String> headers = bundle.getHeaders();
			final Plugin plugin = PlatformFactory.eINSTANCE.createPlugin();
			plugin.setName(headers.get(Constants.BUNDLE_NAME));
			plugin.setProvider(headers.get(Constants.BUNDLE_VENDOR));
			plugin.setId(bundle.getSymbolicName());
			plugin.setVersion(headers.get(Constants.BUNDLE_VERSION));
			platform.getPlugins().add(plugin);
		}

		// preferences
		try {
			org.eclipse.core.runtime.Platform.getPreferencesService().getRootNode()
					.accept(new IPreferenceNodeVisitor() {
						@Override
						public boolean visit(IEclipsePreferences node) throws BackingStoreException {
							String absolutePath = node.absolutePath();
							// check the excludes list for each preference
							String[] keys = node.keys();
							for (int i = 0; i < keys.length; i++) {
								String key = keys[i];
								final Preference pref = PlatformFactory.eINSTANCE.createPreference();
								pref.setName(key);
								pref.setValue(node.get(key, ""));
								pref.setPath(absolutePath);
								platform.getPreferences().add(pref);

							}
							return true;
						}
					});
		} catch (BackingStoreException e) {
			// ignore storage exception
		}

		return platform;
	}

	@Override
	public void initialize(Map<String, String> options) {
	}

	private static final String BUILD_ID = "eclipse.buildId";
	private static final String START_TIME = "eclipse.startTime";

}
