package com.xored.af.internal;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.BundleContext;

public class AfPlugin extends Plugin {
    public static final String PLUGIN_ID = "com.xored.af";

    private static AfPlugin instance;

    public void error(final String msg, final Exception e) {
        getLog().log(new Status(IStatus.ERROR, PLUGIN_ID, msg, e));
    }

    public void error(final Exception e) {
        getLog().log(new Status(IStatus.ERROR, PLUGIN_ID, e.getMessage(), e));
    }

    public void warn(final String message) {
        getLog().log(new Status(IStatus.WARNING, PLUGIN_ID, message));
    }

    public void warn(final String message, final Exception e) {
        getLog().log(new Status(IStatus.WARNING, PLUGIN_ID, message, e));
    }

    public void info(final String message) {
        getLog().log(new Status(IStatus.INFO, PLUGIN_ID, message));
    }

    public static AfPlugin getInstance() {
        return instance;
    }

    @Override
    public void start(final BundleContext context) throws Exception {
        super.start(context);
        instance = this;
    }

    @Override
    public void stop(final BundleContext context) throws Exception {
        instance = null;
        super.stop(context);
    }
}
