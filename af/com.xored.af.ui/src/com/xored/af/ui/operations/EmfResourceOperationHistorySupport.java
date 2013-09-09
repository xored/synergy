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

import java.text.MessageFormat;

import org.eclipse.core.commands.operations.IAdvancedUndoableOperation;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.commands.operations.TriggeredOperations;
import org.eclipse.core.commands.operations.UndoContext;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandWrapper;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.MoveCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.workspace.EMFCommandOperation;

public class EmfResourceOperationHistorySupport implements OperationHistorySupport {

    private final String name;
    private final Resource resource;
    private IUndoContext undoContext;

    protected static enum VisitType {
        IS_SUPPORTED, APPLY;
    };

    protected static enum SimpleCommandType {
        ADD, REMOVE, SET, MOVE;
    };

    public EmfResourceOperationHistorySupport(final String name, final Resource resource) {
        this.name = name;
        this.resource = resource;
    }

    public IUndoContext getContext() {
        if (undoContext == null) {
            undoContext = createUndoContext();
        }
        return undoContext;
    }

    protected IUndoContext createUndoContext() {
        return new UndoContext() {
            @Override
            public String getLabel() {
                return MessageFormat.format("{0}. [{0}]", getEditorName(), getResource().getURI());
            }

            @Override
            public String toString() {
                return getLabel();
            }
        };
    }

    protected String getEditorName() {
        return name;
    }

    protected Resource getResource() {
        return resource;
    }

    protected boolean visit(final EObject affected, final VisitType type) {
        if (getResource() == null) {
            return false;
        }
        return affected != null ? getResource().equals(affected.eResource()) : false;
    }

    protected boolean visit(final EObject owner, final EStructuralFeature feature,
        final SimpleCommandType cmd, final VisitType type) {
        return visit(owner, type);
    }

    protected boolean visit(final Object[] affectedObjects, final VisitType type) {
        if (affectedObjects == null) {
            return false;
        }

        for (final Object affected : affectedObjects) {
            if (affected instanceof EObject) {
                if (visit((EObject) affected, type)) {
                    return true;
                }
            }
        }
        return false;
    }

    protected boolean visit(final AddCommand cmd, final VisitType type) {
        return visit(cmd.getOwner(), cmd.getFeature(), SimpleCommandType.ADD, type);
    }

    protected boolean visit(final RemoveCommand cmd, final VisitType type) {
        return visit(cmd.getOwner(), cmd.getFeature(), SimpleCommandType.REMOVE, type);
    }

    protected boolean visit(final SetCommand cmd, final VisitType type) {
        return visit(cmd.getOwner(), cmd.getFeature(), SimpleCommandType.SET, type);
    }

    protected boolean visit(final MoveCommand cmd, final VisitType type) {
        return visit(cmd.getOwner(), cmd.getFeature(), SimpleCommandType.MOVE, type);
    }

    protected boolean visit(final Command command, final VisitType type) {
        if (command instanceof CompoundCommand) {
            final CompoundCommand compound = (CompoundCommand) command;
            for (Command child : compound.getCommandList()) {
                if (visit(child, type)) {
                    return true;
                }
            }
            return false;
        } else if (command instanceof CommandWrapper) {
            final CommandWrapper wrap = (CommandWrapper) command;
            return visit(wrap.getCommand(), type);
        } else if (command instanceof RemoveCommand) {
            return visit((RemoveCommand) command, type);
        } else if (command instanceof SetCommand) {
            return visit((SetCommand) command, type);
        } else if (command instanceof MoveCommand) {
            return visit((MoveCommand) command, type);
        } else if (command instanceof AddCommand) {
            return visit((AddCommand) command, type);
        }

        return visit(command.getAffectedObjects().toArray(), type);
    }

    protected boolean visit(final IUndoableOperation operation, final VisitType type) {
        if (operation instanceof TriggeredOperations) {
            final TriggeredOperations trigger = (TriggeredOperations) operation;
            return visit(trigger.getTriggeringOperation(), type);
        } else if (operation instanceof EMFCommandOperation) {
            final EMFCommandOperation emfOperation = (EMFCommandOperation) operation;
            return visit(emfOperation.getCommand(), type);
        } else if (operation instanceof IAdvancedUndoableOperation) {
            final IAdvancedUndoableOperation advOperation = (IAdvancedUndoableOperation) operation;
            return visit(advOperation.getAffectedObjects(), type);
        }

        return false;
    }

    public boolean isSupported(final IUndoableOperation operation) {
        return visit(operation, VisitType.IS_SUPPORTED);
    }

    public void apply(final IUndoableOperation operation) {
        visit(operation, VisitType.APPLY);
    }

    @Override
    public String toString() {
        return getContext().getLabel();
    }

}
