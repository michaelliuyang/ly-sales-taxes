package tw.sales.taxes;

import java.util.LinkedList;
import java.util.List;

import tw.sales.taxes.goods.Goods;

public class ShoppingCart {

	private List<Goods> goodsList;

	public ShoppingCart() {
		this.goodsList = new LinkedList<Goods>();
	}

	public List<Goods> getGoodsList() {
		return goodsList;
	}

	public void addGoods(Goods goods) {
		this.goodsList.add(goods);
	}

	public int count() {
		if (this.goodsList == null)
			return 0;
		return this.goodsList.size();
	}

	public float totalTaxes() {
		float totalTaxes = 0f;
		for (Goods goods : this.goodsList) {
			totalTaxes += goods.getTax();
		}
		return totalTaxes;
	}

	public float totalPriceWithTax() {
		float totalPrice = 0f;
		for (Goods goods : getGoodsList()) {
			totalPrice += goods.getPriceWithTax();
		}
		return totalPrice;
	}

}
