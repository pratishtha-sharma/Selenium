package com.SurplusGyTestCases;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;


import com.SurplusGy.PageObjects.dashBoardPageObject;
import com.SurplusGy.PageObjects.myCartPageObject;
import com.SurplusGy.PageObjects.productDetailsPageObject;
import com.SurplusGyTestComponents.BaseClassSurplus;

public class checkoutTest extends BaseClassSurplus{
	
	public myCartPageObject cart;
	SoftAssert softAssert;
	
	@Test (priority = 5, dependsOnMethods = {"signIn"}) //testcase 5
	public void checkoutPage() {
		
	}
	

}
