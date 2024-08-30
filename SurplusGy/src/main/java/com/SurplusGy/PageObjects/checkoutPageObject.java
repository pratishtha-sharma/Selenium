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

public class checkoutPageObject extends AbstractClass {

	private WebDriver driver;
	JavascriptExecutor js;
	Actions actions;

	public checkoutPageObject(WebDriver driver) {
		super(driver);
		// initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// click on add to cart
	@FindBy(css = ".input-group-text.changequantity.increment-btn")
	WebElement increment;


	public void updateCartButton() throws InterruptedException {
		

	}

	

}
