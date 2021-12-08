package excelData;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxProfile;

import Library.readExcelLib;

public class readExcel {
	
	
	static WebDriver driver;
	public static String baseUrl;
	
	public static void firefoxSetUp()
	{
//		File pathToBinary = new File(readExcelLib.Firefox_Path);
//		FirefoxBinary fBinary = new FirefoxBinary(pathToBinary);
//		FirefoxProfile fProfile = new FirefoxProfile();
//		driver = new FirefoxDriver(fBinary , fProfile);
		System.setProperty("webdriver.gecko.driver", "F:\\Automation work\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		baseUrl = readExcelLib.Base_Url;
		driver.manage().timeouts()
			.implicitlyWait(readExcelLib.Wait_Time, TimeUnit.SECONDS);
		driver.get(baseUrl + "V4/");
		driver.manage().window().maximize();
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		//read data from excel file using getExcelData method from the readExcelLib
		String [][] testData = readExcelLib.getExcelData(readExcelLib.File_Path, readExcelLib.Sheet_Name, readExcelLib.Table_Name);
		
		String username, password;
		String actualTitle;
		String actualBoxtitle;
		
		//using the parameters stored in the file
		for(int i=0; i<testData.length; i++)
		{
			username = testData[i][0];
			password = testData[i][1];
			
			//Setup Firefox driver
			firefoxSetUp();
			
		    // Enter username
		    driver.findElement(By.name("uid")).clear();
		    driver.findElement(By.name("uid")).sendKeys(username);

		    // Enter Password
		    driver.findElement(By.name("password")).clear();
		    driver.findElement(By.name("password")).sendKeys(password);

		    // Click Login
		    driver.findElement(By.name("btnLogin")).click();
		    
		    /* Determine Pass Fail Status of the Script
	         * If login credentials are correct,  Alert(Pop up) is NOT present. An Exception is thrown and code in catch block is executed	
	         * If login credentials are invalid, Alert is present. Code in try block is executed 	    
	         */
		    
		    try
		    {
		    	Alert alert = driver.switchTo().alert();
		    	actualBoxtitle = alert.getText();
		    	alert.accept();
		    	if (actualBoxtitle.contains(readExcelLib.Expected_Error)) { // Compare Error Text with Expected Error Value
				    System.out.println("Test case SS[" + i + "]: Failed"); 
				}
		    }
		    catch(NoAlertPresentException Ex)
		    {
		    	actualTitle = driver.getTitle();
		    	if(actualTitle.contains(readExcelLib.Expected_Title)){
		    		System.out.println("Test case SS[" + i + "]: Passed");
		    	}
		    	
		    }
		    driver.close();
		}
		

	}

}
