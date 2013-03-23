package tw.sales.taxes.goods;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import tw.sales.taxes.tax.TaxCalculate;
import tw.sales.taxes.tax.TaxCaluclate4Import;

public class GoodsTest {

	private Goods goods;
	private TaxCalculate taxCaluclate4Import;
	private BigDecimal goodsPrice;

	@Before
	public void setUp() {
		goodsPrice = new BigDecimal("12.50");
		taxCaluclate4Import = new TaxCaluclate4Import();
	}

	@Test
	public void it_get_tax_with_zero_tax_should_equals_zero() {
		goods = new Goods("book", GoodsType.BOOK, goodsPrice,
				taxCaluclate4Import);
		assertEquals(new BigDecimal("0.00"), goods.getTax());
	}

	@Test
	public void it_get_tax_with_basic_tax_should_be_right() {
		goods = new Goods("music CD", GoodsType.MUSIC, goodsPrice,
				taxCaluclate4Import);
		assertEquals(new BigDecimal("1.25"), goods.getTax());
	}

	@Test
	public void it_get_tax_with_basic_and_imported_tax_should_be_right() {
		goods = new Goods("perfume", GoodsType.PERFUME, goodsPrice, true,
				taxCaluclate4Import);
		assertEquals(new BigDecimal("1.90"), goods.getTax());
	}

	@Test
	public void it_get_tax_with_zero_price_should_equal_zero() {
		goods = new Goods("music CD", GoodsType.MUSIC, BigDecimal.ZERO, true,
				taxCaluclate4Import);
		assertEquals(new BigDecimal("0.00"), goods.getTax());
	}

	@Test
	public void it_get_total_price_with_zero_tax_should_equal_shelf_price() {
		goods = new Goods("medical product", GoodsType.MEDICAL, goodsPrice,
				taxCaluclate4Import);
		assertEquals(goodsPrice, goods.getTotalPrice());
	}

	@Test
	public void it_get_total_price_with_basic_tax_should_be_right() {
		goods = new Goods("perfume", GoodsType.PERFUME, goodsPrice,
				taxCaluclate4Import);
		assertEquals(new BigDecimal("13.75"), goods.getTotalPrice());
	}

	@Test
	public void it_get_total_price_with_basic_and_imported_tax_should_be_right() {
		goods = new Goods("other", GoodsType.OTHER, goodsPrice, true,
				taxCaluclate4Import);
		assertEquals(new BigDecimal("14.40"), goods.getTotalPrice());
	}

	@Test
	public void it_get_total_price_with_zero_price_should_equal_zero() {
		goods = new Goods("other", GoodsType.OTHER, BigDecimal.ZERO, true,
				taxCaluclate4Import);
		assertEquals(new BigDecimal("0.00"), goods.getTotalPrice());
	}

}
