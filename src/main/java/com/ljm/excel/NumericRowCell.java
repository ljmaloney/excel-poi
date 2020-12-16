package com.ljm.excel;

import java.math.BigDecimal;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

public class NumericRowCell extends AbstractRowCell<Double> {

	public NumericRowCell(Double value) {
		setCellValue(value);
		setCellFont(null, null);
	}
	
	public NumericRowCell(Long longValue) {
		this(longValue != null ? longValue.doubleValue() : 0d);
	}

	@Override
	public HorizontalAlignment getAlign() {
		return HorizontalAlignment.RIGHT;
	}

	@Override
	public CellType getType() {
		return CellType.NUMERIC;
	}

	public NumericRowCell add(Double augend) {
		BigDecimal oldValue = BigDecimal.valueOf(getCellValue());
		BigDecimal newValue = oldValue.add(augend != null ? BigDecimal.valueOf(augend) : BigDecimal.valueOf(0d));
		setCellValue(newValue.doubleValue());
		return this;
	}
	
	public NumericRowCell subtract(Long subtrahend) {
		return subtract(subtrahend != null ? subtrahend.doubleValue() : 0d);
	}

	public NumericRowCell subtract(Double subtrahend) {
		BigDecimal oldValue = BigDecimal.valueOf(getCellValue());
		BigDecimal newValue = oldValue.subtract(subtrahend != null ? BigDecimal.valueOf(subtrahend) : BigDecimal.valueOf(0d));
		setCellValue(newValue.doubleValue());
		return this;
	}
}
