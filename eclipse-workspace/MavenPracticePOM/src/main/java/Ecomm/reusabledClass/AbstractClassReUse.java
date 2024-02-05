package Ecomm.reusabledClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Ecomm.pageObjects.CartPage;
import Ecomm.pageObjects.OrderPage;

public class AbstractClassReUse {
	
	WebDriver driver;
	
	

	public AbstractClassReUse(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this); //this is used to initialize the driver as the elements written below will need the driver
		
	}

	public void waitForElementsToAppear(By findBy) {
	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".mb-3")))); // waiting for products to load

	}
	
	public void elementVisibility(WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cartHeader;
	
	public CartPage goToCart() {
		cartHeader.click();
		CartPage cartPage = new CartPage(driver); //as clicking on cart icon takes to cart page
		return cartPage;
	}
	
	@FindBy(css="button[routerlink*='/myorders']")
	WebElement orderHeader;
	
	public OrderPage goToOrder() {
		orderHeader.click();
		OrderPage orderP = new OrderPage(driver); //as clicking on cart icon takes to cart page
		return orderP;
	}
	
}
