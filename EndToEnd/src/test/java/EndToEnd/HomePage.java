package EndToEnd;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageObject.pageObjectsHome;

public class HomePage extends baseClass{

	@Test
	public void HomepageNavigation() throws IOException {
		driver = openbrowserDriver();
		driver.get(prop.getProperty("url"));
		
		pageObjectsHome obj = new pageObjectsHome(driver);
		obj.getLogin().click();
		
		
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
		
	}
	
}
