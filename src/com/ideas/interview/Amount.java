package com.ideas.interview;

public enum Amount {
	TEN(10), FIVE(5);
	private int value;

	public final int getValue() {
		return value;
	}

	private Amount(int value) {
		this.value = value;
	}
	
}
