package jcf.basket;

public class StaticPriceProvider implements PriceProvider {

	public int getPrice(String product) {
		if(product.equals("milk")) return 115;
		if(product.equals("bread")) return 100;
		return 80;
	}

}
