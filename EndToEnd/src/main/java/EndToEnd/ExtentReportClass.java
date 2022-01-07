package EndToEnd;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

   

public class ExtentReportClass {
	
	static ExtentReports reports;
	
	public static ExtentReports getReportObject() {
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		
		ExtentSparkReporter sr = new ExtentSparkReporter(path);
		sr.config().setReportName("Web Automation Status Report for pass/fail");
		sr.config().setDocumentTitle("Testcase Result");
		
		reports = new ExtentReports();
		reports.attachReporter(sr);
		reports.setSystemInfo("Tester", "Pratishtha");
		
		return reports;
		
	}

}
