package tw.sales.taxes.tax;

import java.math.BigDecimal;

import tw.sales.taxes.goods.Goods;

/**
 * Tax calculate interface
 * You should implement it if you want to add a new tax calculate.
 * 
 * @author liuyang
 * 
 */
public interface TaxCalculate {

	BigDecimal calculateTax(Goods goods);

}
