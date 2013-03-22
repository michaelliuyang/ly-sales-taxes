package tw.sales.taxes.tax;

import tw.sales.taxes.goods.Goods;

public class TaxCaluclate4Import implements TaxCalculate {

	@Override
	public float calculateTax(Goods goods) {
		CompositeTax comTax = new CompositeTax();
		comTax.addTax(new SingleTax(goods.getGoodsType().getBasicTaxRate()));
		if (goods.isImported())
			comTax.addTax(new SingleTax(AdditionalTaxCategory.IMPORTED_TAX
					.getRate()));
		return comTax.getTax(goods.getShelfPrice());
	}

}
