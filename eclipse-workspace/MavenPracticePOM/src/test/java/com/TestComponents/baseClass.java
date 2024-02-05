package com.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeSuite;

import Ecomm.pageObjects.LandingPage;

public class baseClass {

	public WebDriver driver;
	public LandingPage lp;

	public WebDriver initializeDriver() throws IOException {
		
		//to run from maven with global properties
		// mvn test -Dbrowser=Firefox    -D stands for maven parameters

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src//test//java//com//TestComponents//globalData.properties");
		prop.load(fis);
		String browserName = System.getProperty("browser") !=null ? System.getProperty("browser") : prop.getProperty("browser");
		
		//prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			// WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

			driver.manage().window().maximize();
			// driver.get("https://rahulshettyacademy.com/client");

		} else if ((browserName.equalsIgnoreCase("firefox")))

		{
			driver = new FirefoxDriver();

			driver.manage().window().maximize();
		} else if ((browserName.equalsIgnoreCase("edge")))

		{
			driver = new EdgeDriver();

			driver.manage().window().maximize();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		return driver;
	}

	@BeforeSuite(alwaysRun = true)
	public LandingPage launchWebSite() throws IOException {

		driver = initializeDriver();
		// Landing Page
		lp = new LandingPage(driver);
		lp.goTo();
		return lp;
		// this page will be opened for each test case so we are making it generic

	}

//	@AfterMethod(alwaysRun=true)
//	public void tearDown() {
//		driver.close();
//	}

	// screenshot code
	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ss = (TakesScreenshot) driver;
		File sourceFolder = ss.getScreenshotAs(OutputType.FILE);
		File destinationFolder = new File(System.getProperty("user.dir") + "//screenshot//" + testCaseName + ".png");
		FileUtils.copyFile(sourceFolder, destinationFolder);
		return System.getProperty("user.dir") + "//screenshot//" + testCaseName + ".png";

	}

}
