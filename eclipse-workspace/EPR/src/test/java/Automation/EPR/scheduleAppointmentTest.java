package Automation.EPR;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import pageObjects.LoginObject;

public class scheduleAppointmentTest extends baseClass {
	
	@Test(priority=3)
	public void openNewWindow() throws InterruptedException {
		driver.switchTo().newWindow(WindowType.WINDOW);
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentid = it.next();
        String childid = it.next();
        driver.switchTo().window(childid);
        
        
        
        String link = prop.getProperty("url");
		driver.get(link);
		Thread.sleep(2000);
		LoginObject lo = new LoginObject(driver);
		Thread.sleep(2000);
		lo.Logout().click();
		Thread.sleep(2000);
		lo.Email().sendKeys(prop.getProperty("username2"));
		lo.Password().sendKeys(prop.getProperty("password2"));
		lo.SignIn().click();
        
        
		
	}
	

}
