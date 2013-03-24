package tw.sales.taxes.tax;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

/**
 * Composite tax Implements interface tax ,this is a tax which may be has one
 * tax or some taxes.
 * 
 * @author liuyang
 * 
 */
public class CompositeTax implements Tax {

	private List<Tax> taxList;

	/**
	 * Constructor
	 */
	public CompositeTax() {
		taxList = new LinkedList<Tax>();
	}

	public void addTax(Tax tax) {
		this.taxList.add(tax);
	}

	public List<Tax> getTaxList() {
		return this.taxList;
	}

	@Override
	public BigDecimal getTax(BigDecimal goodsPrice) {
		BigDecimal totalTax = BigDecimal.ZERO;
		for (Tax tax : this.taxList) {
			totalTax = totalTax.add(tax.getTax(goodsPrice));
		}
		return totalTax;
	}

}
