package com.SurplusGyTestCases;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.SurplusGy.PageObjects.dashBoardPageObject;
import com.SurplusGyTestComponents.BaseClassSurplus;

public class loginTest extends BaseClassSurplus{
	
	public dashBoardPageObject db;
	
	@Test (dataProvider="getData", priority = 1) //testcase 1
	public void signIn(String emailId, String password) throws InterruptedException {
		
		db = lp.loginToWeb(emailId, password);
		Thread.sleep(2000);
		
	
		//verify the success message on dashboard
		String actual = db.loginSuccessMsg();
		String expected = "Login successfully.";
		Assert.assertEquals(expected, actual);
		System.out.println("Text correct");
		
	}
	
	
	
	
	@DataProvider
	public Object[][] getData() {
		return new Object[][] {
			{"lucy.chentest@yopmail.com", "Dots@123"}
		};	
	}

}
