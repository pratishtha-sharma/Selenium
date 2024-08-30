package com.SurplusGy.ExtentReport;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class extentReport {
	public static ExtentReports getReport() {

		
		// Create a date format to append to the report name
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		String reportPath = System.getProperty("user.dir") + "//ExtentReports//ExtentReport_" + timeStamp + ".html";
//		String reportPath= System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter esp = new ExtentSparkReporter(reportPath);
		esp.config().setReportName("Selenium Test Report - " + timeStamp);
		esp.config().setDocumentTitle("Web Automation Report");
		esp.config().setTheme(Theme.DARK);

		// Initialize ExtentReports and attach the reporter
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(esp);
		extent.setSystemInfo("Tester", "Pratishtha");

		return extent;
	}

}
