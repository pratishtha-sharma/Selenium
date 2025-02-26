package com.SurplusGy.AbstractClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.SurplusGy.PageObjects.myCartPageObject;

public class AbstractClass {
	
	WebDriver driver;

	public AbstractClass(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void waitForElementToAppear(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	public void waitForAllValues(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(findBy));
	}
	
	
	@FindBy(css=".fas.fa-shopping-cart") 
	WebElement cartIcon;
	// since it is on header which is available on all pages so defined this method here so could be called by any testcase
	
	public myCartPageObject clickMyCart() {
		cartIcon.click();
		myCartPageObject cart = new myCartPageObject(driver);
		return cart;
		
	}

}
