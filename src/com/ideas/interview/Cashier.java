package com.ideas.interview;

import java.util.Objects;

public class Cashier {	
	public boolean generateBill(CoffeeType coffeeType, Amount amount, Display display) {
		if (Objects.equals(coffeeType.getValue(), amount.getValue())) {
			display.show("Bill generated");
			return true;
		} else {
			display.show("Insufficient amount entered");
		}
		return false;
	}
}
