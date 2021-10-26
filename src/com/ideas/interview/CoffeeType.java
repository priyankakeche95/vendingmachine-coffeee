package com.ideas.interview;

public enum CoffeeType {
	BLACK(10),FILTEREDCOFFY(10),LATTE(10);
	private int value;

	public final int getValue() {
		return value;
	}

	private CoffeeType(int value) {
		this.value = value;
	}
	
}
