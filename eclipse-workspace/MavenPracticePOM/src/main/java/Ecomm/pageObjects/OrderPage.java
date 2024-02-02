package Ecomm.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Ecomm.reusabledClass.AbstractClassReUse;

public class OrderPage extends AbstractClassReUse{
	
	WebDriver driver;
	
	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this); //this is used to initialize the driver as the elements written below will need the driver
	}
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> allOrderedItems;

	 
	 public Boolean matchItemsWithOrderList(String productName) {
		 Boolean itemMatched = allOrderedItems.stream().anyMatch(orderItem -> orderItem.getText().equalsIgnoreCase(productName));
		 return itemMatched;
			
	 }
	 
	 

}
