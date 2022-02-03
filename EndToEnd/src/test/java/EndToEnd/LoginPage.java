package EndToEnd;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObject.pageObjectsLogin;

public class LoginPage extends baseClass {
	
	public static Logger log = LogManager.getLogger(baseClass.class.getName());
	
	@Test
	public void LandingPage() throws IOException {
		driver = openbrowserDriver();
		driver.get(prop.getProperty("url"));
		
		pageObjectsLogin obj = new pageObjectsLogin(driver);
				
		//verify the nav bar
		Assert.assertTrue(obj.getNavBar().isDisplayed());
		log.info("Nav bar is displayed");
		
		//get title
		String text = obj.getTitle().getText();
		
		Assert.assertEquals("FEATURED COURSES11", text);
		
		log.warn("Error has occured with title");
		
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
		
	}

}
