package tw.sales.taxes.tax;

import java.math.BigDecimal;

/**
 * Additional tax category enum
 * 
 * @author liuyang
 * 
 */
public enum AdditionalTaxCategory {

	IMPORTED_TAX(new BigDecimal("0.05"));

	private BigDecimal rate;

	/**
	 * Constructor
	 * 
	 * @param rate
	 */
	private AdditionalTaxCategory(BigDecimal rate) {
		this.rate = rate;
	}

	/**
	 * tax rate
	 * 
	 * @return
	 */
	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

}
