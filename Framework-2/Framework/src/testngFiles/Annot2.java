package testngFiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Annot2 {
	
	public WebDriver driver = null;

	
	@BeforeSuite
	public void installsoftware()
	{
		System.out.println("I am the First");
	}
	
	@Test
	public void Login() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("F:\\Automation work\\eclipse-workspace\\Framework-2\\Framework\\src\\testngFiles\\dataDriven.properties");
		prop.load(fis);
		
		//System.out.println(prop.getProperty("username"));
		
		if(prop.getProperty("browser").equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "F:\\Automation work\\chromedriver_win32 (1)\\chromedriver.exe");
		    driver = new ChromeDriver();
		}
		else
		{
			System.setProperty("webdriver.gecko.driver", "F:\\Automation work\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		    driver = new FirefoxDriver();
		}
		
		driver.get(prop.getProperty("url"));
		
		
		System.out.println("I am the Test");
	}
	@AfterSuite
	public void deinstallsoftware()
	{
		System.out.println("I am the Last");
	}
	
}
