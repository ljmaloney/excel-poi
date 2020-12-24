package com.ljm.excel;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
/**
 * Class used to generate/display text data in a cell
 * 
 * @author luthermaloney
 *
 */
public class TextRowCell extends AbstractRowCell<String> {

	public TextRowCell(String value) {
		setCellValue(value);
		setCellFont(null, null);
	}
	/**
	 * Returns the default horizontal alignment for a text cell
	 * @return HorizontalAlignment.LEFT
	 */
	public HorizontalAlignment getAlign() {
		return HorizontalAlignment.LEFT;
	}
	/**
	 * Returns the <code>CellType.STRING</code> for text cells
	 */
	public CellType getType() {
		return CellType.STRING;
	}
}
