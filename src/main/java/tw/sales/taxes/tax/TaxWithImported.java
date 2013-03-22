package tw.sales.taxes.tax;

import tw.sales.taxes.goods.Goods;

public class TaxWithImported implements TaxCalculate {

	public static final float IMPORTED_RATE = 0.05f;

	@Override
	public float calculateTax(Goods goods) {
		CompositeTax comTax = new CompositeTax();
		comTax.addTax(new SingleTax(goods.getGoodsType().getTaxRate()));
		if (goods.isImported()) {
			comTax.addTax(new SingleTax(IMPORTED_RATE));
		}
		return comTax.getTax(goods.getShelfPrice());
	}

}
