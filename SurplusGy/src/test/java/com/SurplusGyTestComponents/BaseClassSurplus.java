package com.SurplusGyTestComponents;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.SurplusGy.PageObjects.loginPageObject;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClassSurplus {

	public WebDriver driver;
	public loginPageObject lp;

	public WebDriver initializeDriver() throws IOException

	{
		// properties class

		 Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "//src//test//resources//GlobalData.properties");
		prop.load(fis);
		
		//String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") :prop.getProperty("browser");
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			
			//WebDriverManager.chromedriver().setup();
//			ChromeOptions options = new ChromeOptions();
//			options.addArguments("headless");		
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			//driver.manage().window().setSize(new Dimension(1440,900));//full screen
			
			driver.get("https://ecommercemarketplace.24livehost.com/");

		} else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get("https://ecommercemarketplace.24livehost.com/");
			// Firefox
		} else if (browserName.equalsIgnoreCase("edge")) {
			// Edge
			//System.setProperty("webdriver.edge.driver", (System.getProperty("user.dir")+"//exe_files//msedgedriver.exe"));
			System.setProperty("webdriver.edge.driver", "D://eclipse//browser_webdriver_exe_files//edge_driver//msedgedriver.exe");
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.get("https://ecommercemarketplace.24livehost.com/");
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //global wait
		driver.manage().window().maximize();
		return driver;

	}
	
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException
	{
		//read json to string
	String jsonContent = 	FileUtils.readFileToString(new File(filePath), 
			StandardCharsets.UTF_8);
	
	//String to HashMap- Jackson Databind
	
	ObjectMapper mapper = new ObjectMapper();
	  List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
      });
	  return data;
	
	//{map, map}

	}
	
	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
		
		
	}
	
	@BeforeSuite(alwaysRun=true)
	public loginPageObject launchApplication() throws IOException
	{
		
		 driver = initializeDriver();
		 lp = new loginPageObject(driver);
		 lp.goTo();
		 return lp;
		
	}
	
	
//	@AfterSuite(alwaysRun=true)
//	public void tearDown()
//	{
//		driver.close();
//	}
	
	
	// Capture the screenshot and store it as a file
	public String grabFailureScreenshot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
	    File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

	    // Generate a unique file name with date and time
	    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	    String screenshotPath = System.getProperty("user.dir") + "//screenshots//screenshot_" + testCaseName
	    		+ "__" + timeStamp + ".png";
	    
	    File destinationFolder = new File(screenshotPath);
	    
	    try {
	    	  // Save the screenshot to the specified path
		    FileUtils.copyFile(srcFile, destinationFolder);

		    System.out.println("Screenshot saved to: " + screenshotPath);
	    	
	    }catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }

	    
	    return screenshotPath; //return path where screenshot is saved
	}
    
	
	
}
