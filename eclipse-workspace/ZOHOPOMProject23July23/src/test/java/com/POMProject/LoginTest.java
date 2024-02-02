package com.POMProject;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Interfaces.ZohoPages;
import Session.ZohoTestSession;
import baseClass.TestBaseClass;

public class LoginTest extends TestBaseClass{
	
	@BeforeTest
	public void openBrowser() throws IOException {
		launchBrowser(); //used EventFiringWebDriver to use the listeners
	}
	
	@Test
	public void loginTest() {
		
		ZohoTestSession session = new ZohoTestSession(); //new browser or driver has to be started	
		ZohoPages page = session.init();
		page.openBrowser("Chrome");
		driver.get("https://www.zoho.com/");
		driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
	}
	
	

}
