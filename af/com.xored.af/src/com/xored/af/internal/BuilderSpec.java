/*******************************************************************************
 * Copyright (c) 2010-2013 xored software, Inc.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     xored software, Inc. - initial API and Implementation (Igor Zapletnev)
 *******************************************************************************/
package com.xored.af.internal;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;

public class BuilderSpec {

    private final String builderID;

    public BuilderSpec(String builderID) {
        this.builderID = builderID;
    }

    /**
     * Adds a builder to the build spec for the given project.
     */
    public void addToBuildSpec(IProject project) throws CoreException {
        IProjectDescription description = project.getDescription();
        int scriptCommandIndex = getScriptCommandIndex(description.getBuildSpec());
        if (scriptCommandIndex == -1) {
            // Add a Java command to the build spec
            ICommand command = description.newCommand();
            command.setBuilderName(builderID);
            setScriptCommand(project, description, command);
        }
    }

    /**
     * Removes the given builder from the build spec for the given project.
     */
    public void removeFromBuildSpec(IProject project) throws CoreException {
        IProjectDescription description = project.getDescription();
        ICommand[] commands = description.getBuildSpec();
        for (int i = 0; i < commands.length; ++i) {
            if (commands[i].getBuilderName().equals(builderID)) {
                ICommand[] newCommands = new ICommand[commands.length - 1];
                System.arraycopy(commands, 0, newCommands, 0, i);
                System.arraycopy(commands, i + 1, newCommands, i, commands.length - i - 1);
                description.setBuildSpec(newCommands);
                project.setDescription(description, null);
                return;
            }
        }
    }

    /**
     * Update the Script command in the build spec (replace existing one if
     * present, add one first if none).
     */
    private void setScriptCommand(IProject project, IProjectDescription description, ICommand newCommand)
        throws CoreException {
        ICommand[] oldBuildSpec = description.getBuildSpec();
        int oldScriptCommandIndex = getScriptCommandIndex(oldBuildSpec);
        ICommand[] newCommands;
        if (oldScriptCommandIndex == -1) {
            // Add a Java build spec before other builders (1FWJK7I)
            newCommands = new ICommand[oldBuildSpec.length + 1];
            System.arraycopy(oldBuildSpec, 0, newCommands, 1, oldBuildSpec.length);
            newCommands[0] = newCommand;
        } else {
            oldBuildSpec[oldScriptCommandIndex] = newCommand;
            newCommands = oldBuildSpec;
        }

        // Commit the spec change into the project
        description.setBuildSpec(newCommands);
        project.setDescription(description, null);
    }

    /**
     * Find the specific Script command amongst the given build spec and return
     * its index or -1 if not found.
     */
    private int getScriptCommandIndex(ICommand[] buildSpec) {
        for (int i = 0; i < buildSpec.length; ++i) {
            if (buildSpec[i].getBuilderName().equals(builderID)) {
                return i;
            }
        }
        return -1;
    }

}