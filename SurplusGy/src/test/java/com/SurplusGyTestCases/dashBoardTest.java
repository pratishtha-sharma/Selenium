package com.SurplusGyTestCases;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.SurplusGy.PageObjects.dashBoardPageObject;
import com.SurplusGyTestComponents.BaseClassSurplus;

public class dashBoardTest extends BaseClassSurplus{
	
	public dashBoardPageObject db;
	
	
	//@Test (priority = 2, dependsOnMethods = {"com.SurplusGyTestCases.loginTest.signIn"})
	@Test (priority = 2) // testcase 2
	public void searchItemInSearchBar() throws InterruptedException {
		db.searchBar();
		Thread.sleep(2000);
		
	}
	
	

}
