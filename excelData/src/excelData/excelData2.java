package excelData;

import Library.ExcelDataConfig;

public class excelData2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ExcelDataConfig excel = new ExcelDataConfig("C:\\Users\\lenovo\\Documents\\testExcel\\testExcel.xls");
		
		System.out.println(excel.getData(0, 1, 0));

	}

}
