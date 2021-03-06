package Automation.EPR;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pageObjects.LoginObject;

public class loginTest extends baseClass {
	
	ExtentReports reports = ExtentReportClass.getReportObject();
	ExtentTest test;
	
	
	@BeforeTest
	public void initialize() throws IOException {
		//if we further want to take screenshot then we need to assign this to the driver object so that object could be further used
		openBrowser();
		
	}
	
	@Test(priority=1)
	public void loginEPR() throws InterruptedException {
		
		String link = prop.getProperty("url");
		driver.get(link);
		Thread.sleep(2000);
		
		LoginObject lo = new LoginObject(driver);
		lo.Email().sendKeys(prop.getProperty("username1"));
		lo.Password().sendKeys(prop.getProperty("password1"));
		lo.SignIn().click();
		
		//Hippa pop up
		try {
			if(lo.Hippa().isDisplayed()) {
				lo.closeHippa().click();
			}	
		}catch(Exception ex) {
			System.out.println("Something went wrong.");
		}
		
		
		test = reports.createTest("initialDemo");
		test.pass("Passed");
		
		
		
	}
	
	@AfterTest
	public void afterTest() {
		reports.flush();
	}

}
