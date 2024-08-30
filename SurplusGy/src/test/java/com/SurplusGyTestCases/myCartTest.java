package com.SurplusGyTestCases;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;


import com.SurplusGy.PageObjects.dashBoardPageObject;
import com.SurplusGy.PageObjects.myCartPageObject;
import com.SurplusGy.PageObjects.productDetailsPageObject;
import com.SurplusGyTestComponents.BaseClassSurplus;

public class myCartTest extends BaseClassSurplus{
	
	public myCartPageObject cart;
	SoftAssert softAssert;
	
	@Test (priority = 4, dependsOnMethods = {"signIn"}) //testcase 4
	public void addCartIconClick() throws InterruptedException {
		cart.clickMyCart();
		cart.updateCartButton();
		cart.cartUpdateSuccessMsg();
		cart.removeCartUpdateMsg();
		System.out.println("**************************");
		boolean val = cart.matchTotalAmount();
		
//		softAssert.assertTrue(matchTotal, "Total did not match as expected");
		
		softAssert = new SoftAssert(); 
		//Assert.assertTrue(val);// need to add soft alert here
		if (val == true) {
			softAssert.assertTrue(val);
			softAssert.assertAll();
			System.out.println("Total amount matched");
		} else if(val == false) {
			softAssert.assertFalse(val);
			softAssert.assertAll();
			System.out.println("Total amount did not match");
		}
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!");
		Thread.sleep(2000);

		cart.proceedToCheckout();

	}

}
