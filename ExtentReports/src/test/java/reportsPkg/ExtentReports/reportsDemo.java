package reportsPkg.ExtentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class reportsDemo {

	ExtentReports report; //when defined inside a method then it can not be used in other method as it works locally only so I have defined this globally
	@BeforeTest
	public void Reporting()
	{
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter extent = new ExtentSparkReporter(path); //responsible for setting the configurations for the reports and setting the path of report
		extent.config().setDocumentTitle("Test Results");
		extent.config().setReportName("Web Automation Test Results");
		
		report = new ExtentReports();
		report.attachReporter(extent); //to attach the report created to this main class as this is responsible for reporting execution
		report.setSystemInfo("Tester", "Pratishtha Sharma");
		
	}
	
	@Test
	public void initialDemo()
	{
		ExtentTest test = report.createTest("initialDemo");
		System.setProperty("webdriver.chrome.driver", "F:\\Automation work\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/#/index");
		System.out.println(driver.getTitle());
		driver.close();
		test.fail("The result has been failed");
		
		report.flush();
		
	}
	
}
