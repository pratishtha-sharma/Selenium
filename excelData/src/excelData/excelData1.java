package excelData;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class excelData1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		File src = new File("C:\\Users\\lenovo\\Documents\\testExcel\\testExcel.xls");

		FileInputStream fis = new FileInputStream(src);
		
		//workbook object
		HSSFWorkbook wb = new HSSFWorkbook(fis);
		//sheet object
		HSSFSheet sheet = wb.getSheetAt(0);
		
		int rowcount = sheet.getLastRowNum()+1;
		
		for(int i=1; i<rowcount; i++)
		{
			String data0 = sheet.getRow(i).getCell(0).getStringCellValue();
			System.out.println("Username from row"+i+" is "+data0);
			
			double value = sheet.getRow(i).getCell(1).getNumericCellValue();
			int data = (int)value;   
			String data1 = Integer.toString(data);
			System.out.println("Password from row"+i+" is "+data1);
			
			System.out.println("*************************************");
		}
		
		wb.close();
	}

}
