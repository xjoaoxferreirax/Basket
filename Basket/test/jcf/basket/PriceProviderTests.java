package jcf.basket;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PriceProviderTests {

	@Test
	void priceProviderExists() {
		PriceProvider priceProvider = new StaticPriceProvider();
	}

	@Test
	void butterCosts80Cents() {
		StaticPriceProvider priceProvider = new StaticPriceProvider();
		int expectedPrice = 80;
		int price = priceProvider.getPrice("butter");
		assertEquals(expectedPrice, price);
	}

	@Test
	void milkCosts115Cents() {
		StaticPriceProvider priceProvider = new StaticPriceProvider();
		int expectedPrice = 115;
		int price = priceProvider.getPrice("milk");
		assertEquals(expectedPrice, price);
	}

	@Test
	void breadCosts100Cents() {
		StaticPriceProvider priceProvider = new StaticPriceProvider();
		int expectedPrice = 100;
		int price = priceProvider.getPrice("bread");
		assertEquals(expectedPrice, price);
	}

}
