package com.ljm.excel;

public enum CellFormatEnum {

	// taken from the list at https://poi.apache.org/apidocs/dev/index.html?org/apache/poi/ss/usermodel/BuiltinFormats.html
	GENERAL(0, "General"),
	NUMBER_NO_DECIMAL(1, "0"),
	NUMBER_TWO_DECIMAL(2, "0.00"),
	NUMBER_COMMA(3, "#,##0"),
	NUMEBER_COMMA_TWO_DECIMAL(4, "#,##0.00"),
	CURRENCY_NO_DECIMAL(5, "$#,##0_);($#,##0)"),
	CURRENCY_NO_DECIMAL_RD(6, "$#,##0_);[Red]($#,##0)"),
	CURRENCY_TWO_DECIMAL(7, "$#,##0.00);($#,##0.00)\""),
	CURRENCY_TWO_DECIMAL_RED(8, "$#,##0.00_);[Red]($#,##0.00)"),
	PERCENT_NO_DECIMAL(9, "0%"),
	PERCENT_TWO_DECIMAL(Integer.parseInt("a", 16), "0.00%"),
	SIMPLE_DATE(Integer.parseInt("e", 16), "m/d/yy"),
	DATE_TIME(Integer.parseInt("16", 16), "m/d/yy h:mm");

	private final int format;
	private final String formatString;

	CellFormatEnum(int format, String formatString) {
		this.format = format;
		this.formatString = formatString;
	}

	public int getFormatValue() {
		return format;
	}

	public String getFormatString() {
		return formatString;
	}
}
