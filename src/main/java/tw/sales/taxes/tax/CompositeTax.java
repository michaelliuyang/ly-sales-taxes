package tw.sales.taxes.tax;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

/**
 * Composite tax: implements interface tax 
 * This is a tax which may be has one tax or some taxes, it is a tax list.
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
