package tw.sales.taxes.tax;

import java.math.BigDecimal;

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
		return round(goodsPrice * rate);
	}

	private float round(float num) {
		return new BigDecimal((float) Math.ceil(num / 0.05f) * 0.05f).setScale(
				2, BigDecimal.ROUND_HALF_UP).floatValue();
	}
}
