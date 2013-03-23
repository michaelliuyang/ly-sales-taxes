package tw.sales.taxes.goods;

import java.math.BigDecimal;

/**
 * goods type enum
 * 
 * @author liuyang
 * 
 */
public enum GoodsType {

	BOOK(BigDecimal.ZERO), FOOD(BigDecimal.ZERO), 
	MEDICAL(BigDecimal.ZERO), PERFUME, MUSIC, OTHER;

	private BigDecimal basicTaxRate;

	private GoodsType() {
		this.basicTaxRate = new BigDecimal("0.1");
	}

	private GoodsType(BigDecimal basicTaxRate) {
		this.basicTaxRate = basicTaxRate;
	}

	/**
	 * type's tax rate
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
