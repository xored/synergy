package com.xored.q7.profiling.core;

import java.lang.reflect.Field;

public class ReflectionUtils {
	public static Object getThis(Object lookFor) {
		try {
			Field this$0 = lookFor.getClass().getDeclaredField("this$0");
			this$0.setAccessible(true);
			return this$0.get(lookFor);
		} catch (Throwable e) {
			// ignore exceptions
		}
		return null;
	}
}
