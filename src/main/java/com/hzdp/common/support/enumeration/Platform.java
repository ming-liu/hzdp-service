package com.hzdp.common.support.enumeration;

public enum Platform {

	Web(0);

	private final int value;

	public int getValue() {
		return value;
	}

	Platform(int value) {
		this.value = value;
	}
}
