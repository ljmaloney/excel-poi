package com.ljm.excel;

import static org.junit.Assert.assertEquals;
import java.math.BigDecimal;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import com.ljm.excel.FooterDataCell;

public class FooterDataCellTest {

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testAdd_NullValue() {
		FooterDataCell cell = new FooterDataCell(99.03);
		BigDecimal bd = null;

		FooterDataCell newCell = cell.add(bd);
		assertEquals(cell.getCellValue(), newCell.getCellValue());
	}

	@Test
	public void testAdd_NullLong() {
		FooterDataCell cell = new FooterDataCell(99.03);
		Long nullong = null;

		FooterDataCell newCell = cell.add(nullong);
		assertEquals(cell.getCellValue(), newCell.getCellValue());
	}

	@Test
	public void testAdd_Zero() {

		FooterDataCell cell = new FooterDataCell(99.03);
		BigDecimal bd = BigDecimal.valueOf(0.00);

		FooterDataCell newCell = cell.add(bd);
		assertEquals(cell.getCellValue(), newCell.getCellValue());

	}

	@Test
	public void testAdd_ZeroLong() {

		FooterDataCell cell = new FooterDataCell(99.03);
		Long longZero = Long.valueOf(0l);

		FooterDataCell newCell = cell.add(longZero);
		assertEquals(cell.getCellValue(), newCell.getCellValue());

	}

	@Test
	public void testAdd_Success() {
		FooterDataCell cell = new FooterDataCell(99.03);
		BigDecimal bd = BigDecimal.valueOf(0.97);

		FooterDataCell newCell = cell.add(bd);
		assertEquals(BigDecimal.valueOf(100.00).setScale(2), newCell.getCellValue());
	}
	
	@Test
	public void testSubtract_NullValue() {
		FooterDataCell cell = new FooterDataCell(99.03);
		BigDecimal bd = null;

		FooterDataCell newCell = cell.subtract(bd);
		assertEquals(cell.getCellValue(), newCell.getCellValue());
	}

	@Test
	public void testSubtract_NullLong() {
		FooterDataCell cell = new FooterDataCell(99.03);
		Long nullong = null;

		FooterDataCell newCell = cell.subtract(nullong);
		assertEquals(cell.getCellValue(), newCell.getCellValue());
	}
	
	@Test
	public void testSubtract_Zero() {

		FooterDataCell cell = new FooterDataCell(99.03);
		BigDecimal bd = BigDecimal.valueOf(0.00);

		FooterDataCell newCell = cell.subtract(bd);
		assertEquals(cell.getCellValue(), newCell.getCellValue());

	}

	@Test
	public void testSubtract_ZeroLong() {

		FooterDataCell cell = new FooterDataCell(99.03);
		Long longZero = Long.valueOf(0l);

		FooterDataCell newCell = cell.subtract(longZero);
		assertEquals(cell.getCellValue(), newCell.getCellValue());

	}
}
