package Automation.EPR;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class ExtentReportClass {
	
static ExtentReports reports;
	
	public static ExtentReports getReportObject() {
		String path = System.getProperty("user.dir")+"\\reports\\report.html";
		
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(path); // to make configuration/changes in report
		htmlReporter.config().setReportName("Web Automation Status Report for pass/fail");
		htmlReporter.config().setDocumentTitle("Testcase Result");
		
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
		reports.setSystemInfo("Tester", "Pratishtha");
		
		return reports;
		
	}

}
