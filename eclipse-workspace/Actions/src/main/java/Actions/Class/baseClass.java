package Actions.Class;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class baseClass {
	
	
	public WebDriver driver;
	public Properties prop;

	public WebDriver openbrowserDriver() throws IOException {
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\\\Actions\\Class\\values.properties");
		
		prop.load(fis);
		
		
		//-D is treated as the system properties
		//mvn test -Dbrowser=chrome //to pass the browser from maven when we run test from there.
		//mvn test -Dbrowser="$browser" here this is used in jenkins when we provide goals in build environment, it will select the parameter that we select from dropwdown
		//provide the dropdown list having browsername in "This project is parameterized -> Choice Parameter" $ indicates that browser is jenkins variable provided in parameter.
				
		//String browsername = System.getProperty("browser"); //When we write this it will go to the above maven command to check the property name when we are using jenkins using maven
		String browsername = prop.getProperty("browser");  //provide this when using eclipse
		
		
		if(browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\eclipse\\chromedriver_win32\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
		}
		else if(browsername.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "F:\\Automation work\\geckodriver-v0.30.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		return driver;
	}
	
	public String getScreenshotPath(String failedCase, WebDriver driver) throws IOException {
		TakesScreenshot ss = (TakesScreenshot)driver;
		File src = ss.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir")+"\\reports\\"+failedCase+".png";
		FileUtils.copyFile(src, new File(destination));
		
		return destination;
	}
}
