package tw.sales.taxes.goods;

/**
 * goods type enum
 * 
 * @author liuyang
 * 
 */
public enum GoodsType {

	BOOK(0f), FOOD(0f), MEDICAL(0f), PERFUME, MUSIC, OTHER;

	private float basicTaxRate;

	private GoodsType() {
		this.basicTaxRate = 0.1f;
	}

	private GoodsType(float basicTaxRate) {
		this.basicTaxRate = basicTaxRate;
	}

	/**
	 * type's tax rate
	 * 
	 * @return
	 */
	public float getBasicTaxRate() {
		return basicTaxRate;
	}

	public void setBasicTaxRate(float basicTaxRate) {
		this.basicTaxRate = basicTaxRate;
	}

}
