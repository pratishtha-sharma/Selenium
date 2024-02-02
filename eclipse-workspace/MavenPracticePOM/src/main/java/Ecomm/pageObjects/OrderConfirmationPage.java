package Ecomm.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Ecomm.reusabledClass.AbstractClassReUse;

public class OrderConfirmationPage extends AbstractClassReUse{
	
	WebDriver driver;
	
	public OrderConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this); //this is used to initialize the driver as the elements written below will need the driver
	}
	
	 
	//driver.findElement(By.cssSelector(".hero-primary")).getText(); 
	@FindBy(css=".hero-primary")
	WebElement header;
	 
	 public String confirmPage() {
		 String text = header.getText();
		 return text;
		 
		}




}
