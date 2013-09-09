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

import static org.eclipse.core.runtime.Platform.getAdapterManager;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IOperationHistoryListener;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.commands.operations.OperationHistoryEvent;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWindowListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;

import com.xored.af.ui.internal.AfUiPlugin;

public class ContextManager {

    private OperationHistorySupport current;
    private final Set<OperationHistorySupport> supports = new HashSet<OperationHistorySupport>();
    private final UndoAction undoActionHandler = new UndoAction();
    private final RedoAction redoActionHandler = new RedoAction();
    private final IPartListener partListener = new PartListener();

    public static final ContextManager INSTANCE = new ContextManager();

    protected ContextManager() {
        getOperationHistory().addOperationHistoryListener(new IOperationHistoryListener() {
            public void historyNotification(final OperationHistoryEvent event) {

                final int type = event.getEventType();
                if (type == OperationHistoryEvent.ABOUT_TO_EXECUTE || type == OperationHistoryEvent.DONE
                    || type == OperationHistoryEvent.OPERATION_ADDED) {
                    notifyAddOperation(event.getOperation());
                }

                final Display display = AfUiPlugin.getDefault().getWorkbench().getDisplay();
                display.asyncExec(new Runnable() {
                    public void run() {
                        if (type == OperationHistoryEvent.DONE || type == OperationHistoryEvent.UNDONE
                            || type == OperationHistoryEvent.REDONE) {
                            notifyPerform(event.getOperation());
                        }

                        undoActionHandler.update();
                        redoActionHandler.update();
                    }
                });
            }
        });

        for (final IWorkbenchWindow window : AfUiPlugin.getDefault().getWorkbench().getWorkbenchWindows()) {
            window.getPartService().addPartListener(partListener);
        }

        AfUiPlugin.getDefault().getWorkbench().addWindowListener(new IWindowListener() {
            public void windowActivated(final IWorkbenchWindow window) {
                // Nothing
            }

            public void windowDeactivated(final IWorkbenchWindow window) {
                // Nothing
            }

            public void windowOpened(final IWorkbenchWindow window) {
                window.getPartService().addPartListener(partListener);
            }

            public void windowClosed(final IWorkbenchWindow window) {
                window.getPartService().addPartListener(partListener);
            }
        });
    }

    protected void notifyAddOperation(final IUndoableOperation operation) {
        synchronized (supports) {
            for (final OperationHistorySupport support : supports) {
                if (support.isSupported(operation) && !operation.hasContext(support.getContext())) {
                    operation.addContext(support.getContext());
                }
            }
        }
    }

    public void notifyPerform(final IUndoableOperation operation) {
        synchronized (supports) {
            for (final OperationHistorySupport support : supports) {
                if (operation.hasContext(support.getContext())) {
                    support.apply(operation);
                }
            }
        }
    }

    public IOperationHistory getOperationHistory() {
        return OperationHistoryFactory.getOperationHistory();
    }

    public void add(final OperationHistorySupport context) {
        if (context != null) {
            synchronized (supports) {
                supports.add(context);
            }
        }
    }

    public void remove(final OperationHistorySupport context) {
        synchronized (supports) {
            if (context != null && supports.remove(context)) {
                cleanHistory(context);
            }
        }
    }

    public IUndoContext getCurrentContext() {
        return current == null ? null : current.getContext();
    }

    protected void cleanHistory(final OperationHistorySupport context) {
        getOperationHistory().dispose(context.getContext(), true, true, true);
    }

    protected void unbindActions(final IWorkbenchPart part) {
        unbindActions(getActionBars(part));
    }

    protected void unbindActions(final IActionBars bars) {
        if (bars != null) {
            bars.setGlobalActionHandler(ActionFactory.UNDO.getId(), null);
            bars.setGlobalActionHandler(ActionFactory.REDO.getId(), null);
            bars.updateActionBars();
        }
    }

    protected void bindActions(final IWorkbenchPart part) {
        bindActions(getActionBars(part));
        undoActionHandler.update();
        redoActionHandler.update();
    }

    protected void bindActions(final IActionBars bars) {
        if (bars != null) {
            bars.setGlobalActionHandler(ActionFactory.UNDO.getId(), undoActionHandler);
            bars.setGlobalActionHandler(ActionFactory.REDO.getId(), redoActionHandler);
            bars.updateActionBars();
        }
    }

    private IActionBars getActionBars(final IWorkbenchPart part) {
        if (part.getSite() instanceof IViewSite) {
            final IViewSite site = (IViewSite) part.getSite();
            return site.getActionBars();
        } else if (part.getSite() instanceof IEditorSite) {
            final IEditorSite site = (IEditorSite) part.getSite();
            return site.getActionBars();
        }
        return null;
    }

    public void activated(final IWorkbenchPart part) {
        final OperationHistorySupport support = getOperationHistorySupport(part);
        if (current != support) {
            if (current != null) {
                unbindActions(part);
            }

            current = support;

            if (current != null) {
                bindActions(part);
            }
        }
    }

    public void deactivated(final IWorkbenchPart part) {
        if (current != null && current == getOperationHistorySupport(part)) {
            unbindActions(part);
            current = null;
        }
    }

    public void opened(final IWorkbenchPart part) {
        final OperationHistorySupport support = getOperationHistorySupport(part);
        if (support != null) {
            add(support);
        }
    }

    public void closed(final IWorkbenchPart part) {
        final OperationHistorySupport support = getOperationHistorySupport(part);
        if (support != null) {
            remove(support);
        }
    }

    protected OperationHistorySupport getOperationHistorySupport(final IWorkbenchPart part) {
        return (OperationHistorySupport) getAdapterManager().getAdapter(part, OperationHistorySupport.class);
    }

    protected class PartListener implements IPartListener {

        public void partActivated(final IWorkbenchPart part) {
            activated(part);
        }

        public void partDeactivated(final IWorkbenchPart part) {
            deactivated(part);
        }

        public void partBroughtToTop(final IWorkbenchPart part) {
            // Nothing
        }

        public void partOpened(final IWorkbenchPart part) {
            opened(part);
        }

        public void partClosed(final IWorkbenchPart part) {
            closed(part);
        }

    }

}
