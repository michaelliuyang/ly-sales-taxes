package tw.sales.taxes.tax;

public enum AdditionalTaxCategory {

	IMPORTED_TAX(0.05f);

	private float rate;

	private AdditionalTaxCategory(float rate) {
		this.rate = rate;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

}
