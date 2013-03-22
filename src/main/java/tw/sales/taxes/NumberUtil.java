package tw.sales.taxes;

import java.math.BigDecimal;

public class NumberUtil {

	private NumberUtil() {
	}

	public static float round(float num, float round, int scale) {
		return new BigDecimal((float) Math.ceil(num / round) * round).setScale(
				scale, BigDecimal.ROUND_HALF_UP).floatValue();
	}

	public static float round(float num) {
		return round(num, 0.05f, 2);
	}

}
