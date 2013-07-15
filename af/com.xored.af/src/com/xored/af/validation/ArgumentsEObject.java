package com.xored.af.validation;

import java.util.List;

import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;

public class ArgumentsEObject extends DynamicEObjectImpl {
    private final List<String> arguments;

    public ArgumentsEObject(List<String> arguments) {
        this.arguments = arguments;
    }

    public String toMarkerString() {
        final StringBuilder sb = new StringBuilder();
        for (String s : arguments) {
            sb.append(s);
            sb.append('\0');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
