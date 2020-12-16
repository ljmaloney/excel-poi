package com.ljm.excel;

import static org.junit.Assert.assertEquals;
import java.math.BigDecimal;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import com.ljm.excel.CurrencyRowCell;

public class CurrencyRowCellTest {

	@Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void testAdd_Null() {
		CurrencyRowCell rowCell = new CurrencyRowCell(BigDecimal.valueOf(99.03));
		BigDecimal bd = null;
		
		CurrencyRowCell newCell = rowCell.add(bd);
		assertEquals(rowCell.getCellValue(),newCell.getCellValue());
	}
	@Test
	public void testAdd_Zero() {
		CurrencyRowCell rowCell = new CurrencyRowCell(BigDecimal.valueOf(99.03));
		BigDecimal bd = BigDecimal.valueOf(0.00);
		
		CurrencyRowCell newCell = rowCell.add(bd);
		assertEquals(rowCell.getCellValue(),newCell.getCellValue());
	}
	@Test
	public void testAdd_Success() {
		CurrencyRowCell rowCell = new CurrencyRowCell(BigDecimal.valueOf(99.03));
		BigDecimal bd = BigDecimal.valueOf(0.97);
		
		CurrencyRowCell newCell = rowCell.add(bd);
		assertEquals(Double.valueOf(100.00),newCell.getCellValue());
	}
	
	@Test
	public void testSubtract_Null() {
		CurrencyRowCell rowCell = new CurrencyRowCell(BigDecimal.valueOf(99.03));
		BigDecimal bd = null;
		
		CurrencyRowCell newCell = rowCell.subtract(bd);
		assertEquals(rowCell.getCellValue(),newCell.getCellValue());
	}
	@Test
	public void testSubtract_Zero() {
		CurrencyRowCell rowCell = new CurrencyRowCell(BigDecimal.valueOf(99.03));
		BigDecimal bd = BigDecimal.valueOf(0.00);
		
		CurrencyRowCell newCell = rowCell.subtract(bd);
		assertEquals(rowCell.getCellValue(),newCell.getCellValue());
	}
	@Test
	public void testSubtract_Success() {
		CurrencyRowCell rowCell = new CurrencyRowCell(BigDecimal.valueOf(100.00));
		BigDecimal bd = BigDecimal.valueOf(0.97);
		
		CurrencyRowCell newCell = rowCell.subtract(bd);
		assertEquals(Double.valueOf(99.03),newCell.getCellValue());
	}
}
