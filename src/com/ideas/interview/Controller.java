package com.ideas.interview;

public class Controller {
	private final Display display;
	private final Barista barista;
	private CoffeeType coffeeType;
	private final Cashier cashier;

	public Controller(Display display, Barista barista, Cashier cashier) {
		this.display = display;
		this.barista = barista;
		this.cashier = cashier;
		String type = "";
		for (CoffeeType coffeeType : CoffeeType.values()) {
			type = type + coffeeType.name() + " ";
		}
		display.show("Please select a coffee type " + type);
	}

	public void userWants(CoffeeType coffeeType) {
		this.coffeeType = coffeeType;
		display.show("Great Choice!");
	}

	public void enterAmount(Amount amount) {
		boolean isbillgenerated = cashier.generateBill(this.coffeeType, amount, display);
		if (isbillgenerated) {
			dispense();
		}
	}

	public void dispense() {
		barista.serve(coffeeType);
		display.show("Please collect your delicious coffee");
	}
}
