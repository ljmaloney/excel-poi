package com.ljm.excel;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

public interface DataRowCell<T> {
	
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

	public T getCellValue();

	public HorizontalAlignment getAlign();

	public CellType getType();

	public Font getCellFont();

	public CellFormatEnum getCellFormat();
}
