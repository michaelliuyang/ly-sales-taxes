package tw.sales.taxes.goods;

import java.math.BigDecimal;

/**
 * goods type enum
 * 
 * @author liuyang
 * 
 */
public enum GoodsType {

	BOOK(BigDecimal.ZERO), FOOD(BigDecimal.ZERO), MEDICAL(BigDecimal.ZERO), PERFUME, MUSIC, OTHER;

	private BigDecimal basicTaxRate;

	/**
	 * Constructor for default rate
	 */
	private GoodsType() {
		this.basicTaxRate = new BigDecimal("0.1");
	}

	/**
	 * Constructor
	 * 
	 * @param basicTaxRate
	 */
	private GoodsType(BigDecimal basicTaxRate) {
		this.basicTaxRate = basicTaxRate;
	}

	/**
	 * type's basic tax rate
	 * 
	 * @return
	 */
	public BigDecimal getBasicTaxRate() {
		return basicTaxRate;
	}

	public void setBasicTaxRate(BigDecimal basicTaxRate) {
		this.basicTaxRate = basicTaxRate;
	}

}
