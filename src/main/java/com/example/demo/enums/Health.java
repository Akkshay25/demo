package com.example.demo.enums;

public enum Health {

	GOOD(1, "GOOD"), LOW(2, "LOW"), CRITICAL(3, "CRITICAL");

	private final Integer key;
	private final String value;

	Health(Integer key, String value) {
		this.key = key;
		this.value = value;
	}

	public Integer getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

	public static Health fromValue(int value) {
		try {
			return Health.values()[value - 1];
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new IllegalArgumentException("Unknown enum value :" + value);
		}
	}
}