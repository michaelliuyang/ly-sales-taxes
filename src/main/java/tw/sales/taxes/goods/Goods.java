package tw.sales.taxes.goods;

import java.math.BigDecimal;

import tw.sales.taxes.tax.TaxCalculate;

/**
 * Goods model class
 * 
 * @author liuyang
 * 
 */
public class Goods {

	private TaxCalculate taxCalculate;

	private String name;
	private BigDecimal shelfPrice;
	private GoodsType goodsType;
	private boolean isImported = false;

	/**
	 * Constructor for not imported goods
	 * 
	 * @param name
	 * @param goodsType
	 * @param shelfPrice
	 * @param taxCalculate
	 */
	public Goods(String name, GoodsType goodsType, BigDecimal shelfPrice,
			TaxCalculate taxCalculate) {
		this.name = name;
		this.goodsType = goodsType;
		this.shelfPrice = shelfPrice;
		this.taxCalculate = taxCalculate;
	}

	/**
	 * Constructor for imported goods
	 * 
	 * @param name
	 * @param goodsType
	 * @param shelfPrice
	 * @param isImported
	 * @param taxCalculate
	 */
	public Goods(String name, GoodsType goodsType, BigDecimal shelfPrice,
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
	 * goods basic price without tax
	 * 
	 * @return
	 */
	public BigDecimal getShelfPrice() {
		return shelfPrice;
	}

	public void setShelfPrice(BigDecimal shelfPrice) {
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
	 * whether import goods
	 * 
	 * @return
	 */
	public boolean isImported() {
		return isImported;
	}

	public void setImported(boolean isImported) {
		this.isImported = isImported;
	}

	public BigDecimal getTax() {
		return this.taxCalculate.calculateTax(this);
	}

	public BigDecimal getTotalPrice() {
		return this.getShelfPrice().add(getTax());
	}

}
