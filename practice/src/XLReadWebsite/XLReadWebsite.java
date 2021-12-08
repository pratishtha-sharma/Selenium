package XLReadWebsite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import XLTestUtility.TestUtility;

public class XLReadWebsite {
	
	public WebDriver driver;
	
	@BeforeTest
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "F:\\Automation work\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://reg.ebay.in/reg/PartialReg?siteid=203&co_partnerId=0&UsingSSL=1&rv4=1&signInUrl=https%3A%2F%2Fwww.ebay.in%2Fsignin%3Fsgn%3Dreg%26siteid%3D203%26co_partnerId%3D0%26UsingSSL%3D1%26rv4%3D1");
		
	}
	
	@Test(dataProvider="getTestData")
	public void registerPage(String firstName, String lastName, String emailAddress, String password)
	{
		//enter data
		driver.findElement(By.xpath("//input[@id='firstname']")).clear();
		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys(firstName);
		
		driver.findElement(By.xpath("//input[@id='lastname']")).clear();
		driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys(lastName);
		
		driver.findElement(By.xpath("//input[@id='email']")).clear();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(emailAddress);
		
		driver.findElement(By.xpath("//input[@id='PASSWORD']")).clear();
		driver.findElement(By.xpath("//input[@id='PASSWORD']")).sendKeys(password);
		
	}
	
	@DataProvider
	public Iterator<Object[]> getTestData()
	//public int getTestData()
	{
		//Object[] testData = TestUtility.getDataFromXL();
		ArrayList<Object[]> testData = TestUtility.getDataFromXL();
		//return (int) testData.length; //iterating through the data stored in the arraylist in sequence as the data in arraylist is stored in sequence
        return testData.iterator();	
	}
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}

}
