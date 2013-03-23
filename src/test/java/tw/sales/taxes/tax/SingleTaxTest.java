package tw.sales.taxes.tax;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import tw.sales.taxes.tax.SingleTax;

public class SingleTaxTest {

	private SingleTax singleTax;
	private BigDecimal goodsPrice;

	@Before
	public void setUp() {
		goodsPrice = new BigDecimal("12.99");
	}

	@Test
	public void it_get_tax_with_zero_rate_should_equal_zero() {
		singleTax = new SingleTax(BigDecimal.ZERO);
		assertEquals(new BigDecimal("0.00"), singleTax.getTax(goodsPrice));
	}

	@Test
	public void it_get_tax_should_be_rigth() {
		singleTax = new SingleTax(new BigDecimal("0.1"));
		assertEquals(new BigDecimal("1.30"), singleTax.getTax(goodsPrice));
	}

	@Test
	public void it_get_tax_with_zero_price_should_equal_zero() {
		singleTax = new SingleTax(new BigDecimal("0.1"));
		assertEquals(new BigDecimal("0.00"), singleTax.getTax(BigDecimal.ZERO));
	}

}
