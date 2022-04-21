package Automation.EPR;

import java.io.IOException;

import org.testng.annotations.BeforeTest;

public class login extends baseClass {
	
	
	@BeforeTest
	public void initialize() throws IOException {
		//if we further want to take screenshot then we need to assign this to the driver object so that object could be further used
		openBrowser();
		
	}

}
