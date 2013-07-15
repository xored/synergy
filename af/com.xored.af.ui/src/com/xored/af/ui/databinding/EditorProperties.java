package com.xored.af.ui.databinding;

import org.eclipse.core.databinding.property.value.IValueProperty;

public class EditorProperties {
    public static IValueProperty dirty() {
        return new EditorDirtyProperty();
    }
}
