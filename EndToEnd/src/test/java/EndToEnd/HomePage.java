package EndToEnd;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.pageObjectsHome;
import pageObject.pageObjectsLogin;

public class HomePage extends baseClass{

	@Test(dataProvider = "getData")
	public void HomepageNavigation(String username, String password) throws IOException {
		driver = openbrowserDriver();
		driver.get(prop.getProperty("url"));
		pageObjectsLogin login = new pageObjectsLogin(driver);
		
		//if the pop up appears then we will close that
		if (login.getPopupsize()>0) {
			login.closePopup().click();;
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		pageObjectsHome obj = new pageObjectsHome(driver);
		obj.getLogin().click();
		
		//After clicking on login page we are entering email and password and then click on login button
		
		login.getEmail().sendKeys(username);
		login.getPassword().sendKeys(password);
		login.Login().click();
		
		driver.close();
		
		
	}
	
//	@AfterTest
//	public void closeBrowser() {
//		driver.close();
//		
//	}
	
	
	@DataProvider
	public Object[][] getData()
	{
		Object [][] data = new Object[2][2];
		data[0][0]= "tester1@gmail.com";
		data[0][1]= "123456";
		
		data[1][0]= "tester2@gmail.com";
		data[1][1]= "123456";
		
		return data;
	}
	
}
