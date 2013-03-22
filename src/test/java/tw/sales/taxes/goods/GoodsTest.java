package tw.sales.taxes.goods;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import tw.sales.taxes.NumberUtil;
import tw.sales.taxes.tax.AdditionalTaxCategory;
import tw.sales.taxes.tax.TaxCalculate;
import tw.sales.taxes.tax.TaxCaluclate4Import;

public class GoodsTest {

	Goods goods;
	TaxCalculate taxCaluclate4Import;
	float goodsPrice = 12.5f;

	@Before
	public void setup() {
		taxCaluclate4Import = new TaxCaluclate4Import();
	}

	@Test
	public void get_tax_without_imported_duty_should_be_right() {
		goods = new Goods("book", GoodsType.BOOK, this.goodsPrice,
				taxCaluclate4Import);
		float expected = NumberUtil.round(GoodsType.BOOK.getBasicTaxRate()
				* this.goodsPrice);
		assertTrue(expected == goods.getTax());
	}

	@Test
	public void get_tax_with_imported_duty_should_be_right() {
		goods = new Goods("music CD", GoodsType.MUSIC, this.goodsPrice, true,
				taxCaluclate4Import);
		float expected = NumberUtil
				.round(this.goodsPrice
						* (GoodsType.MUSIC.getBasicTaxRate() + AdditionalTaxCategory.IMPORTED_TAX
								.getRate()));
		assertTrue(expected == goods.getTax());
	}
	
	@Test
	public void get_tax_with_zero_price_should_be_right(){
		goods = new Goods("music CD", GoodsType.MUSIC, 0f, true,
				taxCaluclate4Import);
		assertTrue(0f == goods.getTax());
	}

	@Test
	public void get_price_with_tax_should_be_right() {
		goods = new Goods("medical product", GoodsType.MEDICAL, this.goodsPrice,
				taxCaluclate4Import);
		float expected = NumberUtil.round(goods.getTax()) + this.goodsPrice;
		assertTrue(expected == goods.getPriceWithTax());
	}
	
	@Test
	public void get_price_with_tax_with_zero_price_should_be_right(){
		goods = new Goods("perfume", GoodsType.PERFUME, 0f, taxCaluclate4Import);
		assertTrue(0f == goods.getPriceWithTax());
	}

}
