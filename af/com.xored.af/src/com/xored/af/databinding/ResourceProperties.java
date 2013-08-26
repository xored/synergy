package com.xored.af.databinding;

import java.io.IOException;
import java.util.List;

import org.eclipse.core.databinding.observable.list.ListDiff;
import org.eclipse.core.databinding.property.list.IListProperty;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.ResourceSet;

public class ResourceProperties {
    private static class Errors extends NotifierListProperty {
        public Errors() {
            super(Resource.RESOURCE__ERRORS, Diagnostic.class);
        }

        @Override
        protected void doSetList(Object source, List list, ListDiff diff) {
            final Resource resource = (Resource) source;
            resource.getErrors().clear();
            resource.getErrors().addAll(list);
        }

        @Override
        protected List doGetList(Object source) {
            final Resource resource = (Resource) source;
            return resource.getErrors();
        }
    }

    private static class Warnings extends NotifierListProperty {
        public Warnings() {
            super(Resource.RESOURCE__WARNINGS, Diagnostic.class);
        }

        @Override
        protected void doSetList(Object source, List list, ListDiff diff) {
            final Resource resource = (Resource) source;
            resource.getWarnings().clear();
            resource.getWarnings().addAll(list);
        }

        @Override
        protected List doGetList(Object source) {
            final Resource resource = (Resource) source;
            return resource.getWarnings();
        }
    }

    private static class Modified extends ResourceValueProperty {
        public Modified() {
            super(Resource.RESOURCE__IS_MODIFIED, Boolean.class);
        }

        @Override
        protected void doSetValue(Object source, Object value) {
            final Resource resource = (Resource) source;
            resource.setModified((Boolean) value);
        }

        @Override
        protected Object doGetValue(Object source) {
            final Resource resource = (Resource) source;
            return resource.isModified();
        }
    }

    private static class Loaded extends ResourceValueProperty {
        public Loaded() {
            super(Resource.RESOURCE__IS_LOADED, Boolean.class);
        }

        @Override
        protected void doSetValue(Object source, Object value) {
            final Resource resource = (Resource) source;
            final boolean load = (Boolean) value;
            if (load && !resource.isLoaded()) {
                try {
                    resource.load(resource.getResourceSet().getLoadOptions());
                } catch (final IOException e) {
                    throw new RuntimeException(e);
                }
            } else if (!load && resource.isLoaded()) {
                resource.unload();
            }
        }

        @Override
        protected Object doGetValue(Object source) {
            final Resource resource = (Resource) source;
            return resource.isLoaded();
        }
    }

    private static class ResSet extends ResourceValueProperty {
        public ResSet() {
            super(Resource.RESOURCE__RESOURCE_SET, ResourceSet.class);
        }

        @Override
        protected Object doGetValue(Object source) {
            return ((Resource) source).getResourceSet();
        }

        @Override
        protected void doSetValue(Object source, Object value) {
            final Resource resource = (Resource) source;
            if (value != resource.getResourceSet()) {
                final ResourceSet newSet = (ResourceSet) value;
                resource.getResourceSet().getResources().remove(resource);
                if (newSet != null) {
                    newSet.getResources().add(resource);
                }
            }
        }
    }

    private static class Contents extends NotifierListProperty {
        public Contents() {
            super(Resource.RESOURCE__CONTENTS, EObject.class);
        }

        @Override
        protected void doSetList(Object source, List list, ListDiff diff) {
            final Resource resource = (Resource) source;
            resource.getContents().clear();
            resource.getContents().addAll(list);
        }

        @Override
        protected List doGetList(Object source) {
            final Resource resource = (Resource) source;
            return resource.getContents();
        }
    }

    private static final IValueProperty MODIFIED = new Modified();
    private static final IValueProperty LOADED = new Loaded();
    private static final IValueProperty RESOURCE_SET = new ResSet();
    private static final IListProperty CONTENTS = new Contents();
    private static final IListProperty ERRORS = new Errors();
    private static final IListProperty WARNINGS = new Warnings();

    public static IValueProperty modified() {
        return MODIFIED;
    }

    public static IValueProperty loaded() {
        return LOADED;
    }

    public static IValueProperty resourceSet() {
        return RESOURCE_SET;
    }

    public static IListProperty contents() {
        return CONTENTS;
    }

    public static IListProperty errors() {
        return ERRORS;
    }

    public static IListProperty warnings() {
        return WARNINGS;
    }
}
