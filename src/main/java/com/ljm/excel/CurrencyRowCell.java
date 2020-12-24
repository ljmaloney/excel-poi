package com.ljm.excel;

import java.math.BigDecimal;
/**
 * Class for the display and manipulation of currency data
 * 
 * @author luthermaloney
 *
 */
public class CurrencyRowCell extends NumericRowCell {

	public CurrencyRowCell(Double value) {
		super(value);
	}

	public CurrencyRowCell(BigDecimal decimal) {
		super(decimal != null ? decimal.doubleValue() : 0d);
	}
	/**
	 * Returns the default format for a currency cell. In Excel, a currency cell can 
	 * use two formats, one for positive numbers, and one for negative numbers. Negative amounts
	 * are displayed inside parentheses and in red. Currency amounts are normally displayed 
	 * with two decimals of precision.
	 */
	@Override
	public CellFormatEnum getCellFormat() {
		return CellFormatEnum.CURRENCY_TWO_DECIMAL_RED;
	}
	
	public CurrencyRowCell add(BigDecimal augend) {
		return (CurrencyRowCell)add(augend != null ? augend.doubleValue() : 0d);
	}

	public CurrencyRowCell subtract(BigDecimal subtrahend) {
		return (CurrencyRowCell)subtract(subtrahend != null ? subtrahend.doubleValue() : 0d );
	}
}
