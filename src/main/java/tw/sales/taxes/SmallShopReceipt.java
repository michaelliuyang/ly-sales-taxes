package tw.sales.taxes;

import tw.sales.taxes.goods.Goods;

public class SmallShopReceipt extends Receipt {

	public SmallShopReceipt(ShoppingCart cart) {
		super(cart);
	}

	@Override
	protected void output() {
		System.out.println("------Welcome To Small Shop------");
		System.out.println("item count:" + cart.count());
		for (Goods goods : this.cart.getGoodsList()) {
			System.out.println("1 " + goods.getName() + ":"
					+ goods.getPriceWithTax());
		}
		System.out.println("Sales Taxes:" + this.cart.totalTaxes());
		System.out.println("Total:" + this.cart.totalPriceWithTax());
		System.out.println("---------------------------------");
	}

}
