package tw.sales.taxes;

public abstract class Receipt {

	ShoppingCart cart;

	protected abstract void output();

	public Receipt(ShoppingCart cart) {
		this.cart = cart;
	}

	public void print() {
		if (this.cart == null)
			return;
		output();
	}

	public void setCart(ShoppingCart cart) {
		this.cart = cart;
	}

}
