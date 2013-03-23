package tw.sales.taxes.tax;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class CompositeTaxTest {

	private CompositeTax compositeTax;
	private BigDecimal goodsPrice;

	@Before
	public void setUp() {
		compositeTax = new CompositeTax();
		goodsPrice = new BigDecimal("13.45");
	}

	@Test
	public void it_get_tax_with_empty_tax_list_should_equal_zero() {
		assertEquals(BigDecimal.ZERO, compositeTax.getTax(goodsPrice));
	}

	@Test
	public void it_get_tax_should_be_right() {
		compositeTax.addTax(new SingleTax(new BigDecimal("0.1")));
		compositeTax.addTax(new SingleTax(new BigDecimal("0.15")));
		assertEquals(new BigDecimal("3.40"), compositeTax.getTax(goodsPrice));
	}

	@Test
	public void add_tax_should_be_right() {
		compositeTax.addTax(new SingleTax(new BigDecimal("0.1")));
		compositeTax.addTax(new SingleTax(new BigDecimal("0.1")));
		assertEquals(2, compositeTax.getTaxList().size());
	}

}
