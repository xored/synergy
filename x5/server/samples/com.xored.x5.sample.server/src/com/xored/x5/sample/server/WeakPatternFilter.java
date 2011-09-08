package com.xored.x5.sample.server;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.dialogs.PatternFilter;

public class WeakPatternFilter extends PatternFilter {

	@Override
	public void setPattern(String patternString) {
		super.setPattern(patternString);
		cache = new HashMap<Object, Boolean>();
	}

	@Override
	public boolean isElementVisible(Viewer viewer, Object element) {
		if (wordMatches(""))
			return true;
		Boolean result = cache.get(element);
		if (result != null) {
			return result.booleanValue();
		}
		return computeElementVisible(viewer, element);
	}

	private boolean computeElementVisible(Viewer viewer, Object element) {
		if (isLeafMatch(viewer, element)) {
			markAllMatch(viewer, element);
			return true;
		}
		boolean result = isParentMatch(viewer, element);
		cache.put(element, result);
		return result;
	}

	private void markAllMatch(Viewer viewer, Object element) {
		cache.put(element, Boolean.TRUE);
		Object[] children = ((ITreeContentProvider) ((AbstractTreeViewer) viewer).getContentProvider())
				.getChildren(element);
		if (children != null) {
			for (Object child : children) {
				markAllMatch(viewer, child);
			}
		}
	}

	protected boolean isParentMatch(Viewer viewer, Object element) {
		Object[] children = ((ITreeContentProvider) ((AbstractTreeViewer) viewer).getContentProvider())
				.getChildren(element);

		if ((children != null) && (children.length > 0)) {
			for (Object child : children) {
				if (isElementVisible(viewer, child)) {
					return true;
				}
			}
		}
		return false;
	}

	private Map<Object, Boolean> cache = new HashMap<Object, Boolean>();

}
