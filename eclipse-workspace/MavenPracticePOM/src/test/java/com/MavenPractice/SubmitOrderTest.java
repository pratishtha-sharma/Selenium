package com.MavenPractice;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.TestComponents.Retry;
import com.TestComponents.baseClass;

import Ecomm.pageObjects.CartPage;
import Ecomm.pageObjects.CheckoutPage;
import Ecomm.pageObjects.OrderConfirmationPage;
import Ecomm.pageObjects.OrderPage;
import Ecomm.pageObjects.ProductCatalogPage;
public class SubmitOrderTest extends baseClass{
	public ProductCatalogPage productPage;

	//String productName = "ADIDAS ORIGINAL"; 
	
	@Test(dataProvider="getData", retryAnalyzer= Retry.class, groups= {"submitOrder"})
	public void submitOrder(String emailId, String password, String productName) throws InterruptedException, IOException
	{
	    productPage = lp.loginIntoWeb(emailId, password);
		Thread.sleep(2000);

		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://rahulshettyacademy.com/client/dashboard/dash");
		System.out.println("Expected URL is matched with actual URL");

		//add product to cart
		productPage.addProductToCart(productName);
		System.out.println("Item added to cart");
		
		//click on cart
		CartPage cartPage = productPage.goToCart();
		
		// Verify the product name on cart page
		Boolean matchedItem = cartPage.matchItemsWithCartList(productName);
		Assert.assertTrue(matchedItem);
		
		CheckoutPage checkOutPage = cartPage.clickCheckout();
		
		// Entering and selecting value in country dropdown
		checkOutPage.selectCountry("india");

		// click on place order
		OrderConfirmationPage confirmOrder = checkOutPage.placeOrder();

		String actual = confirmOrder.confirmPage();
		String expected = "THANKYOU FOR THE ORDER.";
		Assert.assertEquals(expected, actual);
		
		// driver.close(); //sometimes getting connection reset error while using this
	}
	
	@Test(dependsOnMethods = {"submitOrder"}, dataProvider="getData", retryAnalyzer= Retry.class, groups= {"submitOrder"})
	public void orderHistory(String emailId, String password, String productName) {
		//productPage = lp.loginIntoWeb(emailId, password);
		OrderPage orderP = productPage.goToOrder();
		Boolean itemMatched = orderP.matchItemsWithOrderList(productName);
		Assert.assertTrue(itemMatched);
		System.out.println("Item in order history matched");
    }
	
	
	@DataProvider
	public Object[][] getData() {
		return new Object[][] {
			{"pratishtha@mailinator.com", "Welcome@123", "ADIDAS ORIGINAL"},
			//{"anshika@gmail.com", "Iamking@000", "ZARA COAT 3"}
		};	
	}
	
}	


