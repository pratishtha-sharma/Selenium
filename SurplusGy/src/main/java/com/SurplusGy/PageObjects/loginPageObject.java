package com.SurplusGy.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SurplusGy.AbstractClass.AbstractClass;
import org.openqa.selenium.WebElement;




public class loginPageObject extends AbstractClass {
	
WebDriver driver;
	
	public loginPageObject(WebDriver driver)
	{
		super(driver);
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//i[@class='fas fa-user']")
    WebElement loginButton;
	
	@FindBy(xpath = "//div[@class='form_heading']/h2")
    WebElement header;
	
//	@FindBy(css = "div#loading-overlay.class")
//	WebElement loader;
	
	@FindBy(name = "email")
	WebElement userEmail;
	
	@FindBy(id = "password")
	WebElement userPassword;
	
	@FindBy(xpath = "//input[@type='text']")
	WebElement eyeIcon;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement submit;
	
	
	public dashBoardPageObject loginToWeb(String email, String pwd) throws InterruptedException {
		loginButton.click();
		waitForElementToAppear(header);
		
		userEmail.sendKeys(email);
		userPassword.sendKeys(pwd);
		submit.click();
		
		dashBoardPageObject db = new dashBoardPageObject(driver); //since after login the user is taken to dashboard page so we can create its object here
		return db;
	}
	
	public void goTo() {
		driver.get("https://ecommercemarketplace.24livehost.com/");
	}

	
	
	
	

}
