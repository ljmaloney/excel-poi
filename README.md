# excel-poi

Framework for the creation of Excel spreadsheets utilizing the Apache POI framework (https://poi.apache.org/).  

The resulting spreadsheet can include formatted header rows, data rows, and a total or summary row. The data rows can also be formatted
using standard formatting conventions for datatype and alignment. 

#usage

1. Create an instance of the Workbook class. 
2. Call the addTitleRow() method to add a title row to the spreadsheet
3. Call createColumnHeaderRow() to add as many column header rows as required. The column headers are centered in the cells by default. To generate an underline for the column headers, pass lastRow=true. 
4. Call addReportRow() to add each row to the report, each row is added as a List of instances of DataRowCells
5. Call addFooterRow() to add a footer row to the spreadsheet. 
6. Call the write() method to save the spreadsheet to an OutputStream
