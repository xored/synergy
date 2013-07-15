package com.xored.af.builds;

import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;

import com.xored.af.internal.BuilderSpec;

public abstract class EmfProjectNature implements IProjectNature {
    private final BuilderSpec builderSpec;

    public EmfProjectNature(final String builderId) {
        builderSpec = new BuilderSpec(builderId);
    }

    public void configure() throws CoreException {
        builderSpec.addToBuildSpec(getProject());
    }

    public void deconfigure() throws CoreException {
        builderSpec.removeFromBuildSpec(getProject());
    }
}
