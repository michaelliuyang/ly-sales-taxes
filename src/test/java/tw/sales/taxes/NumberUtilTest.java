package tw.sales.taxes;

import java.math.BigDecimal;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import tw.sales.taxes.NumberUtil;

public class NumberUtilTest {
	
	@Test
	public void it_round_should_be_right(){
		BigDecimal actual = NumberUtil.round(new BigDecimal("12.459"));
		assertEquals(new BigDecimal("12.50"), actual);
	}
	
	@Test
	public void it_round_with_zero_num_should_equal_zero(){
		BigDecimal actual = NumberUtil.round(BigDecimal.ZERO);
		assertEquals(new BigDecimal("0.00"), actual);
	}
	
}
