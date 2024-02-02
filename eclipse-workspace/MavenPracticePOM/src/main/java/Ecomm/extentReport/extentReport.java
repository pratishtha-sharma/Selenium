package Ecomm.extentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class extentReport {
	
	public static ExtentReports getReport() {
		
		String path= System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter esp = new ExtentSparkReporter(path);
		esp.config().setReportName("Web Automation Report");
		esp.config().setDocumentTitle("Test Results");
		esp.config().setTheme(Theme.DARK);
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(esp);
		extent.setSystemInfo("Tester", "Pratishtha");
		
		return extent;
	}

}
