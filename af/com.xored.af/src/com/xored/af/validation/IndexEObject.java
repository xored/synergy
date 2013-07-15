package com.xored.af.validation;

import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;

public class IndexEObject extends DynamicEObjectImpl {
    private final int index;

    public IndexEObject(int index) {
        this.index = index;
    }

    public String toMarkerString() {
        return Integer.toString(index);
    }
}
