package com.ljm.excel;

import java.math.BigDecimal;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
/**
 * Class for the display of numeric data in a cell of an excel spreadsheet.
 * 
 * @author luthermaloney
 *
 */
public class NumericRowCell extends AbstractRowCell<Double> {

	public NumericRowCell(Double value) {
		setCellValue(value);
		setCellFont(null, null);
	}
	
	public NumericRowCell(Long longValue) {
		this(longValue != null ? longValue.doubleValue() : 0d);
	}
	/**
	 * Returns the default alignment for numeric data
	 * <code>HorizontalAlignment.RIGHT</code>
	 */
	@Override
	public HorizontalAlignment getAlign() {
		return HorizontalAlignment.RIGHT;
	}
	/**
	 * Returns the default cell type for the data
	 * <code>CellType.NUMERIC</code>
	 */
	@Override
	public CellType getType() {
		return CellType.NUMERIC;
	}
	/**
	 * Adds the value of the parameter to the value displayed by the cell
	 * @param augend
	 * @return
	 */
	public NumericRowCell add(Double augend) {
		BigDecimal oldValue = BigDecimal.valueOf(getCellValue());
		BigDecimal newValue = oldValue.add(augend != null ? BigDecimal.valueOf(augend) : BigDecimal.valueOf(0d));
		setCellValue(newValue.doubleValue());
		return this;
	}
	
	public NumericRowCell subtract(Long subtrahend) {
		return subtract(subtrahend != null ? subtrahend.doubleValue() : 0d);
	}
	/**
	 * Subtracts the value of the argument from the value displayed by the cell
	 * @param subtrahend
	 * @return
	 */
	public NumericRowCell subtract(Double subtrahend) {
		BigDecimal oldValue = BigDecimal.valueOf(getCellValue());
		BigDecimal newValue = oldValue.subtract(subtrahend != null ? BigDecimal.valueOf(subtrahend) : BigDecimal.valueOf(0d));
		setCellValue(newValue.doubleValue());
		return this;
	}
}
