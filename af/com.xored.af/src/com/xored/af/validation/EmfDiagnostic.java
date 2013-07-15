package com.xored.af.validation;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;

public class EmfDiagnostic extends SimpleDiagnostic {

    private final Set<EObject> locus;
    private EStructuralFeature feature;
    private Region region;
    private final EObject target;
    private final int errCode;

    public EmfDiagnostic(final EObject target, final String message) {
        this(target, message, 0);
    }

    public EmfDiagnostic(final EObject target, final String message, final int errCode) {
        super(target.eResource().getURI().appendFragment(target.eResource().getURIFragment(target)), message);
        this.target = target;
        this.errCode = errCode;
        locus = new HashSet<EObject>();
        add(target);
    }

    public EmfDiagnostic add(final EObject o) {
        locus.add(o);
        return this;
    }

    public Collection<EObject> getLocus() {
        return locus;
    }

    public EObject getObject() {
        return target;
    }

    public EmfDiagnostic setFeature(final EStructuralFeature feature) {
        this.feature = feature;
        return this;
    }

    public EStructuralFeature getFeature() {
        return feature;
    }

    public int getIndex() {
        for (final EObject locusObject : locus) {
            if (locusObject instanceof IndexEObject) {
                return Integer.parseInt(((IndexEObject) locusObject).toMarkerString());
            }
        }
        return -1;
    }

    public boolean isInLocus(final EObject o, final boolean includeLocusDescendants) {
        for (EObject locusObject : locus) {
            if (locusObject == o) {
                return true;
            }
            if (includeLocusDescendants) {
                // if the marked object is inside o.allContents(),
                // we attribute the marker to o

                while (locusObject != null) {
                    locusObject = locusObject.eContainer();
                    if (locusObject == o) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public EmfDiagnostic setRegion(final int offset, final int length) {
        this.region = new Region(offset, length);
        return this;
    }

    public IRegion getRegion() {
        return region;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((feature == null) ? 0 : feature.hashCode());
        result = prime * result + ((locus == null) ? 0 : locus.hashCode());
        result = prime * result + ((region == null) ? 0 : region.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (!(obj instanceof EmfDiagnostic)) {
            return false;
        }

        final EmfDiagnostic other = (EmfDiagnostic) obj;
        if (feature == null) {
            if (other.feature != null) {
                return false;
            }
        } else if (!feature.equals(other.feature)) {
            return false;
        }
        if (locus == null) {
            if (other.locus != null) {
                return false;
            }
        } else if (!locus.equals(other.locus)) {
            return false;
        }
        if (region == null) {
            if (other.region != null) {
                return false;
            }
        } else if (!region.equals(other.region)) {
            return false;
        }
        return true;
    }

    public int getErrCode() {
        return errCode;
    }

}
