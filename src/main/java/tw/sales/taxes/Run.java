package tw.sales.taxes;

import java.math.BigDecimal;

import tw.sales.taxes.goods.Goods;
import tw.sales.taxes.goods.GoodsType;
import tw.sales.taxes.tax.TaxCalculate;
import tw.sales.taxes.tax.TaxCalculate4Import;

public class Run {

	private static TaxCalculate tc = new TaxCalculate4Import();

	public static void main(String[] args) {
		inputOne();
		inputTwo();
		inputThree();
	}

	private static void inputOne() {
		Goods book = new Goods("book", GoodsType.BOOK, new BigDecimal("12.49"),
				tc);
		Goods musicCD = new Goods("music CD", GoodsType.MUSIC, new BigDecimal(
				"14.99"), tc);
		Goods chocolateBar = new Goods("chocolate bar", GoodsType.FOOD,
				new BigDecimal("0.85"), tc);
		settleAccounts(book, musicCD, chocolateBar);
	}

	private static void inputTwo() {
		Goods importedChocolate = new Goods("imported chocolate",
				GoodsType.FOOD, new BigDecimal("10"), true, tc);
		Goods importedPerfume = new Goods("imported perfume",
				GoodsType.PERFUME, new BigDecimal("47.5"), true, tc);
		settleAccounts(importedChocolate, importedPerfume);
	}

	private static void inputThree() {
		Goods importedPerfumeAnother = new Goods("imported perfume",
				GoodsType.PERFUME, new BigDecimal("27.99"), true, tc);
		Goods perfume = new Goods("perfume", GoodsType.PERFUME, new BigDecimal(
				"18.99"), tc);
		Goods headachePills = new Goods("headache pills", GoodsType.MEDICAL,
				new BigDecimal("9.75"), tc);
		Goods importedChocolateAnother = new Goods("chocolate", GoodsType.FOOD,
				new BigDecimal("11.25"), true, tc);
		settleAccounts(importedPerfumeAnother, perfume, headachePills,
				importedChocolateAnother);
	}

	private static void settleAccounts(Goods... goods) {
		if (goods == null)
			return;
		ShoppingCart cart = new ShoppingCart();
		for (Goods g : goods) {
			cart.addGoods(g);
		}
		Receipt receipt = new SmallShopReceipt(cart);
		receipt.print();
	}

}
