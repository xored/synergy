package com.xored.af.validation;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

public class SimpleDiagnostic implements Resource.Diagnostic {
    private final String location;
    private final String message;

    public SimpleDiagnostic(final URI uri, final String message) {
        this(uri.toString(), message);
    }

    protected SimpleDiagnostic(final String location, final String message) {
        this.location = location;
        this.message = message;
    }

    public int getColumn() {
        return 0;
    }

    public int getLine() {
        return 0;
    }

    public String getLocation() {
        return location;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (location == null ? 0 : location.hashCode());
        result = prime * result + (message == null ? 0 : message.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof SimpleDiagnostic)) {
            return false;
        }
        final SimpleDiagnostic other = (SimpleDiagnostic) obj;
        if (location == null) {
            if (other.location != null) {
                return false;
            }
        } else if (!location.equals(other.location)) {
            return false;
        }
        if (message == null) {
            if (other.message != null) {
                return false;
            }
        } else if (!message.equals(other.message)) {
            return false;
        }
        return true;
    }
}