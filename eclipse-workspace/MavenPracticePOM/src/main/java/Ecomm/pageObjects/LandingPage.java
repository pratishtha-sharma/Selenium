package Ecomm.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Ecomm.reusabledClass.AbstractClassReUse;

public class LandingPage extends AbstractClassReUse{
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this); //this is used to initialize the driver as the elements written below will need the driver
	}
	
	//WebElement userEmail = driver.findElement(By.id("userEmail"));
	
	//Page Factory
	@FindBy(id="userEmail")
	WebElement EmailId;
	// this is same as writing (WebElement userEmail = driver.findElement(By.id("userEmail"));) *************************
	
	@FindBy(id="userPassword")
	WebElement Password;
	
	@FindBy(id="login")
	WebElement LoginButton;
	
	//single function to add email and password and then login into the website
	public ProductCatalogPage loginIntoWeb(String email, String pswd) {
		EmailId.sendKeys(email);
		Password.sendKeys(pswd);
		LoginButton.click();
		ProductCatalogPage productPage = new ProductCatalogPage(driver);
		return productPage;
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}


}
