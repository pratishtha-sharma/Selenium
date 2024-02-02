package Ecomm.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Ecomm.reusabledClass.AbstractClassReUse;

public class CartPage extends AbstractClassReUse{
	
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this); //this is used to initialize the driver as the elements written below will need the driver
	}
	
	//List<WebElement> cartItems = driver.findElements(By.cssSelector(".cartSection h3"));
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartItems;
	
//	 public List<WebElement> cartItemsList() {
//			
//	    	return cartItems;
//			
//		}
	 
	 public Boolean matchItemsWithCartList(String productName) {
		 Boolean itemMatched = cartItems.stream().anyMatch(cartItem -> cartItem.getText().equalsIgnoreCase(productName));
		 return itemMatched;
			
	 }
	 
	 @FindBy(css=".totalRow .btn.btn-primary")
		WebElement checkoutButton;
	 
	 public CheckoutPage clickCheckout() {
		 checkoutButton.click();
		 CheckoutPage checkOutPage = new CheckoutPage(driver);
			return checkOutPage;
		}




}
