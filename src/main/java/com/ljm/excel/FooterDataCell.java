package com.ljm.excel;

import java.math.BigDecimal;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
/**
 * Class representing a specify type of cell in the spreadsheet, a footer or total row
 * 
 * @author luthermaloney
 *
 */
public class FooterDataCell extends AbstractRowCell<BigDecimal> {
	private CellFormatEnum cellFormat = CellFormatEnum.GENERAL;
	/**
	 * Creates an instance of the footer cell with the specified <code>CellFormatEnum</code>
	 * @param format
	 */
	public FooterDataCell(CellFormatEnum format) {
		this(0d);
		cellFormat = (format == null ? CellFormatEnum.GENERAL : format);
	}

	public FooterDataCell(Double value) {
		setCellValue(BigDecimal.valueOf(value).setScale(2));
		setCellFont(null, null);
	}
	/**
	 * By default the footer cells return <code>HorizontalAlignment.RIGHT</code>
	 */
	@Override
	public HorizontalAlignment getAlign() {
		return HorizontalAlignment.RIGHT;
	}

	@Override
	public CellFormatEnum getCellFormat() {
		return cellFormat;
	}
	/**
	 * By default the footer cells return <code>CellType.NUMERIC</code>
	 */
	@Override
	public CellType getType() {
		return CellType.NUMERIC;
	}
	
	public FooterDataCell add(Long augend) {
		add(augend != null ? BigDecimal.valueOf(augend) : BigDecimal.valueOf(0l));
		return this;
	}
	/**
	 * Calculates the difference between all of the values in the argument list by taking the first
	 * value and subtracting all subsequent values. The difference is then added to the current value 
	 * of the cell. 
	 * @param values
	 * @return
	 */
	public FooterDataCell addDifference(Long... values) {
		BigDecimal difference = BigDecimal.valueOf((values[0] != null ? values[0] : 0l));
		for ( int i = 1; i < values.length; i++) {
			difference = difference.subtract(BigDecimal.valueOf(values[i] != null ? values[i] : 0l));
		}
		return add(difference);
	}

	public FooterDataCell subtract(Long subtrahend) {
		subtract(subtrahend != null ? BigDecimal.valueOf(subtrahend) : BigDecimal.valueOf(0l));
		return this;
	}

	public FooterDataCell add(BigDecimal augend) {
		setCellValue(getCellValue().add(augend != null ? augend : BigDecimal.valueOf(0d)));
		return this;
	}

	public FooterDataCell subtract(BigDecimal subtrahend) {
		setCellValue(getCellValue().subtract(subtrahend != null ? subtrahend : BigDecimal.valueOf(0d)));
		return this;
	}
	/**
	 * Calculates the difference between all of the values in the argument list by taking the first
	 * value and subtracting all subsequent values. The difference is then added to the current value 
	 * of the cell. 
	 * @param values
	 * @return
	 */
	public void addDifference(BigDecimal... values) {
		BigDecimal difference = values[0].add(BigDecimal.valueOf(0d));
		for ( int i = 1; i < values.length; i++) {
			difference = difference.subtract(values[i] != null ? values[i] : BigDecimal.valueOf(0d));
		}
		add(difference);
	}
}
