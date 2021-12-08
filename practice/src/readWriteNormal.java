import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import XLReaderUtility.Xls_Reader;

public class readWriteNormal {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "F:\\Automation work\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://reg.ebay.in/reg/PartialReg?siteid=203&co_partnerId=0&UsingSSL=1&rv4=1&signInUrl=https%3A%2F%2Fwww.ebay.in%2Fsignin%3Fsgn%3Dreg%26siteid%3D203%26co_partnerId%3D0%26UsingSSL%3D1%26rv4%3D1");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		Xls_Reader reader = new Xls_Reader(System.getProperty("user.dir")+"\\testData.xlsx");
		int rowcount = reader.getRowCount("RegisterData");
		
		//1- get data from excel
		//2- store it in variable or parameterize it.
		//3- lastly enter the data.
		
		//store the data taken from excel. Parameterize the data (row starts from 1)
		for(int rowNum=2; rowNum<rowcount; rowNum++) {
			
			String firstName = reader.getCellData("RegisterData", "firstName", rowNum);
			String lastName = reader.getCellData("RegisterData", "lastName", rowNum);
			String emailAddress = reader.getCellData("RegisterData", "emailAddress", rowNum);
			String password = reader.getCellData("RegisterData", "password", rowNum);
			
			Thread.sleep(1000);
			
			//enter data
			driver.findElement(By.xpath("//input[@id='firstname']")).clear();
			driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys(firstName);
			
			driver.findElement(By.xpath("//input[@id='lastname']")).clear();
			driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys(lastName);
			
			driver.findElement(By.xpath("//input[@id='email']")).clear();
			driver.findElement(By.xpath("//input[@id='email']")).sendKeys(emailAddress);
			
			driver.findElement(By.xpath("//input[@id='PASSWORD']")).clear();
			driver.findElement(By.xpath("//input[@id='PASSWORD']")).sendKeys(password);
			
			
			Thread.sleep(3000);
			
			
		}
		
		driver.quit();
	}

}
