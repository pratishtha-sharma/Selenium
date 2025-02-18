package Api.utilities;
import java.io.IOException;

import org.testng.annotations.DataProvider;

public class dataProviders {
	


	    @DataProvider(name="Data")
	    public String[][] getAllData() throws IOException { // to get all the data from excel sheet
	        String path = System.getProperty("user.dir")+"//testData//RestAssuredUserDataExcelEx.xlsx";
	        XLUtility xl = new XLUtility(path); //XLUtility is being called using this constructor

	        int rownum = xl.getRowCount("Worksheet");
	        int colcount = xl.getCellCount("Worksheet",1);

	        String apidata[][] = new String[rownum][colcount];

	        for(int i=1; i<=rownum; i++) {
	            for(int j=0; j<colcount; j++) {
	                apidata[i-1][j] = xl.getCellData("Worksheet", i, j);
	            }
	        }
	        return apidata;
	    }

	    @DataProvider(name="UserNames")
	    public String[] getUserNames() throws IOException { // get only usernames from excel sheet
	        String path = System.getProperty("user.dir")+"//testData//RestAssuredUserDataExcelEx.xlsx";
	        XLUtility xl = new XLUtility(path);

	        int rownum = xl.getRowCount("Worksheet");

	        String apidata[] = new String[rownum];

	        for(int i=1; i<=rownum; i++) {
	            apidata[i-1] = xl.getCellData("Worksheet", i, 1);
	        }
	        return apidata;
	    }


}
