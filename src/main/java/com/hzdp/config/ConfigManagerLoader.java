package com.hzdp.config;

import com.hzdp.config.impl.SimpleConfigManager;

public class ConfigManagerLoader {

	private static final ConfigManager configManager = new SimpleConfigManager();

	public static ConfigManager getConfigManager() {
		return configManager;
	}
}
