package com.ljm.excel;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFFont;

public abstract class AbstractRowCell<T> implements DataRowCell<T> {
	private T cellValue;
	private Font cellFont;
	
	private static final int DEFAULT_FONT_SIZE = 11;
	private static final String DEFAULT_FONT_FACE = ExcelFont.ARIAL.getName();
	
	public T getCellValue() {
		return cellValue;
	}

	public void setCellValue(T cellValue) {
		this.cellValue = cellValue;
	}

	public Font getCellFont() {
		return cellFont;
	}

	public void setCellFont(Font cellFont) {
		this.cellFont = cellFont;
	}

	public CellFormatEnum getCellFormat() {
		return CellFormatEnum.GENERAL;
	}

	public void setCellFont(String fontFace, Integer fontSize) {
		cellFont = new XSSFFont();
		cellFont.setFontName(StringUtils.isBlank(fontFace) ? DEFAULT_FONT_FACE : fontFace);
		cellFont.setFontHeightInPoints(fontSize != null ? fontSize.shortValue() : (short) DEFAULT_FONT_SIZE);
		cellFont.setColor(Font.COLOR_NORMAL);
	}
}
