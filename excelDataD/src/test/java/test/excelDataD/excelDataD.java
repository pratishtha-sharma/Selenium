package test.excelDataD;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelDataD {

	@SuppressWarnings("deprecation")
	public ArrayList<String> getData(String testCaseName) throws Exception {
		// TODO Auto-generated method stub

		FileInputStream fis =  new FileInputStream("C:\\Users\\lenovo\\Documents\\testExcel\\DataDrivenExcel.xlsx");

		ArrayList<String> a = new ArrayList<String>();
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		int sheets =  wb.getNumberOfSheets();
		for(int i=0; i<sheets; i++)
		{
			if(wb.getSheetName(i).equalsIgnoreCase("testData"))
			{
			   
			   XSSFSheet sheet = wb.getSheetAt(i);
			   //identify the column by scanning the rows
			   Iterator<Row> rows = sheet.iterator();
			   Row rownum = rows.next(); //iteration for the first row only
			   Iterator<Cell> cell = rownum.cellIterator(); //iterated through the first row's cell to search for "TestCase"
			   
			   int k=0;
			   int column=0;
			   while(cell.hasNext()) //iteration of all the cells of first row.
			   {
				   Cell value = cell.next();
				   if(value.getStringCellValue().equalsIgnoreCase("TestCase"))
				   {
					  column=k; 
				   }
			     k++;
			   }
			   System.out.println("The column in which the required test case is present is " + column);
			   
			   //once column is identified then search through entire TestCase column to search Purchase
			   while(rows.hasNext())
			   {
				   Row r=rows.next();  //first row
				   if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testCaseName))
				   {
					   //after we have grab the Purchase testcase we need to get all the data of that row
					   Iterator<Cell> c = r.cellIterator();
					   while(c.hasNext())
					   {
						   //a.add(c.next().getStringCellValue());
						   Cell cv= c.next();
						   if(cv.getCellTypeEnum()==CellType.STRING)
						   {

						   a.add(cv.getStringCellValue());
						   }
						   else{

						   a.add(NumberToTextConverter.toText(cv.getNumericCellValue()));
						   
					      }
				       }
			   }
			   
			}
		}
	}
		wb.close();
		return a;
	}
}
