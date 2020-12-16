package com.ljm.excel;

import java.math.BigDecimal;

public class CurrencyRowCell extends NumericRowCell {

	public CurrencyRowCell(Double value) {
		super(value);
	}

	public CurrencyRowCell(BigDecimal decimal) {
		super(decimal != null ? decimal.doubleValue() : 0d);
	}
	
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
