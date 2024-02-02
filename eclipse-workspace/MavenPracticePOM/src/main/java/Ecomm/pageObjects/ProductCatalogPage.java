package Ecomm.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Ecomm.reusabledClass.AbstractClassReUse;

public class ProductCatalogPage extends AbstractClassReUse{
	
	WebDriver driver;
	
	public ProductCatalogPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this); //this is used to initialize the driver as the elements written below will need the driver
	}
	
	
	@FindBy(css=".mb-3")
	List<WebElement> prod;
	// this is same as writing (List<WebElement> AllItems = driver.findElements(By.cssSelector(".mb-3"));) *************************
	
	//Page factory is used for driver.findElement so we have not used it here
	By products = By.cssSelector(".mb-3"); 
	
	// to get the all product list
	public List<WebElement> getProductList() {
		
		waitForElementsToAppear(products); // waiting for products to load
		return prod;
		
	}
	
    //to get product by name
	public WebElement getProductByName(String productTitle) {
		
    	WebElement product = getProductList().stream()
				.filter(Item -> Item.findElement(By.cssSelector("b")).getText().equals(productTitle)).findFirst()
				.orElse(null);
    	return product;
		
	}
	
	By addToCart = By.cssSelector("button[class='btn w-10 rounded']");
	
	@FindBy(css="#toast-container")
	WebElement toastMsg;
	//driver.findElement(By.cssSelector("#toast-container")))
	//to add product to cart
    public void addProductToCart(String productTitle) {
		
    	WebElement prod1 = getProductByName(productTitle);
    	prod1.findElement(addToCart).click();
    	elementVisibility(toastMsg);
		
	}
	
	
	
	
}
