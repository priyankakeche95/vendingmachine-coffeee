package com.ideas.interview;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AcceptanceTest {

	private Controller controller;
	private Display display;
	private Barista barista;
	private Cashier cashier;

	@Test
	public void dispenseBlackCoffeeForFree() {
		powerUp();
		assertEquals("Please select a coffee type BLACK FILTEREDCOFFY LATTE ", display.currentMessage());
		userWants(CoffeeType.BLACK);
		assertEquals("Great Choice!", display.currentMessage());
		controller.dispense();
		assertEquals(CoffeeType.BLACK, barista.servedCoffee());
		assertEquals("Please collect your delicious coffee", display.currentMessage());
	}

	@Test
	public void dispenseBlackCoffeeForpaid() {
		powerUp();
		assertEquals("Please select a coffee type BLACK FILTEREDCOFFY LATTE ", display.currentMessage());
		userWants(CoffeeType.FILTEREDCOFFY);
		assertEquals("Great Choice!", display.currentMessage());
		enterAmount(Amount.TEN);
		assertEquals(CoffeeType.FILTEREDCOFFY, barista.servedCoffee());
		assertEquals("Please collect your delicious coffee", display.currentMessage());
	}

	@Test
	public void dispenseBlackCoffeeInsufficientAmout() {
		powerUp();
		assertEquals("Please select a coffee type BLACK FILTEREDCOFFY LATTE ", display.currentMessage());
		userWants(CoffeeType.FILTEREDCOFFY);
		assertEquals("Great Choice!", display.currentMessage());
		enterAmount(Amount.FIVE);
		assertEquals("Insufficient amount entered", display.currentMessage());
	}

	private AcceptanceTest userWants(CoffeeType coffeeType) {
		controller.userWants(coffeeType);
		return this;
	}

	private AcceptanceTest enterAmount(Amount amount) {
		controller.enterAmount(amount);
		return this;
	}

	private void powerUp() {
		display = new Display();
		barista = new Barista();
		cashier = new Cashier();
		controller = new Controller(display, barista, cashier);
	}
}
