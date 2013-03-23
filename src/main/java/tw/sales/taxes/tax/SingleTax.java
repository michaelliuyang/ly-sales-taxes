package tw.sales.taxes.tax;

import java.math.BigDecimal;

import tw.sales.taxes.NumberUtil;

/**
 * Single tax
 * 
 * @author liuyang
 * 
 */
public class SingleTax implements Tax {

	private BigDecimal rate;

	/**
	 * Constructor Create a custom tax object which has custom rate
	 * 
	 * @param rate
	 */
	public SingleTax(BigDecimal rate) {
		this.rate = rate;
	}

	/**
	 * get tax rate
	 * 
	 * @return
	 */
	public BigDecimal getRate() {
		return rate;
	}

	@Override
	public BigDecimal getTax(BigDecimal goodsPrice) {
		return NumberUtil.round(goodsPrice.multiply(rate));
	}

}
