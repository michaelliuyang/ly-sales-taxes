package tw.sales.taxes;

import java.math.BigDecimal;

import tw.sales.taxes.goods.Goods;
import tw.sales.taxes.goods.GoodsType;
import tw.sales.taxes.tax.TaxCalculate;
import tw.sales.taxes.tax.TaxCaluclate4Import;

public class Run {

	public static void main(String[] args) {
		TaxCalculate tc = new TaxCaluclate4Import();
		ShoppingCart cartOne = new ShoppingCart();
		Goods book = new Goods("book", GoodsType.BOOK, new BigDecimal("12.49"),
				tc);
		Goods musicCD = new Goods("music CD", GoodsType.MUSIC, new BigDecimal(
				"14.99"), tc);
		Goods chocolateBar = new Goods("chocolate bar", GoodsType.FOOD,
				new BigDecimal("0.85"), tc);
		cartOne.addGoods(book);
		cartOne.addGoods(musicCD);
		cartOne.addGoods(chocolateBar);
		Receipt receipt = new SmallShopReceipt(cartOne);
		receipt.print();

		ShoppingCart cartTwo = new ShoppingCart();
		Goods importedChocolate = new Goods("imported chocolate",
				GoodsType.FOOD, new BigDecimal("10"), true, tc);
		Goods importedPerfume = new Goods("imported perfume",
				GoodsType.PERFUME, new BigDecimal("47.5"), true, tc);
		cartTwo.addGoods(importedChocolate);
		cartTwo.addGoods(importedPerfume);
		receipt.setCart(cartTwo);
		receipt.print();

		ShoppingCart cartThree = new ShoppingCart();
		Goods importedPerfumeAnother = new Goods("imported perfume",
				GoodsType.PERFUME, new BigDecimal("27.99"), true, tc);
		Goods perfume = new Goods("perfume", GoodsType.PERFUME, new BigDecimal(
				"18.99"), tc);
		Goods headachePills = new Goods("headache pills", GoodsType.MEDICAL,
				new BigDecimal("9.75"), tc);
		Goods importedChocolateAnother = new Goods("chocolate", GoodsType.FOOD,
				new BigDecimal("11.25"), true, tc);
		cartThree.addGoods(importedPerfumeAnother);
		cartThree.addGoods(perfume);
		cartThree.addGoods(headachePills);
		cartThree.addGoods(importedChocolateAnother);
		receipt.setCart(cartThree);
		receipt.print();
	}

}
