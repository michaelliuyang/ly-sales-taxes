package tw.sales.taxes;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NumberUtil {

	private NumberUtil() {
	}

	public static BigDecimal round(BigDecimal num) {
		BigDecimal seed = new BigDecimal("0.05");
		return num.divide(seed).setScale(0, RoundingMode.UP).multiply(seed);
	}

}
