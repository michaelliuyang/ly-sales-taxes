package tw.sales.taxes.tax;

import tw.sales.taxes.NumberUtil;

/**
 * Single tax
 * 
 * @author liuyang
 * 
 */
public class SingleTax implements Tax {

	private float rate;

	public SingleTax(float rate) {
		this.rate = rate;
	}

	public float getRate() {
		return rate;
	}

	@Override
	public float getTax(float goodsPrice) {
		return NumberUtil.round(goodsPrice * rate);
	}

}
