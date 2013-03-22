package tw.sales.taxes.goods;

import tw.sales.taxes.tax.TaxCalculate;

/**
 * goods model class
 * 
 * @author liuyang
 * 
 */
public class Goods {

	private TaxCalculate taxCalculate;

	private String name;
	private float shelfPrice;
	private GoodsType goodsType;
	private boolean isImported = false;

	public Goods(String name, GoodsType goodsType, float shelfPrice,
			TaxCalculate taxCalculate) {
		this.name = name;
		this.goodsType = goodsType;
		this.shelfPrice = shelfPrice;
		this.taxCalculate = taxCalculate;
	}

	public Goods(String name, GoodsType goodsType, float shelfPrice,
			boolean isImported, TaxCalculate taxCalculate) {
		this.name = name;
		this.goodsType = goodsType;
		this.shelfPrice = shelfPrice;
		this.isImported = isImported;
		this.taxCalculate = taxCalculate;
	}

	/**
	 * goods name
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * goods basic price
	 * 
	 * @return
	 */
	public float getShelfPrice() {
		return shelfPrice;
	}

	public void setShelfPrice(float shelfPrice) {
		this.shelfPrice = shelfPrice;
	}

	/**
	 * goods type
	 * 
	 * @return
	 */
	public GoodsType getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(GoodsType goodsType) {
		this.goodsType = goodsType;
	}

	/**
	 * is import goods or not
	 * 
	 * @return
	 */
	public boolean isImported() {
		return isImported;
	}

	public void setImported(boolean isImported) {
		this.isImported = isImported;
	}

	/**
	 * goods tax
	 * 
	 * @return
	 */
	public float getTax() {
		return this.taxCalculate.calculateTax(this);
	}

	public float getPriceWithTax() {
		return this.getShelfPrice() + getTax();
	}

}
