package tw.sales.taxes;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import tw.sales.taxes.goods.Goods;

/**
 * Shopping cart class
 * 
 * @author liuyang
 * 
 */
public class ShoppingCart {

	private List<Goods> goodsList;

	/**
	 * Constructor
	 */
	public ShoppingCart() {
		this.goodsList = new LinkedList<Goods>();
	}

	/**
	 * goods list
	 * 
	 * @return
	 */
	public List<Goods> getGoodsList() {
		return goodsList;
	}

	/**
	 * add a new goods to shopping cart
	 * 
	 * @param goods
	 */
	public void addGoods(Goods goods) {
		this.goodsList.add(goods);
	}

	/**
	 * get the goods count in cart
	 * 
	 * @return
	 */
	public int count() {
		if (this.goodsList == null)
			return 0;
		return this.goodsList.size();
	}

	/**
	 * get total taxes of all goods
	 * 
	 * @return
	 */
	public BigDecimal totalTax() {
		BigDecimal totalTaxes = new BigDecimal("0.00");
		for (Goods goods : this.goodsList) {
			totalTaxes = totalTaxes.add(goods.getTax());
		}
		return totalTaxes;
	}

	/**
	 * get total price with tax of all goods
	 * 
	 * @return
	 */
	public BigDecimal totalPrice() {
		BigDecimal totalPrice = new BigDecimal("0.00");
		for (Goods goods : getGoodsList()) {
			totalPrice = totalPrice.add(goods.getTotalPrice());
		}
		return totalPrice;
	}

}
