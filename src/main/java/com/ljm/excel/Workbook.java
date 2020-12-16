package com.ljm.excel;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.List;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Class encapsulating functionality to create spreadsheet reports.
 * 
 * @author lmaloney
 *
 */
public class Workbook {

	private XSSFWorkbook xssfWorkbook = null;
	private Sheet sheet = null;

	/**
	 * Create an instance of using the specified sheet name and default column width
	 * @param name
	 * @param defaultColumnWidth
	 */
	public Workbook(String name, Integer defaultColumnWidth) {
		xssfWorkbook = new XSSFWorkbook();
		sheet = xssfWorkbook.createSheet(name);
		sheet.setDefaultColumnWidth(defaultColumnWidth);
	}

	/**
	 * Returns the underlying Workbook instance
	 * @return
	 */
	public XSSFWorkbook getXSSFWorkbook() {
		return xssfWorkbook;
	}

	/**
	 * Calls the underlying workbook instance to save the workbook to an outputstream
	 * @param stream
	 * @throws IOException
	 */
	public final void write(OutputStream stream) throws IOException {
		xssfWorkbook.write(stream);
	}

	/**
	 * Sets requested column width
	 * @param columnIndex
	 * @param size
	 */
	public void setColumnWidth(Integer columnIndex, Integer size) {
		sheet.setColumnWidth(columnIndex, size * 256);
	}

	/**
	 * Create/Add column headers
	 * @param columnHeaders
	 * @param rowNumber
	 * @param lastRow
	 * @return
	 */
	public Row createColumnHeaderRow(String[] columnHeaders, int rowNumber, boolean lastRow) {
		Font headerfont = xssfWorkbook.createFont();
		headerfont.setFontName(DataRowCell.ExcelFont.ARIAL.getName());
		headerfont.setBold(true);
		headerfont.setFontHeightInPoints((short) 12);

		CellStyle headerstyle = xssfWorkbook.createCellStyle();
		if (lastRow) {
			headerstyle.setBorderBottom(BorderStyle.THIN);
		}
		headerstyle.setFont(headerfont);
		headerstyle.setAlignment(HorizontalAlignment.CENTER);

		Row headerRow = sheet.createRow(rowNumber);
		for (int i = 0; i < columnHeaders.length; i++) {
			Cell headerCell = headerRow.createCell(i, CellType.STRING);
			headerCell.setCellStyle(headerstyle);
			headerCell.setCellValue(columnHeaders[i]);
		}
		return headerRow;
	}

	/**
	 * Add/create a title row for the spreadsheet
	 * @param rowNum
	 * @param cellValue
	 * @return
	 */
	public Row addTitleRow(int rowNum, String cellValue) {
		Font titleFont = xssfWorkbook.createFont();
		titleFont.setFontName("Arial");
		titleFont.setBold(true);
		titleFont.setFontHeightInPoints((short) 14);

		Row row = sheet.createRow(rowNum);
		Cell cell = row.createCell(0, CellType.STRING);
		cell.setCellStyle(xssfWorkbook.createCellStyle());
		cell.getCellStyle().setFont(titleFont);
		cell.getCellStyle().setAlignment(HorizontalAlignment.LEFT);
		cell.setCellValue(cellValue);
		return row;
	}

	/**
	 * Add a data row to the spreadsheet
	 * @param currentRow
	 * @param dataCells
	 * @return
	 */
	public Row addReportRow(int currentRow, List<DataRowCell<?>> dataCells) {
		Row row = sheet.createRow(currentRow);
		int columnIndex = 0;
		for (DataRowCell<?> dataCell : dataCells) {
			createCell(row, columnIndex, dataCell);
			columnIndex++;
		}
		return row;
	}

	/**
	 * Add a footer row to the spreadsheet
	 * @param currentRow
	 * @param indentColumn
	 * @param footerCells
	 * @return
	 */
	public Row addFooterRow(int currentRow, int indentColumn, List<FooterDataCell> footerCells) {
		int columnIndex = 0;
		Row footerRow = sheet.createRow(currentRow);
		for (FooterDataCell footerCell : footerCells) {
			int cellIndex = indentColumn + columnIndex;
			Cell cell = createCell(footerRow, cellIndex, footerCell);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			columnIndex++;
		}
		return footerRow;
	}

	// helper method to create a cell using the specified row and index
	private Cell createCell(Row row, int columnIndex, DataRowCell<?> dataCell) {
		Font cellFont = xssfWorkbook.createFont();
		cellFont.setFontName(dataCell.getCellFont().getFontName());
		cellFont.setFontHeightInPoints((short) dataCell.getCellFont().getFontHeightInPoints());

		Cell cell = row.createCell(columnIndex, dataCell.getType());
		cell.setCellStyle(xssfWorkbook.createCellStyle());
		cell.getCellStyle().setAlignment(dataCell.getAlign());
		cell.getCellStyle().setFont(cellFont);
		cell.getCellStyle().setDataFormat((short) dataCell.getCellFormat().getFormatValue());
		Object cellValue = dataCell.getCellValue();
		if (cellValue instanceof Double) {
			cell.setCellValue((Double) cellValue);
		}
		else if (cellValue instanceof BigDecimal) {
			cell.setCellValue(((BigDecimal) cellValue).doubleValue());
		}
		else {
			cell.setCellValue(cellValue.toString());
		}
		return cell;
	}
}
