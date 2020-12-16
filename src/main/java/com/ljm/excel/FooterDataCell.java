package com.ljm.excel;

import java.math.BigDecimal;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

public class FooterDataCell extends AbstractRowCell<BigDecimal> {
	private CellFormatEnum cellFormat = CellFormatEnum.GENERAL;

	public FooterDataCell(CellFormatEnum format) {
		this(0d);
		cellFormat = (format == null ? CellFormatEnum.GENERAL : format);
	}

	public FooterDataCell(Double value) {
		setCellValue(BigDecimal.valueOf(value).setScale(2));
		setCellFont(null, null);
	}

	@Override
	public HorizontalAlignment getAlign() {
		return HorizontalAlignment.RIGHT;
	}

	@Override
	public CellFormatEnum getCellFormat() {
		return cellFormat;
	}

	@Override
	public CellType getType() {
		return CellType.NUMERIC;
	}
	
	public FooterDataCell add(Long augend) {
		add(augend != null ? BigDecimal.valueOf(augend) : BigDecimal.valueOf(0l));
		return this;
	}
	
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

	public void addDifference(BigDecimal... values) {
		BigDecimal difference = values[0].add(BigDecimal.valueOf(0d));
		for ( int i = 1; i < values.length; i++) {
			difference = difference.subtract(values[i] != null ? values[i] : BigDecimal.valueOf(0d));
		}
		add(difference);
	}
}
