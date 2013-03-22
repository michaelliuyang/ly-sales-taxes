package tw.sales.taxes.tax;

import tw.sales.taxes.goods.Goods;

/**
 * Tax calculate interface
 * @author liuyang
 *
 */
public interface TaxCalculate {
	
	float calculateTax(Goods goods);
	
}
