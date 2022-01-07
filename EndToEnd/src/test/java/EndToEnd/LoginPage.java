package EndToEnd;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObject.pageObjectsLogin;

public class LoginPage extends baseClass {
	
	@Test
	public void LandingPage() throws IOException {
		driver = openbrowserDriver();
		driver.get(prop.getProperty("url"));
		
		pageObjectsLogin obj = new pageObjectsLogin(driver);
				
		//verify the nav bar
		Assert.assertTrue(obj.getNavBar().isDisplayed());
		
		//get title
		String text = obj.getTitle().getText();
		Assert.assertEquals("Featured Courses123", text);
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
		
	}

}
