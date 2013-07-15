package com.xored.af;

import com.xored.af.internal.AfPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

public class EmfTransactionJob extends Job {
    public static class TransactionRule implements ISchedulingRule {
        private final TransactionalEditingDomain domain;

        public TransactionRule(final TransactionalEditingDomain domain) {
            Assert.isNotNull(domain, "domain");
            this.domain = domain;
        }

        public boolean contains(final ISchedulingRule rule) {
            return equals(rule);
        }

        public boolean isConflicting(final ISchedulingRule rule) {
            return equals(rule);
        }

        @Override
        public int hashCode() {
            return domain.hashCode();
        }

        @Override
        public boolean equals(final Object obj) {
            return obj instanceof TransactionRule && ((TransactionRule) obj).domain == domain;
        }
    }

    protected static final QualifiedName RESULT_QNAME = new QualifiedName(AfPlugin.PLUGIN_ID,
        "EmfTransactionJob.result");

    protected final TransactionalEditingDomain domain;
    protected final Runnable runnable;

    public EmfTransactionJob(final String name, final Runnable runnable,
        final TransactionalEditingDomain domain) {
        super(name);

        Assert.isNotNull(domain, "domain");
        Assert.isNotNull(runnable, "runnable");

        this.domain = domain;
        this.runnable = runnable;

        setSystem(true);
        setUser(false);
    }

    @Override
    protected IStatus run(final IProgressMonitor monitor) {
        try {
            monitor.beginTask(getName(), IProgressMonitor.UNKNOWN);
            final Object result = domain.runExclusive(runnable);
            setProperty(RESULT_QNAME, result);
        } catch (final InterruptedException ie) {
            return Status.CANCEL_STATUS;
        } catch (final Exception e) {
            return new Status(IStatus.ERROR, AfPlugin.PLUGIN_ID, "Error in EMF transaction", e);
        } finally {
            monitor.done();
        }

        return Status.OK_STATUS;
    }

    public Object getRunnableResult() {
        return getProperty(RESULT_QNAME);
    }
}
