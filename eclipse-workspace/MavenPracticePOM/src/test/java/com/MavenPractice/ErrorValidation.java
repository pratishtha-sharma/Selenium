package com.MavenPractice;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.TestComponents.baseClass;
import com.TestComponents.Retry;

import Ecomm.pageObjects.CartPage;
import Ecomm.pageObjects.ProductCatalogPage;
public class ErrorValidation extends baseClass{
	
	@Test(retryAnalyzer= Retry.class)
	public void submitOrder() throws InterruptedException, IOException
	{
	    ProductCatalogPage productPage = lp.loginIntoWeb("anshika@gmail.com", "Iamking@000");
		Thread.sleep(2000);

		String productName = "T-SHIRT"; 
		Thread.sleep(2000);
		
        //we have added object of ProductCatalogPage in LandingPage so no need to create the object again
		
		//add product to cart
		productPage.addProductToCart(productName);
		System.out.println("Item added to cart");
		
		//click on cart
		CartPage cartPage = productPage.goToCart();
		
		// Verify the product name on cart page
		Boolean matchedItem = cartPage.matchItemsWithCartList("T-SHIR");
		Assert.assertFalse(matchedItem);
		
	}
	
	
	
}	


