package com.ljm.excel;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFFont;

/**
 * Abstract class providing default implementations of common methods. 
 * 
 * @author luthermaloney
 *
 * @param <T>
 */
public abstract class AbstractRowCell<T> implements DataRowCell<T> {
	private T cellValue;
	private Font cellFont;
	
	//define the default font size for the cell
	private static final int DEFAULT_FONT_SIZE = 11;
	//define the default font face for the cell
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
	/**
	 * Returns the default format for the data displayed in the cell
	 * @return
	 */
	public CellFormatEnum getCellFormat() {
		return CellFormatEnum.GENERAL;
	}
	/**
	 * Sets the font used to render the cell
	 * @param fontFace
	 * @param fontSize
	 */
	public void setCellFont(String fontFace, Integer fontSize) {
		cellFont = new XSSFFont();
		cellFont.setFontName(StringUtils.isBlank(fontFace) ? DEFAULT_FONT_FACE : fontFace);
		cellFont.setFontHeightInPoints(fontSize != null ? fontSize.shortValue() : (short) DEFAULT_FONT_SIZE);
		cellFont.setColor(Font.COLOR_NORMAL);
	}
}
