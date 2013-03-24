package tw.sales.taxes;

import tw.sales.taxes.goods.Goods;

/**
 * Small Shop receipt class Extends receipt class
 * 
 * @author liuyang
 * 
 */
public class SmallShopReceipt extends Receipt {

	public SmallShopReceipt(ShoppingCart cart) {
		super(cart);
	}

	@Override
	protected void output() {
		if (cart == null || cart.count() == 0)
			return;
		System.out.println("------Welcome To Small Shop------");
		System.out.println("item count:" + cart.count());
		for (Goods goods : this.cart.getGoodsList()) {
			System.out.println("1 " + goods.getName() + ":"
					+ goods.getTotalPrice());
		}
		System.out.println("Sales Taxes:" + this.cart.totalTax());
		System.out.println("Total:" + this.cart.totalPrice());
		System.out.println("---------------------------------");
	}

}
