package com.xored.emfjson;

import com.google.gson.JsonPrimitive;

public class Coercer {
	
  public static Object coerce(Class<?> type, Object value) {
    if (value instanceof JsonPrimitive) {
      JsonPrimitive p = (JsonPrimitive) value;
      if (type == int.class || type == Integer.class) {
        return p.getAsInt();
      } else if (type == long.class || type == Long.class) {
        return p.getAsLong();
      } else if (type == short.class || type == Short.class) {
        return p.getAsShort();			
      } else if (type == byte.class || type == Byte.class) {
        return p.getAsByte();			
      } else if (type == float.class || type == Float.class) {
        return p.getAsFloat();
      } else if (type == double.class || type == Double.class) {
        return p.getAsDouble();
      } else if (type == boolean.class || type == Boolean.class) {
        return p.getAsBoolean();
      } else if (type == String.class) {
        return p.getAsString();
      } else if (type == char.class || type == Character.class) {
        return p.getAsCharacter();
      }
    }	

    throw new RuntimeException(String.format("Illegal value: '%s'", value));
  }

}

