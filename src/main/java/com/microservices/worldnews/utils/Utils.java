package com.microservices.worldnews.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class Utils {

	public static Map<String, Object> convertUsingReflection(Object object) {
		Map<String, Object> map = new HashMap<>();
		Field[] fields = object.getClass().getDeclaredFields();

		for (Field field : fields) {
			field.setAccessible(true);
			try {
				map.put(field.getName(), field.get(object));
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return map;
	}
}
