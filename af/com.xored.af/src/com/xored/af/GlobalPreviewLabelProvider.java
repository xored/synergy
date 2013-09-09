/*******************************************************************************
 * Copyright (c) 2010-2013 xored software, Inc.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     xored software, Inc. - initial API and Implementation (Igor Zapletnev)
 *******************************************************************************/
package com.xored.af;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.notify.Notifier;

import com.xored.af.internal.AfPlugin;

public class GlobalPreviewLabelProvider implements PreviewLabelProvider {
    private static final GlobalPreviewLabelProvider INSTANCE = new GlobalPreviewLabelProvider();

    public static PreviewLabelProvider getInstance() {
        return INSTANCE;
    }

    private static final String EXT_ID = "com.xored.af.previewLabelProviders";

    private final List<PreviewLabelProvider> providers = new ArrayList<PreviewLabelProvider>();

    private GlobalPreviewLabelProvider() {
        for (final IConfigurationElement conf : Platform.getExtensionRegistry().getConfigurationElementsFor(
            EXT_ID)) {
            try {
                providers.add((PreviewLabelProvider) conf.createExecutableExtension("class"));
            } catch (final CoreException e) {
                AfPlugin.getInstance().error(e);
            }
        }
    }

    public Label getLabel(final Notifier o) {
        for (final PreviewLabelProvider provider : providers) {
            final Label label = provider.getLabel(o);
            if (label != null) {
                return label;
            }
        }
        return null;
    }

}
