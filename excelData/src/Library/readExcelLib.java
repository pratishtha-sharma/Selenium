package Library;

import java.io.File;
import java.io.IOException;

//import org.apache.poi.EncryptedDocumentException;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.WorkbookFactory;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class readExcelLib {

	public static final String Firefox_Path = "C:\\Users\\lenovo\\Desktop\\firefox.exe"; //Location of firefox in system
	public static final String File_Path = "testExcel.xls"; //File path
	public static final String Sheet_Name = "Sheet1"; //sheet name
	public static final String Table_Name = "testData"; //table name
	public static final int Wait_Time = 30; //wait or delay time for the website to load completely.
	public static final String Base_Url = "http://www.demo.guru99.com/"; //base url of the website to be launched.
	
	// Expected output
    public static final String Expected_Title = "Guru99 Bank Manager HomePage";
    public static final String Expected_Error = "User or Password is not valid";
    
    //Now we will declare a method which will read data from excel and it will store data in an 2 dimensional array which we will use further.
    public static String[][] getExcelData(String xlPath, String sheetname, String tablename) throws Exception
    {
    	String[][] excelData = null;
		
    	Workbook w = Workbook.getWorkbook(new File(xlPath));
    	//Workbook w = WorkbookFactory.create(new File(xlPath)); //when using apache poi this is used
    	
    	Sheet sheet = w.getSheet(sheetname);
    	
    	int startRow, startCol, endRow, endCol, ci, cj;
    	
    	//find the cell position which contains the table
    	Cell tableStart = sheet.findCell(tablename);
    	//row position of table name that appears first.
    	startRow = tableStart.getRow();
    	//column position of table name that appears first
    	startCol = tableStart.getColumn();
    	
    	//find cell position of table name that appears at last
    	Cell tableEnd = sheet.findCell(tablename, startRow+1, startCol+1, 100, 64000, false);
    	//row position of table name that appears last
    	endRow = tableEnd.getRow();
    	//column position of table name that appears last
    	endCol = tableEnd.getColumn();
    
    	excelData = new String[endRow - startRow - 1] [endCol - startCol - 1];
    	ci=0;
    	
    	// Store all data in an array
    	for (int i = startRow + 1; i < endRow; i++, ci++) 
    	{      cj = 0;
    		for (int j = startCol + 1; j < endCol; j++, cj++) 
    		{
    		   //Get content of each cell and store to each array element.
    		   excelData[ci][cj] = sheet.getCell(j, i).getContents();
               //excelData[ci][cj] = sheet.getCell(i, j).getContents();
    		}
    	}

    			
    	return (excelData);
    }

	
	
}
