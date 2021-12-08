package excelData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class excelData {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		File src = new File("C:\\Users\\lenovo\\Documents\\testExcel\\testExcel.xls");

		FileInputStream fis = new FileInputStream(src);
		
		//workbook object
		HSSFWorkbook wb = new HSSFWorkbook(fis);
		//sheet object
		HSSFSheet sheet = wb.getSheetAt(0);
		
		//get data
		String data0 = sheet.getRow(1).getCell(0).getStringCellValue();
		double value = sheet.getRow(1).getCell(1).getNumericCellValue();
		int data1 = (int)value;   
		
		System.out.println(data0);
		System.out.println(data1);
		
		wb.close();
		
	}

}
