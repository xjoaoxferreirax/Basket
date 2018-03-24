package jcf.basket;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class BasketTest {

	Basket basket;
	PriceProvider priceProvider;

	@BeforeEach
	void setup() {
		priceProvider = new FakePriceProvider();
		basket = new Basket(priceProvider);
	}

	@Test
	void basketReturnsTotalPriceOfProducts() {
		basket.add("bread");
		int total = basket.total();

	}

	@Test
	void basketTotalIsNotZeroWhenItemsAreInTheBasket() {
		basket.add("bread");
		int total = basket.total();
		assertNotEquals(0, total);

	}

	@Test
	void emptyBasketAsTotalOfZero() {

		int total = basket.total();
		assertEquals(0, total);

	}

	@Test
	void basketTotalIncreasesWhenAddItemsToBasket() {
		basket.add("bread");
		int total = basket.total();
		assertNotEquals(0, total);
		basket.add("milk");
		assertTrue(basket.total() > total);

	}

	@Test
	void totalIAddedHasPriceFromPriceProvider() {
		int expectedTotal = priceProvider.getPrice("bread");
		basket.add("bread");
		int total = basket.total();
		assertEquals(expectedTotal, total);

	}

}
