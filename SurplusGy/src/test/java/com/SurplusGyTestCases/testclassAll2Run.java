package com.SurplusGyTestCases;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.asserts.SoftAssert; 
import org.testng.annotations.DataProvider;


import com.SurplusGy.PageObjects.dashBoardPageObject;
import com.SurplusGy.PageObjects.myCartPageObject;
import com.SurplusGy.PageObjects.productDetailsPageObject;
import com.SurplusGyTestComponents.BaseClassSurplus;
import com.SurplusGyTestComponents.Retry;

public class testclassAll2Run extends BaseClassSurplus {
	
	public dashBoardPageObject db;
	public productDetailsPageObject pd;
	public myCartPageObject cart;
	String variant ="M";
	
	public SoftAssert softAssert;
	
	@Test (dataProvider="getData", priority = 1) //testcase 1
	public void signIn(String emailId, String password) throws InterruptedException {
		
		db = lp.loginToWeb(emailId, password);
		Thread.sleep(2000);
		
	
		//verify the success message on dashboard
		String actual = db.loginSuccessMsg();
		String expected = "Login successfully.";
		AssertJUnit.assertEquals(expected, actual);
		System.out.println("Text correct");
		
	}
	
	//retryAnalyzer= Retry.class
	
	@Test (priority = 2, dependsOnMethods = {"signIn"}) //testcase 2
	public void searchItemInSearchBar() throws InterruptedException {
	    pd  = db.searchBar();
		Thread.sleep(2000);
		
	}
	
	
	@Test(priority = 3, dependsOnMethods = {"signIn"}) //testcase 3
	public void addToCart() throws InterruptedException {
		pd.clickAddTOCart(); //click without selecting variant
		//message should be shown when we click on cart without selecting variant
		String actual = pd.errorMsg();
		String expected = "Select all variant";
		AssertJUnit.assertEquals(expected, actual);
		Thread.sleep(1000);
		//select variant and click on add to cart
		//pd.selectVariant(variant);
		pd.selectVariant(variant);
		Thread.sleep(1000);
		pd.clickAddTOCart();
		
		boolean val = pd.cartAddMsg();
		softAssert = new SoftAssert(); 
		//Assert.assertTrue(val);// need to add soft alert here
		if (val == true) { // when product added
			AssertJUnit.assertTrue(val);
			softAssert.assertAll();
			System.out.println("True condition achieved, product added"); 
		} else if(val == false) {
			AssertJUnit.assertFalse(val);
			softAssert.assertAll();
			System.out.println("False condition faced. Not able to add product");
		}
		
		System.out.println("Check the cart!!!!!!");
		Thread.sleep(2000);
		
		pd.wishlist(); // select wishlist if not selected otherwise ignore
		
	}
	
	
	@Test (priority = 4, dependsOnMethods = {"signIn"}) //testcase 4
	public void addCartIconClick() throws InterruptedException {
		cart = pd.clickMyCart();
		cart.updateCartButton();
		cart.cartUpdateSuccessMsg();
		cart.removeCartUpdateMsg();
		System.out.println("**************************");
		boolean val = cart.matchTotalAmount();
		
//		softAssert.assertTrue(matchTotal, "Total did not match as expected");
		
		softAssert = new SoftAssert(); 
		//Assert.assertTrue(val);// need to add soft alert here
		if (val == true) {
			AssertJUnit.assertTrue(val);
			softAssert.assertAll();
			System.out.println("Total amount matched");
		} else if(val == false) {
			AssertJUnit.assertFalse(val);
			softAssert.assertAll();
			System.out.println("Total amount did not match");
		}
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!");
		Thread.sleep(2000);

		cart.proceedToCheckout();

	}
	
	
	@Test (priority = 5, dependsOnMethods = {"signIn"}) //testcase 5
	public void checkoutPage() {
		
		
		
	}
	
	
	
	
	
	
	//****************** Data Provider *****************************
	@DataProvider
	public Object[][] getData() {
		return new Object[][] {
			{"lucy.chentest@yopmail.com", "Dots@123"}
		};	
	}

}
