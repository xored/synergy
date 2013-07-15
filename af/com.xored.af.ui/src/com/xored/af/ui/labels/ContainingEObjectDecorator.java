package com.xored.af.ui.labels;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.xored.af.validation.EmfDiagnostic;

public class ContainingEObjectDecorator extends EObjectDecorator {

    @Override
    protected boolean isDiagnosticRelevant(EObject eobject, EmfDiagnostic diagnostic) {
        EObject current = diagnostic.getObject();
        while (current != eobject && current != null) {
            current = current.eContainer();
        }
        return current == eobject;
    }

    /**
     * TODO: think about possible narrowing of affected objects. problem is, the
     * target of diagnostic may be already detached from its container
     */
    @Override
    protected Collection<?> getRelevantObjects(EmfDiagnostic diagnostic, final Resource resource) {
        final List<EObject> objects = new ArrayList<EObject>();
        final EObject target = diagnostic.getObject();
        if (target != null && target.eResource() != null) {
            if (target.eResource().getContents().contains(target)) {
                addObjectIfNeeded(objects, target);
                return objects;
            } else if (target.eContainer() != null) {
                EObject current = diagnostic.getObject();
                while (current != null) {
                    addObjectIfNeeded(objects, current);
                    current = current.eContainer();
                }
            } else {
                collectAllObjects(resource, objects);
            }
        } else {
            collectAllObjects(resource, objects);
        }

        return objects;
    }

    private void addObjectIfNeeded(final List<EObject> objects, final EObject target) {
        if (decoratedList.containsKey(target)) {
            objects.add(target);
        }
    }

    private void collectAllObjects(final Resource resource, final List<EObject> objects) {
        final TreeIterator<EObject> contents = resource.getAllContents();
        while (contents.hasNext()) {
            addObjectIfNeeded(objects, contents.next());
        }
    }
}