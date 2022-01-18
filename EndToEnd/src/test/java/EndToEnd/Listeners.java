package EndToEnd;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners extends baseClass implements ITestListener{
	
	ExtentReports reports = ExtentReportClass.getReportObject();
	ExtentTest test;
	ThreadLocal <ExtentTest> tl = new ThreadLocal <ExtentTest>();
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		test = reports.createTest(result.getMethod().getMethodName());
		tl.set(test);
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		tl.get().log(Status.PASS, "Testcase Passed");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//Screenshot on failure
		tl.get().fail(result.getThrowable()); //throws the failure that occurs in the case and catch the same here to attach to the report, gives the log of failure
		String failMethodName = result.getMethod().getMethodName();
		WebDriver driver = null;
		
		try {
			//get the driver object instance for which the test has failed as there are many driver objects that are opened
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
		
		try {
			tl.get().addScreenCaptureFromPath(getScreenshotPath(failMethodName, driver), result.getMethod().getMethodName());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	    reports.flush();
		
	}

}
