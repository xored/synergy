package com.xored.af.ui.operations;

import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.commands.operations.IUndoableOperation;

public interface OperationHistorySupport {
    public abstract IUndoContext getContext();

    public abstract boolean isSupported(IUndoableOperation operation);

    public void apply(IUndoableOperation operation);
}
