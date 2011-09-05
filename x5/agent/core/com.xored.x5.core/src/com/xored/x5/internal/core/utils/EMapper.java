package com.xored.x5.internal.core.utils;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

public interface EMapper {

	static AttrMapper attribute = new AttrMapper();

	static RefMapper reference = new RefMapper();

	Object map(Object o);

	static class AttrMapper implements EMapper {
		@Override
		public Object map(Object o) {
			return o;
		}
	}

	static class RefMapper implements EMapper {
		@Override
		public Object map(Object o) {
			return EcoreUtil.copy((EObject) o);
		}
	}

}
