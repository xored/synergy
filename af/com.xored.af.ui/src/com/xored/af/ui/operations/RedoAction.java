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
package com.xored.af.ui.operations;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.action.Action;

import com.xored.af.ui.internal.AfUiPlugin;

public class RedoAction extends Action {

    @Override
    public void run() {
        final IOperationHistory history = ContextManager.INSTANCE.getOperationHistory();
        final IUndoContext context = ContextManager.INSTANCE.getCurrentContext();

        if (context != null && history.canRedo(context)) {
            try {
                history.redo(context, null, null);
            } catch (final ExecutionException ex) {
                final IStatus status = new Status(IStatus.ERROR, AfUiPlugin.PLUGIN_ID,
                    "Redo execution error.", ex);
                AfUiPlugin.getDefault().getLog().log(status);
            }
        }
    }

    public void update() {
        final IOperationHistory history = ContextManager.INSTANCE.getOperationHistory();
        final IUndoContext context = ContextManager.INSTANCE.getCurrentContext();

        if (context != null) {
            setEnabled(history.canRedo(context));

            final IUndoableOperation operation = history.getRedoOperation(context);
            String text = "Redo";
            if (operation != null && !operation.getLabel().isEmpty()) {
                text += " " + operation.getLabel();
            }

            setText(text);
        }
    }

}
