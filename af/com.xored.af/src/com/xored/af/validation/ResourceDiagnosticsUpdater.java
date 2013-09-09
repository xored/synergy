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
package com.xored.af.validation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.emf.validation.service.IValidationListener;
import org.eclipse.emf.validation.service.ValidationEvent;

import com.xored.af.internal.AfPlugin;

/**
 * Groups up changes to issue multi-value notifications.
 */
public class ResourceDiagnosticsUpdater implements IValidationListener {
    private static class Diags {
        public final List<EmfDiagnostic> errors = new ArrayList<EmfDiagnostic>();
        public final List<EmfDiagnostic> warns = new ArrayList<EmfDiagnostic>();
    }

    private static class DiagsMap extends HashMap<Resource, Diags> {
        private static final long serialVersionUID = -3623691686968145565L;

        @Override
        public Diags get(final Object key) {
            final Diags result = super.get(key);
            if (result == null) {
                final Diags diags = new Diags();
                put((Resource) key, diags);
                return diags;
            } else {
                return result;
            }
        }
    }

    public void validationOccurred(final ValidationEvent event) {
        final DiagsMap diags = new DiagsMap();
        if (event.getSeverity() == IStatus.ERROR || event.getSeverity() == IStatus.WARNING) {
            for (final IConstraintStatus status : event.getValidationResults()) {
                createDiagnostics(status, diags);
            }
        }
        for (final Map.Entry<Resource, Diags> entry : diags.entrySet()) {
            if (!entry.getValue().errors.isEmpty()) {
                entry.getKey().getErrors().addAll(entry.getValue().errors);
            }
            if (!entry.getValue().warns.isEmpty()) {
                entry.getKey().getWarnings().addAll(entry.getValue().warns);
            }
        }
    }

    private void createDiagnostics(final IConstraintStatus status, final DiagsMap diags) {
        if (status.isMultiStatus()) {
            for (final IStatus child : status.getChildren()) {
                // downcast works because all constraints create their statuses
                // via Validation API
                createDiagnostics((IConstraintStatus) child, diags);
            }
        } else {
            if (!status.isOK()) {
                try {
                    final EmfDiagnostic diag = createDiagnostic(status);
                    if (diag != null) {
                        switch (status.getSeverity()) {
                        case IStatus.ERROR:
                            diags.get(diag.getObject().eResource()).errors.add(diag);
                            break;
                        case IStatus.WARNING:
                            diags.get(diag.getObject().eResource()).warns.add(diag);
                            break;
                        default:
                            AfPlugin.getInstance().warn(
                                "Validation result munched: " + diag.getMessage() + " at "
                                    + diag.getLocation());
                        }
                    }
                } catch (final Exception e) {
                    AfPlugin.getInstance().error(e);
                }
            }
        }
    }

    private EmfDiagnostic createDiagnostic(final IConstraintStatus status) {
        final Resource resource = status.getTarget().eResource();
        if (resource == null) {
            AfPlugin.getInstance().warn("No Resource for EObject: " + status.getTarget());
            return null;
        }

        final EmfDiagnostic diagnostic = new EmfDiagnostic(status.getTarget(), status.getMessage(), status
            .getCode());

        for (final EObject o : status.getResultLocus()) {
            if (o instanceof EStructuralFeature) {
                diagnostic.setFeature((EStructuralFeature) o);
            } else if (o instanceof RegionEObject) {
                final RegionEObject r = (RegionEObject) o;
                diagnostic.setRegion(r.region.getOffset(), r.region.getLength());
            } else if (o instanceof IndexEObject) {
                diagnostic.add(o);
            } else if (o.eResource() == status.getTarget().eResource()) {
                diagnostic.add(o);
            }
        }
        return diagnostic;
    }
}
