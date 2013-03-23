package tw.sales.taxes.tax;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import tw.sales.taxes.goods.Goods;
import tw.sales.taxes.goods.GoodsType;

public class TaxCalculate4ImportTest {

	private TaxCaluclate4Import taxCaluclate4Import;
	private Goods goods;
	private BigDecimal goodsPrice;

	@Before
	public void setUp() {
		goodsPrice = new BigDecimal("12.59");
		taxCaluclate4Import = new TaxCaluclate4Import();
	}

	@Test
	public void it_calculate_tax_with_zero_tax_should_equal_zero() {
		goods = new Goods("book", GoodsType.BOOK, goodsPrice,
				taxCaluclate4Import);
		assertEquals(new BigDecimal("0.00"),
				taxCaluclate4Import.calculateTax(goods));
	}

	@Test
	public void it_calculate_tax_with_basic_tax_should_be_right() {
		goods = new Goods("music CD", GoodsType.MUSIC, goodsPrice,
				taxCaluclate4Import);
		assertEquals(new BigDecimal("1.30"),
				taxCaluclate4Import.calculateTax(goods));
	}

	@Test
	public void it_calculate_tax_with_basic_and_imported_should_be_right() {
		goods = new Goods("music CD", GoodsType.MUSIC, goodsPrice, true,
				taxCaluclate4Import);
		assertEquals(new BigDecimal("1.95"),
				taxCaluclate4Import.calculateTax(goods));
	}

	@Test
	public void it_calculate_tax_with_zero_price_should_equal_zero() {
		goods = new Goods("music CD", GoodsType.MUSIC, BigDecimal.ZERO, true,
				taxCaluclate4Import);
		assertEquals(new BigDecimal("0.00"),
				taxCaluclate4Import.calculateTax(goods));
	}

}
