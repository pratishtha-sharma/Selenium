package com.SurplusGy.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;

import com.SurplusGy.AbstractClass.AbstractClass;
import org.openqa.selenium.WebElement;

public class myCartPageObject extends AbstractClass {

	private WebDriver driver;
	JavascriptExecutor js;
	Actions actions;

	public myCartPageObject(WebDriver driver) {
		super(driver);
		// initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// click on add to cart
	@FindBy(css = ".input-group-text.changequantity.increment-btn")
	WebElement increment;

	@FindBy(xpath = "//button[contains(text(), 'Update Cart')]")
	WebElement updatecart;

	@FindBy(xpath = "//a[contains(text(),'Clear Shopping Cart')]")
	WebElement deletecart;

	public void updateCartButton() throws InterruptedException {
		increment.click();

		actions = new Actions(driver);
		actions.moveToElement(deletecart).build().perform();

		updatecart.click();
		Thread.sleep(3000);

	}

	@FindBy(css = "tr[class='item-info product_data'] td:nth-child(4)")
	List<WebElement> totalVal;

	@FindBy(css = ".grand_total")
	WebElement totalPrice;

	public boolean matchTotalAmount() {

		float sum = 0.00f;

		for (WebElement val : totalVal) {
			String[] text = val.getText().split("\\$");
			String price = text[1];
			System.out.println(price);
			float k = Float.parseFloat(price);

			sum = sum + k;

			//sum = sum + Integer.parseInt(val.getText());
		}

		System.out.println("Total of products is: " + sum);

		// compare grand total and total
		String[] text = totalPrice.getText().split("\\$");
		
		String grandTotal = text[1];
		System.out.println(grandTotal);

		float m = Float.parseFloat(grandTotal);
		System.out.println("Grand total of products is: " + m);

		if (sum == m) {
			System.out.println("Total amount is same.");
		}

		return true;

	}

	@FindBy(xpath = "//button[contains(text(),'Proceed to Checkout')]")
	WebElement proceed;

	public void proceedToCheckout() throws InterruptedException {

		Thread.sleep(3000);
		proceed.click();
	}

	@FindBy(css = ".alert.alert-info.alert-dismissible.fade.show")
	WebElement alertMsg;

	public String cartUpdateSuccessMsg() {
		String cartUpdateMsg = alertMsg.getText();
		System.out.println(cartUpdateMsg);
		return cartUpdateMsg;
	}

	@FindBy(xpath = "//span[contains(text(),'×')]")
	WebElement clearMsg;

	public void removeCartUpdateMsg() {
		clearMsg.click();
	}

}
