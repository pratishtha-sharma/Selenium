package com.SurplusGy.PageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;

import com.SurplusGy.AbstractClass.AbstractClass;
import org.openqa.selenium.WebElement;
import java.util.Random;

public class checkoutPageObject extends AbstractClass {

	WebDriver driver;
	JavascriptExecutor js;
	Actions actions;

	public checkoutPageObject(WebDriver driver) {
		super(driver);
		// initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// click on address dropdown //css = "#selectAddress"
	@FindBy(xpath = "//select[@id='selectAddress']")
	WebElement addressDd;
	
	public void addressDropdown() {
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		//waitForElementToAppear(addressDd);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(addressDd));
		Select ad = new Select(addressDd);
		ad.selectByValue("114");
		
		String selectedText = ad.getFirstSelectedOption().getText();
        System.out.println("Selected option: " + selectedText);
		
//		List<WebElement> options = ad.getOptions();
//		
//		Random random = new Random();
//		int index = random.nextInt(options.size());
//		
//		ad.selectByIndex(index);
//		String addressText = options.get(index).getText();

//		System.out.println("Selected address is :" +addressText);
	}
	
	//Add card details
	@FindBy(css = "#card-element")
	WebElement cardDetails;
	
	public void paymentDetails() {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,570)" );
		cardDetails.click();
		
//		cardDetails.sendKeys("4111111111111111"); // this did not work
//		cardDetails.sendKeys("05/30");
//		cardDetails.sendKeys("123");
		
		Actions actions = new Actions(driver);
//		/actions.moveToElement(cardDetails).click().sendKeys("4111111111111111").build().perform();
		actions.moveToElement(cardDetails).click().sendKeys("4111111111111111")
	       .sendKeys("05/30")  // Move to Expiry field
	       .sendKeys("123")   // Move to CVV field
	       .build().perform();
		
		js.executeScript("window.scrollTo(0, 0)"); // Scroll to top
		

	}
	
	
	// Add coupon code
	@FindBy(css = "#coupon_code")
	WebElement coupon;
	
	@FindBy(css = "#btnUseCouponCode")
	WebElement add;
	
	@FindBy(css = "i.fa.fa-window-close")
	WebElement removeCode;
	
	@FindBy(xpath = "//button[normalize-space()='Yes']")
	WebElement confirm;
	
	public void addCode() throws InterruptedException {
		coupon.click();
		coupon.sendKeys("Dots50");
		Thread.sleep(2000);
		add.click();
		Thread.sleep(2000);
		
		removeCode.click();
		
	}

   

	

}
