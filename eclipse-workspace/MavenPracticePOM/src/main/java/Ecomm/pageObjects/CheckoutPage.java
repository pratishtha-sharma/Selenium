package Ecomm.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Ecomm.reusabledClass.AbstractClassReUse;

public class CheckoutPage extends AbstractClassReUse {

	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this); // this is used to initialize the driver as the elements written below
												// will need the driver
	}

	
	@FindBy(css = "[placeholder='Select Country']")
	WebElement countryDropdown;
	
	@FindBy(css = ".ta-item:nth-of-type(2)")
	WebElement select;

	By enteredCountryList = By.cssSelector(".ta-results");

	public void selectCountry(String Country) {
		Actions act = new Actions(driver);
		act.sendKeys(countryDropdown, Country).build().perform();
		waitForElementsToAppear(enteredCountryList);
		select.click();

	}

	
	@FindBy(css = ".action__submit")
	WebElement submit;

	public OrderConfirmationPage placeOrder() {
		submit.click();
		OrderConfirmationPage confirmOrder = new OrderConfirmationPage(driver);
		return confirmOrder;

	}

}
