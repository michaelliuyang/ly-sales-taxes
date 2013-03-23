package tw.sales.taxes;

/**
 * Receipt class
 * 
 * @author liuyang
 * 
 */
public abstract class Receipt {

	protected ShoppingCart cart;

	protected abstract void output();

	/**
	 * Constructor
	 * 
	 * @param cart
	 */
	public Receipt(ShoppingCart cart) {
		this.cart = cart;
	}

	/**
	 * Print receipt
	 */
	public void print() {
		if (this.cart == null)
			return;
		output();
	}

	public void setCart(ShoppingCart cart) {
		this.cart = cart;
	}

}
