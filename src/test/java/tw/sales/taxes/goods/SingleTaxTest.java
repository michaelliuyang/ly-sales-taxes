package tw.sales.taxes.goods;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import tw.sales.taxes.tax.SingleTax;

public class SingleTaxTest {
	
	SingleTax singleTax;
	
	@Test
	public void get_tax_should_be_right(){
		singleTax = new SingleTax(0.1f);
		assertTrue(10f == singleTax.getTax(100f));
	}
	
	@Test
	public void get_tax_with_zero_rate_should_be_right(){
		singleTax = new SingleTax(0f);
		assertTrue(0f == singleTax.getTax(100f));
	}
	
	@Test
	public void get_tax_by_round_should_be_right(){
		singleTax = new SingleTax(0.05f);
		assertTrue(0.65f == singleTax.getTax(12.99f));
	}
	
}
