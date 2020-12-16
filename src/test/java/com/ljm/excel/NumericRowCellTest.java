package com.ljm.excel;

import static org.junit.Assert.assertEquals;
import java.math.BigDecimal;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import com.ljm.excel.NumericRowCell;

public class NumericRowCellTest {
	
	@Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void testAdd_NullValue() {
		NumericRowCell cell = new NumericRowCell(100.03);
		NumericRowCell newCell = cell.add(null);
		assertEquals(cell.getCellValue(),newCell.getCellValue());
	}
	@Test
	public void testAdd_Zero() {
		NumericRowCell cell = new NumericRowCell(100.03);
		NumericRowCell newCell = cell.add(0.00);
		assertEquals(cell.getCellValue(),newCell.getCellValue());
	}
	@Test
	public void testAdd_Success(){
		NumericRowCell cell = new NumericRowCell(100.03);
		NumericRowCell newCell = cell.add(0.97);
		assertEquals(Double.valueOf(BigDecimal.valueOf(101.00).doubleValue()),Double.valueOf(newCell.getCellValue().doubleValue()));
	}
	
	@Test
	public void testSubtract_NullValue() {
		NumericRowCell cell = new NumericRowCell(100.03);
		Double d = null;
		NumericRowCell newCell = cell.subtract(d);
		assertEquals(cell.getCellValue(),newCell.getCellValue());
	}
	@Test
	public void testSubtractZero() {
		NumericRowCell cell = new NumericRowCell(100.03);
		Double d = 0d;
		
		NumericRowCell newCell = cell.subtract(d);
		assertEquals(cell.getCellValue(),newCell.getCellValue());
	}
	@Test
	public void testSubtract_Success(){
		NumericRowCell cell = new NumericRowCell(100.00);
		Double d = .97d;
		
		NumericRowCell newCell = cell.subtract(d);
		assertEquals(Double.valueOf(BigDecimal.valueOf(99.03).doubleValue()),Double.valueOf(newCell.getCellValue().doubleValue()));
	}
}
