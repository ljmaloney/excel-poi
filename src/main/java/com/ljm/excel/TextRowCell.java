package com.ljm.excel;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

public class TextRowCell extends AbstractRowCell<String> {

	public TextRowCell(String value) {
		setCellValue(value);
		setCellFont(null, null);
	}

	public HorizontalAlignment getAlign() {
		return HorizontalAlignment.LEFT;
	}

	public CellType getType() {
		return CellType.STRING;
	}
}
