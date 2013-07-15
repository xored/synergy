package com.xored.af.ui.labels;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.xored.af.validation.EmfDiagnostic;

public class NonContainingEObjectDecorator extends EObjectDecorator {

    @Override
    protected boolean isDiagnosticRelevant(EObject eobject, EmfDiagnostic diagnostic) {
        return diagnostic.getObject() == eobject;
    }

    @Override
    protected Collection<?> getRelevantObjects(EmfDiagnostic diagnostic, final Resource resource) {
        final List<EObject> objects = new ArrayList<EObject>();
        if (diagnostic.getObject() != null) {
            objects.add(diagnostic.getObject());
        }
        objects.addAll(diagnostic.getLocus());
        return objects;
    }
}
