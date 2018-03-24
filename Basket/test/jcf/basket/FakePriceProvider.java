package jcf.basket;

public class FakePriceProvider implements PriceProvider {

	@Override
	public int getPrice(String product) {
		return 10;
	}

}
