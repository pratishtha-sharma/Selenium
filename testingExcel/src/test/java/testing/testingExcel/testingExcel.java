package testing.testingExcel;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class testingExcel {
	

	//we will first get the first row, and find the column number having text "TestCase" using the cell iterator
	//We will then use that column number to get the "History" Column
	 
	public ArrayList<String> getDataD(String testcaseName) throws Exception {
	 
	 
	FileInputStream fis = new FileInputStream("C:\\Users\\lenovo\\Documents\\testExcel\\DataDrivenExcel.xlsx");
	 
	ArrayList<String> a = new ArrayList<String>();
	 
	XSSFWorkbook wb = new XSSFWorkbook(fis);
	int sheetnum = wb.getNumberOfSheets();
	System.out.println("Number of sheets in excel are: "+ sheetnum);
	 
	for(int i=0; i<sheetnum; i++)
	{
	if(wb.getSheetName(i).equalsIgnoreCase("testData"))
	{
	XSSFSheet sheet = wb.getSheetAt(i);
	//iterate through the rows in the sheet.
	Iterator<Row> rows = sheet.iterator();
	Row firstrow = rows.next(); // this is the first row in the sheet
	//iterate through the cell of this first row.
	Iterator<Cell> cell = firstrow.cellIterator();
	 
	int k =0;
	int column=0;
	while(cell.hasNext())
	{
	Cell c = cell.next();
	if(c.getStringCellValue().equalsIgnoreCase("TestCase"))
	{
	column=k;
	}
	  k++;
	}
	System.out.println("The column in which the required testcase present is: "+column);
	 
	//once we find the test "TestCase" we will then iterate through the rows to find the testcase "History"
	// we already have the rows present in the sheet, we just need to iterate through them
	while(rows.hasNext())
	{
	Row r = rows.next(); 
	// if the required test case is not present in this row the if loop will not be performed and we will go on the next row.
	//if we have found the required testcase then we will get the value of all the cell for that row.
	//get all the cell value for that testcase
	if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testcaseName)) 
	{
	    Iterator<Cell> rowcell = r.cellIterator();
	    while(rowcell.hasNext())
	    {
	    a.add(rowcell.next().getStringCellValue());
	    }
	}
	}
	 
	}
	}
	 
	wb.close();
	return a;
	 
	 
	}

}
