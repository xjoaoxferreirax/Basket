package jcf.basket;

import java.util.ArrayList;
import java.util.List;

public class Basket {
	private final PriceProvider priceProvider;
	List<String> productList;

	public Basket(PriceProvider priceProvider) {
		this.priceProvider = priceProvider;
		this.productList = new ArrayList<String>();
	}


	public void add(String product) {
		productList.add(product);
	}

	public int total() {
		
		int total = 0;
		for(String product : productList) 
		{
			total += priceProvider.getPrice(product);
			}
		return total;
	}

}