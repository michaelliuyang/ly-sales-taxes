package tw.sales.taxes.tax;

import java.math.BigDecimal;

/**
 * Tax interface 
 * You should implement it if you want to add a new tax.
 * 
 * @author liuyang
 * 
 */
public interface Tax {
	
	BigDecimal getTax(BigDecimal goodsPrice);
	
}
