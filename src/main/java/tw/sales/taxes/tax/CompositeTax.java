package tw.sales.taxes.tax;

import java.util.LinkedList;
import java.util.List;

/**
 * Composite tax: implements interface tax This is a tax which may be has one
 * tax or some taxes, it is a tax list.
 * 
 * @author liuyang
 * 
 */
public class CompositeTax implements Tax {

	private List<Tax> taxList;

	public CompositeTax() {
		taxList = new LinkedList<Tax>();
	}

	public void addTax(Tax tax) {
		this.taxList.add(tax);
	}

	@Override
	public float getTax(float goodsPrice) {
		float totalTax = 0f;
		for (Tax tax : this.taxList) {
			totalTax += tax.getTax(goodsPrice);
		}
		return totalTax;
	}

}
