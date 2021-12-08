import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class datadriven {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		FileInputStream fis = new FileInputStream("C:\\Users\\lenovo\\Documents\\testExcel\\DataDrivenExcel.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
	
		
	}

}
