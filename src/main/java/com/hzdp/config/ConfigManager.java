package com.hzdp.config;

public interface ConfigManager {

	int getIntValue(String key, int defaultValue);

	String getStrValue(String key, String defaultValue);
}
