package Automation.EPR;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class baseClass {
	
	Properties prop;
	WebDriver driver;
	
	public WebDriver openBrowser() throws IOException {
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Automation\\EPR\\values.properties");
		prop.load(fis);
		
		String browserName = prop.getProperty("browser");
		
		if(browserName.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", "F:\\Automation work\\chromedriver_win32 (1)\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
		}
		else if(browserName.contains("firefox")) {
			System.setProperty("webdriver.gecko.driver", "F:\\Automation work\\geckodriver-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		return driver;
		
	}

}
