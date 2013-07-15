package com.xored.af.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.validation.marker.IMarkerConfigurator;
import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.emf.validation.service.IValidator;

import com.xored.af.validation.ArgumentsEObject;

/**
 * Partial copypaste of EMF MarkerUtil for the purpose of MultiStatus handling
 */
public class MarkerUtil {
    private static final String PLATFORM_SCHEME = "platform"; //$NON-NLS-1$
    private static final String FILE_SCHEME = "file"; //$NON-NLS-1$
    private static final String RESOURCE_SEGMENT = "resource"; //$NON-NLS-1$

    /**
     * <p>
     * Creates markers with default validation marker type for all resources
     * that had validation failures or warnings. The status provided is the
     * status returned by one of the {@link IValidator#validate(Object)}
     * methods.
     * </p>
     * <p>
     * To update the markers on a resource that already has markers, use the
     * {@link #updateMarkers(IStatus)} method.
     * </p>
     * 
     * @param validationStatus
     *            A status object returned by a validator's validate method.
     * @throws CoreException
     *             A core exception is thrown if there were any problems
     *             interacting with the workspace to attach/delete markers on
     *             resources.
     * 
     * @see #updateMarkers(IStatus)
     */
    public static void createMarkers(IStatus validationStatus) throws CoreException {
        createMarkers(validationStatus, org.eclipse.emf.validation.marker.MarkerUtil.VALIDATION_MARKER_TYPE,
            null);
    }

    /**
     * <p>
     * Creates markers with default validation marker type for all resources
     * that had validation failures or warnings. The status provided is the
     * status returned by one of the {@link IValidator#validate(Object)}
     * methods.
     * </p>
     * <p>
     * To update the markers on a resource that already has markers, use the
     * {@link #updateMarkers(IStatus, int)} method.
     * </p>
     * 
     * @param validationStatus
     *            A status object returned by a validator's validate method.
     * @param severityMask
     *            mask selecting which severities to create markers for
     * @throws CoreException
     *             A core exception is thrown if there were any problems
     *             interacting with the workspace to attach/delete markers on
     *             resources.
     * 
     * @since 1.2
     * 
     * @see #updateMarkers(IStatus, int)
     */
    public static void createMarkers(IStatus validationStatus, int severityMask) throws CoreException {
        createMarkers(validationStatus, severityMask,
            org.eclipse.emf.validation.marker.MarkerUtil.VALIDATION_MARKER_TYPE, null);
    }

    /**
     * <p>
     * Creates markers with the provided marker type for all resources that had
     * validation failures or warnings. An options marker configurator is
     * provided in order to populate the marker with additional information.
     * </p>
     * <p>
     * To update the markers on a resource that already has markers, use the
     * {@link #updateMarkers(IStatus, String, IMarkerConfigurator)} method.
     * </p>
     * 
     * @param validationStatus
     *            A status object returned by a validator's validate method.
     * @param markerType
     *            A marker type that is a subtype of the validationProblem
     *            marker type.
     * @param configurator
     *            An optional configurator to populate marker subtype specific
     *            attributes.
     * @throws CoreException
     *             A core exception is thrown if there were any problems
     *             interacting with the workspace to attach/delete markers on
     *             resources.
     * @see IValidator#validate(Object)
     * @see IValidator#validate(java.util.Collection)
     * @see IMarkerConfigurator
     * @see #updateMarkers(IStatus, String, IMarkerConfigurator)
     */
    public static void createMarkers(IStatus validationStatus, String markerType,
        IMarkerConfigurator configurator) throws CoreException {
        createMarkers(validationStatus, 0xFFFF, markerType, configurator);
    }

    /**
     * <p>
     * Creates markers with the provided marker type for all resources that had
     * validation failures or warnings. An options marker configurator is
     * provided in order to populate the marker with additional information.
     * </p>
     * <p>
     * To update the markers on a resource that already has markers, use the
     * {@link #updateMarkers(IStatus, int, String, IMarkerConfigurator)} method.
     * </p>
     * 
     * @param validationStatus
     *            A status object returned by a validator's validate method.
     * @param severityMask
     *            mask selecting which severities to create markers for
     * @param markerType
     *            A marker type that is a subtype of the validationProblem
     *            marker type.
     * @param configurator
     *            An optional configurator to populate marker subtype specific
     *            attributes.
     * @throws CoreException
     *             A core exception is thrown if there were any problems
     *             interacting with the workspace to attach/delete markers on
     *             resources.
     * @see IValidator#validate(Object)
     * @see IValidator#validate(java.util.Collection)
     * @see IMarkerConfigurator
     * @see #updateMarkers(IStatus, int, String, IMarkerConfigurator)
     * 
     * @since 1.2
     */
    public static void createMarkers(final IStatus validationStatus, final int severityMask,
        final String markerType, final IMarkerConfigurator configurator) throws CoreException {

        if (validationStatus.isOK()) {
            return;
        }

        final List<IStatus> list = new ArrayList<IStatus>();
        collectStatus(validationStatus, severityMask, list);

        IWorkspaceRunnable runnable = new IWorkspaceRunnable() {
            public void run(IProgressMonitor m) throws CoreException {

                final Map<URI, IFile> visitedResources = new HashMap<URI, IFile>();

                for (final IStatus status : list) {
                    createMarker((IConstraintStatus) status, markerType, configurator, visitedResources);
                }
            }
        };

        ResourcesPlugin.getWorkspace().run(runnable, null);
    }

    private static void collectStatus(final IStatus status, final int severityMask,
        final Collection<IStatus> result) {
        if (status.isMultiStatus()) {
            IStatus[] children = status.getChildren();
            for (IStatus element : children) {
                if (element.matches(severityMask) && (element instanceof IConstraintStatus)) {
                    collectStatus(element, severityMask, result);
                }
            }
        } else if (status.matches(severityMask) && (status instanceof IConstraintStatus)) {
            result.add(status);
        }
    }

    private static void createMarker(IConstraintStatus status, String markerType,
        IMarkerConfigurator configurator, Map<URI, IFile> visitedResources) throws CoreException {

        Resource r = status.getTarget().eResource();
        URI uri = r.getURI();

        // Normalize the URI to something that we can deal with like file or
        // platform scheme
        uri = r.getResourceSet().getURIConverter().normalize(uri);

        IFile file = visitedResources.get(uri);

        if (file == null) {
            if (PLATFORM_SCHEME.equals(uri.scheme()) && uri.segmentCount() > 1
                && RESOURCE_SEGMENT.equals(uri.segment(0))) {
                StringBuffer platformResourcePath = new StringBuffer();
                for (int j = 1, size = uri.segmentCount(); j < size; ++j) {
                    platformResourcePath.append('/');
                    platformResourcePath.append(URI.decode(uri.segment(j)));
                }

                file = ResourcesPlugin.getWorkspace().getRoot().getFile(
                    new Path(platformResourcePath.toString()));
            } else if (FILE_SCHEME.equals(uri.scheme())) {
                StringBuffer fileResourcePath = new StringBuffer();
                for (int j = 1, size = uri.segmentCount(); j < size; ++j) {
                    fileResourcePath.append('/');
                    fileResourcePath.append(URI.decode(uri.segment(j)));
                }

                file = ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(
                    new Path(fileResourcePath.toString()));
            }

            if (file != null) {
                file.deleteMarkers(org.eclipse.emf.validation.marker.MarkerUtil.VALIDATION_MARKER_TYPE, true,
                    IResource.DEPTH_ZERO);
                visitedResources.put(uri, file);
            }
        }

        if (file != null) {
            if (!status.matches(IStatus.INFO | IStatus.ERROR | IStatus.WARNING | IStatus.CANCEL)) {
                return;
            }

            IMarker marker = file.createMarker(markerType);

            switch (status.getSeverity()) {
            case IStatus.INFO:
                marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_INFO);
                marker.setAttribute(IMarker.PRIORITY, IMarker.PRIORITY_LOW);
                break;
            case IStatus.WARNING:
                marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_WARNING);
                marker.setAttribute(IMarker.PRIORITY, IMarker.PRIORITY_NORMAL);
                break;
            case IStatus.ERROR:
            case IStatus.CANCEL:
                marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
                marker.setAttribute(IMarker.PRIORITY, IMarker.PRIORITY_HIGH);
                break;
            }

            marker.setAttribute(IMarker.MESSAGE, status.getMessage());
            marker.setAttribute(EValidator.URI_ATTRIBUTE, EcoreUtil.getURI(status.getTarget()).toString());
            marker.setAttribute(org.eclipse.emf.validation.marker.MarkerUtil.RULE_ATTRIBUTE, status
                .getConstraint().getDescriptor().getId());
            marker.setAttribute(CODE_ATTRIBUTE, status.getCode());

            // Arguments
            for (EObject obj : status.getResultLocus()) {
                if (obj instanceof ArgumentsEObject) {
                    final String argumetns = ((ArgumentsEObject) obj).toMarkerString();
                    marker.setAttribute(ARGUMENTS_ATTRIBUTE, argumetns);
                    break;
                }
            }

            if (configurator != null) {
                configurator.appendMarkerConfiguration(marker, status);
            }
        }
    }

    public static final String CODE_ATTRIBUTE = "emf.code";
    public static final String ARGUMENTS_ATTRIBUTE = "emf.arguments";
}
