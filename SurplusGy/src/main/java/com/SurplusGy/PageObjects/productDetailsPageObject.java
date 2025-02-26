package com.SurplusGy.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



import com.SurplusGy.AbstractClass.AbstractClass;
import org.openqa.selenium.WebElement;


public class productDetailsPageObject extends AbstractClass {

	WebDriver driver;
	


	public productDetailsPageObject(WebDriver driver) {
		super(driver);
		// initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	//click on add to cart
	@FindBy(css= "#add_to_cart.custom-btn.btn.addtocartBtn")
	WebElement addToCartOnDetails;
	
	public void clickAddTOCart() {
		addToCartOnDetails.click();
		
	}
	
	@FindBy(css = "#add_to_cartErr") // msg when variant is not selected
	WebElement errMsg;
	
	public String errorMsg() {
		String text = errMsg.getText();
		return text;
	}
	
	@FindBy(css= ".radio-custom") // to select variant 
	List<WebElement> variants;
	
	By vari = By.cssSelector(".radio-custom");
	
	public void selectVariant(String variant) {
		
//		WebElement vari1 = variants.stream()
//				.filter(Item -> Item.findElement(vari).getText().equals(variant))
//				.findFirst()
//				.orElse(null); // stream
		
//		for(int i=0; i<variants.size();i++) { // for loop
//			String text = variants.get(i).getText();
//			if(text.equalsIgnoreCase(variant)) {
//				variants.get(i).click();
//                break;
//			}
//		}
		
		  for (WebElement vari1 : variants) { // for each loop
	            if (vari1.getText().equals(variant)) {
	            	vari1.click();
	                break;
	            }
	        }
		
		
	}
	
	// to select M directly since above is not working, this is fixed value
	
//	@FindBy(xpath = "//label[contains(text(),'M')]")
//	WebElement variant;
//	
//	public void selectVariant() {
//		variant.click();
//	}
	
	
	@FindBy(css= "#cart_meSSage.alert-success")
	WebElement cartSuccess;
	
	@FindBy(css= "#cart_meSSage.alert-danger")
	WebElement cartFail;
	
	public boolean cartAddMsg() {
		
		boolean isVisible = cartSuccess.isDisplayed(); 
		if (isVisible) {
            System.out.println("The element is visible on the page."); // when product added successfully in cart.
        } else {
            System.out.println("The element is not visible on the page!!!");// when faced any error while adding product to cart
        }
		
		return isVisible; // this will return true or false
		
	}
	
	//wishlist
	@FindBy(xpath="(//i[@id='wishlist'])[1]") // wishlist not selected
	WebElement wishlistNotSelected;
	
	@FindBy(css="i[id='wishlist'][class='fas fa-heart']") // wishlist selected $$("i[id='wishlist'][class='fas fa-heart'][style='color: red;']")
	WebElement wishlistSelected;
	
	@FindBy(xpath="//div[contains(text(), 'Product added to wishlist successfully.')]")
	WebElement wishlistSuccess;
	
	@FindBy(xpath="//div[contains(text(), 'Product removed from wishlist successfully.')]")
	WebElement wishlistRemove;
	
	
	public void wishlist() {
//		boolean isNotSelected = wishlistNotSelected.isDisplayed();
//		boolean isSelected = wishlistSelected.isDisplayed(); //wishlist already selected
		
		if (wishlistNotSelected.isDisplayed()) {
			wishlistNotSelected.click();
            System.out.println("Wishlist icon was not selected. It has been clicked.");
            System.out.println(wishlistSuccess.getText());
            
        } else if (wishlistSelected.isDisplayed()){
            System.out.println("Wishlist icon is already selected. So unclicked the same");
            System.out.println(wishlistRemove.getText());
        }
		
	}
	
	
	
//	public String wishlistMsg() {
//		
//		String text = null;
//		if(wishlistSuccess.isDisplayed()) {
//			text = wishlistSuccess.getText();
//			System.out.println(text);
//			//return text;
//		}
//		
//		else if (wishlistRemove.isDisplayed()) {
//			text = wishlistRemove.getText();
//			System.out.println(text);
//			//return text;
//		}
//		return text;
//		
//		
//	}
	

}
