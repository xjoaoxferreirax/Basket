package jcf.basket;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class BasketTests {

	Basket basket;
	PriceProvider priceProvider;
	private DiscountProvider discountProvider;

	@BeforeEach
	void setup() {
		discountProvider = new FakeDiscountProvider();
		priceProvider = new FakePriceProvider();
		basket = new BasketImpl(priceProvider, discountProvider);
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
	void productAddedHasDiscountAppliedToTotal() {
		int expectedTotal = priceProvider.getPrice("bread");
		basket.add("bread");

		int totalWithDiscounts = basket.total();
		assertEquals(expectedTotal - FakeDiscountProvider.TOTAL_DISCOUNT, totalWithDiscounts);

	}

}
