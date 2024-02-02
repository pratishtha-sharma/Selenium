package com.MavenPractice;

import java.time.Duration;
import java.util.List;

//import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneEcomm {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("userEmail")).sendKeys("pratishtha@mailinator.com");
		driver.findElement(By.id("userPassword")).sendKeys("Welcome@123");
		driver.findElement(By.id("login")).click();

		String productName = "ADIDAS ORIGINAL";
		Thread.sleep(2000);
		String URL = driver.getCurrentUrl();
		// String ExpectedTitle =
		// "https://rahulshettyacademy.com/client/dashboard/dash";
		Assert.assertEquals(URL, "https://rahulshettyacademy.com/client/dashboard/dash");
		System.out.println("Expected URL is matched with actual URL");

		// adding explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".mb-3")))); // waiting for
																									// products to load
		// Add element to cart
		List<WebElement> AllItems = driver.findElements(By.cssSelector(".mb-3"));

		// add item to cart using for loop **********************
//		for(int i=0; i<AllItems.size(); i++) {
//			String text= AllItems.get(i).findElement(By.cssSelector("b")).getText();
//			Thread.sleep(2000);
//			System.out.println(text);
//			if(text.equals("ADIDAS ORIGINAL")) {
//				System.out.println("****************");
//				AllItems.get(i).findElement(By.cssSelector("button[class='btn w-10 rounded']")).click();
//				break;
//			}
//		}

		// above code using Java stream **********************
		WebElement product = AllItems.stream()
				.filter(Item -> Item.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst()
				.orElse(null);
		// by adding ".findFirst().orElse(null)" we are getting 1 element only, without
		// it it supposes that there are multiple element
		product.findElement(By.cssSelector("button[class='btn w-10 rounded']")).click();
		//another way for above line to click on add to cart ******************
		// product.findElement(By.cssSelector(".card-body button:last-of-type")).click();

		System.out.println("Item added to cart");

		// adding explicit wait
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#toast-container"))));
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

		// Verify the product name on cart page
		List<WebElement> cartItems = driver.findElements(By.cssSelector(".cartSection h3"));

		Boolean matchedItem = cartItems.stream().anyMatch(cartItem -> cartItem.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(matchedItem);

		driver.findElement(By.cssSelector(".totalRow .btn.btn-primary")).click(); // checkout button

		// Entering and selecting value in country dropdown **********************
//		Actions act = new Actions(driver);
//		act.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "ind").build().perform();
//
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
//		// select value in dropdown
//		driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();

		// another way to dropdown value selection using javascript executor **********************
		WebElement country = driver.findElement(By.cssSelector("[placeholder='Select Country']"));
		country.sendKeys("India");
		country.sendKeys(Keys.DOWN);
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		String countryName = "return document.querySelector(\"[placeholder='Select Country']\").value;";

		String text = (String) js.executeScript(countryName);
		System.out.println(text);
		
		while (text.equalsIgnoreCase(" India")) {
			
			//country.sendKeys(Keys.DOWN);
			country.sendKeys(Keys.ENTER);
			Thread.sleep(1000);

			text = (String) js.executeScript(countryName);

		}

		Thread.sleep(3000);
//		country.sendKeys(Keys.ENTER);

		// click on place order
		driver.findElement(By.cssSelector(".action__submit")).click();

		String actual = driver.findElement(By.cssSelector(".hero-primary")).getText();
		String expected = "THANKYOU FOR THE ORDER.";
		Assert.assertEquals(expected, actual);

		// driver.close(); sometimes getting connection reset error while using this
	}

}
