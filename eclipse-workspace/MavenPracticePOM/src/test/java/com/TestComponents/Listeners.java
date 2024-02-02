package com.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Ecomm.extentReport.extentReport;

public class Listeners extends baseClass implements ITestListener {
	
	ExtentReports extent = extentReport.getReport();
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	@Override 
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		test = extent.createTest(result.getMethod().getMethodName());
		// from here we get the test case or method name which has passed or failed
		
		//using threadlocal class when testcases run in parallel as sometimes error is thrown when testcases run parallelly
		extentTest.set(test); // set id for thread running for particular test case
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().log(Status.PASS, "Testcase Passed....");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String ssFilePath = null;
		extentTest.get().log(Status.FAIL, "Testcase Failed!!!!!");
		extentTest.get().fail(result.getThrowable()); //this will add the message in report with the reason
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		try {
			ssFilePath = getScreenshot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		extentTest.get().addScreenCaptureFromPath(ssFilePath, result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}
	
	

}
