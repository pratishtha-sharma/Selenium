package com.SurplusGy.PageObjects;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SurplusGy.AbstractClass.AbstractClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class dashBoardPageObject extends AbstractClass {

	WebDriver driver;

//	private Random rand = new Random();

	public dashBoardPageObject(WebDriver driver) {
		super(driver);
		// initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// verify the success message
	@FindBy(xpath = "//div[contains(text(), 'Login successfully.')]")
	WebElement loginSuccess;

	public String loginSuccessMsg() {
		String text = loginSuccess.getText();
		return text;
	}

	// wait for all elements in dropdown to be visible
	@FindBy(css = "ul#results")
	List<WebElement> searchedItems;

	By items = By.cssSelector("ul#results li");

	public List<WebElement> getProductList() {

		waitForAllValues(items); // waiting for products to load
		return searchedItems; // return all the list items

	}

	// Enter value in dropdown, click on option randomly
	@FindBy(css = "input#search_keywords")
	WebElement search;

	public productDetailsPageObject searchBar() throws InterruptedException {
		Actions actions = new Actions(driver);
		Thread.sleep(2000);
		actions.moveToElement(search).click().sendKeys("tshirt").build().perform();

		// now check if the dropdown items are there or not
		if (searchedItems.size() > 0) {
			// select random index and click on it
//			 Random rand = new Random(); // same value is getting selected coz class is reinitializing every time
//             int randomIndex = rand.nextInt(searchedItems.size());

			// threadlocalrandom helps in selecting random data
			int randomIndex = ThreadLocalRandom.current().nextInt(searchedItems.size()); 
			System.out.println(randomIndex);
			searchedItems.get(randomIndex).click();
			Thread.sleep(2000);

			String text = searchedItems.get(randomIndex).getText();

			// also print the random value selected to verify
			System.out.println("Selected item is: " + text);

			// Shuffle the list of dropdown options and select first value
//             Collections.shuffle(searchedItems);
//             searchedItems.get(1).click();
			
		} else {
			System.out.println("No such item is present at the moment");
		}
		
		//it will return product details page object as it is redirecting over there
		productDetailsPageObject pd = new productDetailsPageObject(driver);
		return pd;
		

	}

}
