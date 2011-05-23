package com.xored.emfjson;

public class Coercer {
	
	public static Object coerce(Class<?> type, Object value) {
		
		if (type == int.class || type == Integer.class) {

			if (value instanceof Integer) {
				return value;
			} else if (value instanceof Number) {
				return ((Number) value).intValue();
			} else {
				return Integer.valueOf((String) value);
			}

		} else if (type == long.class || type == Long.class) {

			if (value instanceof Long) {
				return value;
			} else if (value instanceof Number) {
				return ((Number) value).longValue();
			} else {
				return Long.valueOf((String) value);
			}

		} else if (type == short.class || type == Short.class) {
			
			if (value instanceof Short) {
				return value;
			} else if (value instanceof Number) {
				return ((Number) value).shortValue();
			} else {
				return Short.valueOf((String) value);
			}
			
		} else if (type == byte.class || type == Byte.class) {
			
			if (value instanceof Byte) {
				return value;
			} else if (value instanceof Number) {
				return ((Number) value).byteValue();
			} else {
				return Byte.valueOf((String) value);
			}
			
		} else if (type == float.class || type == Float.class) {

			if (value instanceof Float) {
				return value;
			} else if (value instanceof Number) {
				return ((Number) value).floatValue();
			} else {
				return Float.valueOf((String) value);
			}
			
		} else if (type == double.class || type == Double.class) {

			if (value instanceof Double) {
				return value;
			} else if (value instanceof Number) {
				return ((Number) value).doubleValue();
			} else {
				return Double.valueOf((String) value);
			}

		} else if (type == boolean.class || type == Boolean.class) {

			if (value instanceof Boolean) {
				return value;
			} else {
				return Boolean.valueOf((String) value);
			}

		} else if (type == String.class) {

			if (value instanceof String) {
				return value;
			}

		} else if (type == char.class || type == Character.class) {
			if (value instanceof String) {
				String str = (String) value;
				if (str.length() == 1) {
					return str.charAt(0);
				}
			} else if (value instanceof Number) {
				return (char) ((Number) value).byteValue();
			} 
		}
		
		throw new RuntimeException(String.format(
				"Illegal value: '%s'", value));
	}

}

