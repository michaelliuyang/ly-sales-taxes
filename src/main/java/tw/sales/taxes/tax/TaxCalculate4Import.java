package tw.sales.taxes.tax;

import java.math.BigDecimal;

import tw.sales.taxes.goods.Goods;

/**
 * Implements interface TaxCalculate
 * 
 * @author liuyang
 * 
 */
public class TaxCalculate4Import implements TaxCalculate {

	@Override
	public BigDecimal calculateTax(Goods goods) {
		CompositeTax comTax = new CompositeTax();
		comTax.addTax(new SingleTax(goods.getGoodsType().getBasicTaxRate()));
		if (goods.isImported())
			comTax.addTax(new SingleTax(AdditionalTaxCategory.IMPORTED_TAX
					.getRate()));
		return comTax.getTax(goods.getShelfPrice());
	}

}
