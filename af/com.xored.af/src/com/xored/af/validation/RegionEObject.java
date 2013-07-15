package com.xored.af.validation;

import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.jface.text.Region;

public class RegionEObject extends DynamicEObjectImpl {
    public final Region region;

    public RegionEObject(Region region) {
        this.region = region;
    }
}
