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
package com.xored.af.ui.forms;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.FormColors;
import org.eclipse.ui.forms.widgets.FormToolkit;

public class NativeToolkit extends FormToolkit {
    private static FormColors nativeColors(final Composite composite) {
        final FormColors colors = new FormColors(composite.getDisplay());
        colors.setBackground(null);
        return colors;
    }

    public NativeToolkit(Composite composite) {
        super(nativeColors(composite));
        setBorderStyle(SWT.BORDER);
    }

    @Override
    public Button createButton(Composite parent, String text, int style) {
        final Button button = new Button(parent, style);
        if (text != null)
            button.setText(text);
        adapt(button, true, true);
        return button;
    }
}
