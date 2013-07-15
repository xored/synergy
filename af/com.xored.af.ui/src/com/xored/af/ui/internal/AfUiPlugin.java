package com.xored.af.ui.internal;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class AfUiPlugin extends AbstractUIPlugin {
    public static final ImageDescriptor OVR_WARN = imageDescriptorFromPlugin(AfUiPlugin.PLUGIN_ID,
        "/icons/ovr16/warn.gif");
    public static final ImageDescriptor OVR_ERROR = imageDescriptorFromPlugin(AfUiPlugin.PLUGIN_ID,
        "/icons/ovr16/error.gif");
    public static final ImageDescriptor TOOL_SEARCH_CLEAR = imageDescriptorFromPlugin(AfUiPlugin.PLUGIN_ID,
        "/icons/tool16/search_clear.gif");
    public static final ImageDescriptor TOOL_SEARCH_CLEAR_DISABLED = imageDescriptorFromPlugin(
        AfUiPlugin.PLUGIN_ID, "/icons/tool16/search_clear_disabled.gif");

    // The plug-in ID
    public static final String PLUGIN_ID = "com.xored.af.ui";

    // The shared instance
    private static AfUiPlugin plugin;

    /**
     * The constructor
     */
    public AfUiPlugin() {
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
     * )
     */
    @Override
    public void start(BundleContext context) throws Exception {
        super.start(context);
        plugin = this;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
     * )
     */
    @Override
    public void stop(BundleContext context) throws Exception {
        plugin = null;
        super.stop(context);
    }

    /**
     * Returns the shared instance
     * 
     * @return the shared instance
     */
    public static AfUiPlugin getDefault() {
        return plugin;
    }

    public void error(Exception e) {
        getLog().log(new Status(IStatus.ERROR, PLUGIN_ID, e.getMessage(), e));
    }

    public void warn(Exception e) {
        getLog().log(new Status(IStatus.WARNING, PLUGIN_ID, e.getMessage(), e));
    }

    public void info(final String message) {
        getLog().log(new Status(IStatus.INFO, PLUGIN_ID, message));
    }

}
