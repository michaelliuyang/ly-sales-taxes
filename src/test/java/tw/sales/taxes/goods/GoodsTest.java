package tw.sales.taxes.goods;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import tw.sales.taxes.tax.TaxCalculate;
import tw.sales.taxes.tax.TaxWithImported;

public class GoodsTest {

	Goods goods;
	TaxCalculate taxWithImported;
	float goodsPrice = 12.5f;

	@Before
	public void setup() {
		taxWithImported = new TaxWithImported();
	}

	@Test
	public void get_tax_of_no_import_goods_should_be_right() {
		goods = new Goods("book", GoodsType.BOOK, this.goodsPrice,
				taxWithImported);
		float expected = GoodsType.BOOK.getTaxRate() * this.goodsPrice;
		assertTrue(expected == goods.getTax());
	}

	@Test
	public void get_tax_of_imported_goods_should_be_right() {
		goods = new Goods("book", GoodsType.MUSIC, this.goodsPrice, true,
				taxWithImported);
	}

}
