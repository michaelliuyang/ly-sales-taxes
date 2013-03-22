package tw.sales.taxes;

import tw.sales.taxes.goods.Goods;
import tw.sales.taxes.goods.GoodsType;
import tw.sales.taxes.tax.TaxCalculate;
import tw.sales.taxes.tax.TaxWithImported;

public class Run {

	public static void main(String[] args) {
		TaxCalculate tc = new TaxWithImported();
		ShoppingCart cartOne = new ShoppingCart();
		Goods book = new Goods("book", GoodsType.BOOK, 12.49f, tc);
		Goods musicCD = new Goods("music CD", GoodsType.MUSIC, 14.99f, tc);
		Goods chocolateBar = new Goods("chocolate bar", GoodsType.FOOD, 0.85f,
				tc);
		cartOne.addGoods(book);
		cartOne.addGoods(musicCD);
		cartOne.addGoods(chocolateBar);
		Receipt receipt = new SmallShopReceipt(cartOne);
		receipt.print();

		ShoppingCart cartTwo = new ShoppingCart();
		Goods importedChocolate = new Goods("imported chocolate",
				GoodsType.FOOD, 10f, true, tc);
		Goods importedPerfume = new Goods("imported perfume",
				GoodsType.PERFUME, 47.5f, true, tc);
		cartTwo.addGoods(importedChocolate);
		cartTwo.addGoods(importedPerfume);
		receipt.setCart(cartTwo);
		receipt.print();

		ShoppingCart cartThree = new ShoppingCart();
		Goods importedPerfumeAnother = new Goods("imported perfume",
				GoodsType.PERFUME, 27.99f, true, tc);
		Goods perfume = new Goods("perfume", GoodsType.PERFUME, 18.99f, tc);
		Goods headachePills = new Goods("headache pills", GoodsType.MEDICAL,
				9.75f, tc);
		Goods importedChocolateAnother = new Goods("chocolate", GoodsType.FOOD,
				11.25f, true, tc);
		cartThree.addGoods(importedPerfumeAnother);
		cartThree.addGoods(perfume);
		cartThree.addGoods(headachePills);
		cartThree.addGoods(importedChocolateAnother);
		receipt.setCart(cartThree);
		receipt.print();
	}

}
