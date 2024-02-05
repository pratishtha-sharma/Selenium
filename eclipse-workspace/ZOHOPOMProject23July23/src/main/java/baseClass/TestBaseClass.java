package baseClass;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import Listeners.Listeners;



public class TestBaseClass {
	

	public String browser;
//	public WebDriver driver;
	public EventFiringWebDriver driver;
	public Properties prop;
	
	
	public WebDriver launchBrowser() throws IOException {
		
		prop = new Properties();
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\baseClass\\globalProp.properties");
		
		prop.load(fis);
		
		String browserName = prop.getProperty("browser");  //provide this when using eclipse
		
		if(browserName.contains("chrome")) //can not use == as it is used for reference comparision pointing to same address while .equals() is used for object comparision
		{
			System.setProperty("webdriver.chrome.driver", "F:\\Automation work\\chromedriver_win32 (1)\\chromedriver.exe");
			System.setProperty("java.net.preferIPv4Stack" , "true"); // this is to avoid Unreachable Browser Exception
			//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
//			ChromeOptions opt = new ChromeOptions();
//			if(browserName.contains("headless"))
//			{
//				opt.addArguments("headless");
//			}
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("--disable-notifications"); 
			driver = new EventFiringWebDriver(new ChromeDriver(options));
			driver.register(new Listeners());
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "F:\\Automation work\\geckodriver-v0.26.0-win64\\geckodriver.exe");
			//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\geckodriver.exe");
			driver = new EventFiringWebDriver(new FirefoxDriver());
			//setDriver(new FirefoxDriver());   //in case when we use driver variable defined as private here
		}
		else if(browserName.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver", "F:\\Automation work\\edgedriver_win64\\msedgedriver.exe");
			driver = new EventFiringWebDriver(new EdgeDriver());
		}
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
		
	}
	

}
