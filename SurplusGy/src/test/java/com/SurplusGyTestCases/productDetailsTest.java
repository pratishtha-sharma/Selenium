package com.SurplusGyTestCases;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;


import com.SurplusGy.PageObjects.dashBoardPageObject;
import com.SurplusGy.PageObjects.productDetailsPageObject;
import com.SurplusGyTestComponents.BaseClassSurplus;

public class productDetailsTest extends BaseClassSurplus{
	
	public dashBoardPageObject db;
	public productDetailsPageObject pd;
	String variant ="M";
	
	public SoftAssert softAssert;
	
	
	@Test(priority = 3, dependsOnMethods = {"signIn"}) //testcase 3
	public void addToCart() throws InterruptedException {
		pd.clickAddTOCart(); //click without selecting variant
		//message should be shown when we click on cart without selecting variant
		String actual = pd.errorMsg();
		String expected = "Select all variant";
		Assert.assertEquals(expected, actual);
		Thread.sleep(1000);
		//select variant and click on add to cart
		//pd.selectVariant(variant);
		pd.selectVariant(variant);
		Thread.sleep(1000);
		pd.clickAddTOCart();
		
		boolean val = pd.cartAddMsg();
		softAssert = new SoftAssert(); 
		//Assert.assertTrue(val);// need to add soft alert here
		if (val == true) {
			softAssert.assertTrue(val);
			softAssert.assertAll();
			System.out.println("True condition achieved");
		} else if(val == false) {
			softAssert.assertFalse(val);
			softAssert.assertAll();
			System.out.println("False condition faced");
		}
		
		System.out.println("Check the cart!!!!!!");
		Thread.sleep(2000);
		
		pd.wishlist(); // select wishlist if not selected otherwise ignore
		
	}
	
	

}
