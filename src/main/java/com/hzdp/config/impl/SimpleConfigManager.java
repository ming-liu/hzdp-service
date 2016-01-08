package com.hzdp.config.impl;

import java.util.HashMap;
import java.util.Map;

import com.hzdp.config.ConfigManager;

public class SimpleConfigManager implements ConfigManager {

	private static Map<String, Object> cache = new HashMap<String, Object>();

	static {
		cache.put("hzdp-service.review-check.threshold", "3");
	}

	private Object getValue(String key) {
		return cache.get(key);
	}

	@Override
	public int getIntValue(String key, int defaultValue) {
		Object value = getValue(key);
		try {
			return Integer.parseInt(value.toString());
		} catch (Exception e) {
			return defaultValue;
		}
	}

	@Override
	public String getStrValue(String key, String defaultValue) {
		Object value = getValue(key);
		return value == null ? defaultValue : value.toString();
	}

}
