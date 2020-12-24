package com.ljm.excel;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

/**
 * Interface defining methods required to generate a cell on an excel spreadsheet. 
 * 
 * @author luthermaloney
 *
 * @param <T>
 */
public interface DataRowCell<T> {
	/**
	 * Enumeration defining the available fonts
	 * @author luthermaloney
	 *
	 */
	public enum ExcelFont{
		
		ARIAL("Arial"),COURIER("Courier");
		private String fontName;
		private ExcelFont(String faceName) {
			this.fontName = faceName;
		}
		public String getName() {
			return fontName;
		}
	}
	/**
	 * Returns the value of a given cell
	 * @return
	 */
	public T getCellValue();
	/**
	 * Returns the horizontal alignment of the cell
	 * @return
	 */
	public HorizontalAlignment getAlign();
	/**
	 * Returns the type of cell
	 * @return
	 */
	public CellType getType();
	/**
	 * Returns the font used for the cell
	 * @return
	 */
	public Font getCellFont();
	/**
	 * Returns the selected format for the data displayed in the cell
	 * @return
	 */
	public CellFormatEnum getCellFormat();
}
