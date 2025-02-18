package Api.utilities;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtility {
	
    public FileInputStream fi;
    public FileOutputStream fo;
    public XSSFWorkbook workbook;
    public XSSFSheet sheet;
    public XSSFRow row;
    public XSSFCell cell;
    public CellStyle style;
    String path;

    // Constructor to initialize the Excel file path
    public ExcelUtility(String filePath) {
        this.path = filePath;
        try {
            fi = new FileInputStream(path);
            workbook = new XSSFWorkbook(fi);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to get cell data as String
    public String getCellData(int sheetIndex, int rowNum, int colNum) {
        sheet = workbook.getSheetAt(sheetIndex);
        row = sheet.getRow(rowNum);
        cell = row.getCell(colNum);
        return cellToString(cell);
    }

    // Convert cell data to String
    private String cellToString(XSSFCell cell) {
        Object value = null;
        switch (cell.getCellType()) {
            case STRING:
                value = cell.getStringCellValue();
                break;
            case NUMERIC:
                value = cell.getNumericCellValue();
                break;
            case BOOLEAN:
                value = cell.getBooleanCellValue();
                break;
            case FORMULA:
                value = cell.getCellFormula();
                break;
            default:
                value = "";
        }
        return value.toString();
    }

    // Method to get row count
    public int getRowCount(int sheetIndex) {
        sheet = workbook.getSheetAt(sheetIndex);
        return sheet.getPhysicalNumberOfRows();
    }

    // Method to get column count in a row
    public int getColumnCount(int sheetIndex, int rowIndex) {
        sheet = workbook.getSheetAt(sheetIndex);
        row = sheet.getRow(rowIndex);
        return row.getPhysicalNumberOfCells();
    }

    // Method to close the workbook
    public void closeWorkbook() {
        try {
            workbook.close();
            fi.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
