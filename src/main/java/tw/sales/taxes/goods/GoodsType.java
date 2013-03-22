package tw.sales.taxes.goods;

/**
 * goods type enum
 * 
 * @author liuyang
 * 
 */
public enum GoodsType {

	BOOK(0f), FOOD(0f), MEDICAL(0f), PERFUME, MUSIC, OTHER;

	private float taxRate;

	private GoodsType() {
		this.taxRate = 0.1f;
	}

	private GoodsType(float taxRate) {
		this.taxRate = taxRate;
	}

	/**
	 * type's tax rate
	 * 
	 * @return
	 */
	public float getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(float taxRate) {
		this.taxRate = taxRate;
	}

}
