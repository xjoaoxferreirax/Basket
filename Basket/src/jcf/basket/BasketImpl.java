package jcf.basket;

import java.util.ArrayList;
import java.util.List;

public class BasketImpl implements Basket {
	private final PriceProvider priceProvider;
	List<String> productList;
	private DiscountProvider discountProvider;

	public BasketImpl(PriceProvider priceProvider, DiscountProvider discountProvider) {
		this.discountProvider = discountProvider;
		this.priceProvider = priceProvider;
		this.productList = new ArrayList<String>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jcf.basket.Basket#add(java.lang.String)
	 */
	@Override
	public void add(String product) {
		productList.add(product);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jcf.basket.Basket#total()
	 */
	@Override
	public int total() {

		int total = 0;

		List<PricedProduct> pricedProductList = new ArrayList<PricedProduct>();
		for (String product : productList) {
			int productPrice = priceProvider.getPrice(product);
			pricedProductList.add(new PricedProduct(product, productPrice));

			total += productPrice;
		}

		return total - discountProvider.apply(pricedProductList);
	}

}