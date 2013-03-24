package tw.sales.taxes;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import tw.sales.taxes.goods.Goods;
import tw.sales.taxes.goods.GoodsType;
import tw.sales.taxes.tax.TaxCalculate;
import tw.sales.taxes.tax.TaxCalculate4Import;

public class ShoppingCartTest {

	private ShoppingCart cart;

	@Before
	public void setUp() {
		cart = new ShoppingCart();
	}

	@Test
	public void it_get_total_taxes_with_empty_should_be_zero() {
		assertEquals(new BigDecimal("0.00"), cart.totalTax());
	}

	@Test
	public void it_get_total_taxes_should_be_right() {
		TaxCalculate tc = new TaxCalculate4Import();
		Goods book = new Goods("book", GoodsType.BOOK, new BigDecimal("12"), tc);
		Goods perfume = new Goods("perfume", GoodsType.PERFUME, new BigDecimal(
				"12.9"), tc);
		cart.addGoods(book);
		cart.addGoods(perfume);
		assertEquals(new BigDecimal("1.30"), cart.totalTax());
	}

	@Test
	public void it_get_total_price_with_empty_should_be_zero() {
		assertEquals(new BigDecimal("0.00"), cart.totalPrice());
	}

	@Test
	public void it_get_total_price_should_be_right() {
		TaxCalculate tc = new TaxCalculate4Import();
		Goods book = new Goods("book", GoodsType.BOOK, new BigDecimal("12"), tc);
		Goods perfume = new Goods("perfume", GoodsType.PERFUME, new BigDecimal(
				"12.9"), tc);
		cart.addGoods(book);
		cart.addGoods(perfume);
		assertEquals(new BigDecimal("26.20"), cart.totalPrice());
	}

	@Test
	public void it_count_with_empty_should_equal_zero() {
		assertEquals(0, cart.count());
	}

	@Test
	public void it_count_should_be_right() {
		TaxCalculate tc = new TaxCalculate4Import();
		Goods book = new Goods("book", GoodsType.BOOK, new BigDecimal("12"), tc);
		Goods perfume = new Goods("perfume", GoodsType.PERFUME, new BigDecimal(
				"12.9"), tc);
		cart.addGoods(book);
		cart.addGoods(perfume);
		assertEquals(2, cart.count());
	}

	@Test
	public void it_add_goods_should_be_right() {
		TaxCalculate tc = new TaxCalculate4Import();
		Goods book = new Goods("book", GoodsType.BOOK, new BigDecimal("12"), tc);
		Goods perfume = new Goods("perfume", GoodsType.PERFUME, new BigDecimal(
				"12.9"), tc);
		cart.addGoods(book);
		cart.addGoods(perfume);
		assertEquals(2, cart.getGoodsList().size());
	}
}
