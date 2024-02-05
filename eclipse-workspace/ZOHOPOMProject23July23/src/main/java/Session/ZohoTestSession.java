package Session;

import org.testng.Reporter;

import Interfaces.ZohoPages;
import Pages.LaunchPage;

public class ZohoTestSession {
	
	public ZohoPages init() {
		
		if(Reporter.getCurrentTestResult().getTestContext().getAttribute("session") == null)
			Reporter.getCurrentTestResult().getTestContext().setAttribute("session", this);
		
		// this is used for current object of zoho session created in LoginTest by the name session
		// we can also write "new ZohoSessionTestClass()" but it will create new obj and we require the current obj
		
		ZohoPages page = new LaunchPage();
		return page;
		
	}

}
