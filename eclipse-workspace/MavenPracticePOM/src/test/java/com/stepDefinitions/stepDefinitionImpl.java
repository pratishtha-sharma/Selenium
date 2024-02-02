package com.stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import com.TestComponents.baseClass;

import Ecomm.pageObjects.CartPage;
import Ecomm.pageObjects.CheckoutPage;
import Ecomm.pageObjects.LandingPage;
import Ecomm.pageObjects.OrderConfirmationPage;
import Ecomm.pageObjects.ProductCatalogPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefinitionImpl extends baseClass {

	public LandingPage lp;
	public ProductCatalogPage productPage;
	public CheckoutPage checkOutPage;
	public CartPage cartPage;
	public OrderConfirmationPage confirmOrder; 

	@Given("I landed on ecommerce website")
	public void I_landed_on_ecommerce_website() throws IOException {
		lp = launchWebSite();
	}

	@Given("^Logged in with emailId (.+) and password (.+)$")
	public void login_with_username_and_password(String email, String password) throws InterruptedException {
		productPage = lp.loginIntoWeb(email, password);
		Thread.sleep(2000);

		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://rahulshettyacademy.com/client/dashboard/dash");
		System.out.println("Expected URL is matched with actual URL");
	}

	@When("^I add product (.+) to Cart$")
	public void i_add_product_to_cart(String productName) {
		productPage.addProductToCart(productName);
		System.out.println("Item added to cart");
		cartPage = productPage.goToCart();
	}

	@When("^Click on checkout for (.+) and submit order$")
	public void click_on_checkout_and_submit_order(String productName) throws InterruptedException {

		// Verify the product name on cart page
		Boolean matchedItem = cartPage.matchItemsWithCartList(productName);
		Assert.assertTrue(matchedItem);

		checkOutPage = cartPage.clickCheckout();

		// Entering and selecting value in country dropdown
		checkOutPage.selectCountry("india");
		Thread.sleep(2000);
		confirmOrder = checkOutPage.placeOrder();
		
	}
	
	@Then("{string} message should be shown on Confirmation Page")
	public void check_the_confirmation_message(String string) {

		String actual = confirmOrder.confirmPage();
//		String expected = "THANKYOU FOR THE ORDER.";
		Assert.assertEquals(string, actual);
		
//		driver.close();
	}
	
	@Then("{string} message should be shown on login Page")
	public void msg_shown_on_login_page_with_wrong_details(String string) {
		Assert.assertEquals("Incorrect email or password.", string);
	}

}
