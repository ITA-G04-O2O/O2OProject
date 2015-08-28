package com.g04.o2o.tools;

import org.codehaus.jackson.map.ObjectMapper;

import com.g04.o2o.entity.Area;

public class JsonUtil {

	static ObjectMapper objectMapper;

	public static <T> T readValue(String content, Class<T> valueType) {
		if (objectMapper == null) {
			objectMapper = new ObjectMapper();
		}
		try {
			return objectMapper.readValue(content, valueType);
		} catch (Exception e) {
			
		}

		return null;
	}

	public static String toJSon(Object object) {
		if (objectMapper == null) {
			objectMapper = new ObjectMapper();
		}
		try {
			return objectMapper.writeValueAsString(object);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
