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

import org.eclipse.emf.common.notify.Notifier;

/**
 * 
 */
public interface PreviewLabelProvider {
    /**
     * Can be called from any thread, does not require emf transaction context
     * 
     * @param o
     * @return
     */
    public Label getLabel(final Notifier o);
}
