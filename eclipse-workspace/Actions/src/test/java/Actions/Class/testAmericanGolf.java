package Actions.Class;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testAmericanGolf extends baseClass {
	
	@BeforeTest
	public void launch() throws IOException {
		openbrowserDriver();
	}
	
	@Test
	public void americanGolf() throws InterruptedException {
		
		JavascriptExecutor js= (JavascriptExecutor) driver;
		
		js.executeScript("window.location='https://www.americangolf.co.uk/'");
		
		Actions act= new Actions(driver);
		WebElement e = driver.findElement(By.xpath("//*[@id=\"termly-code-snippet-support\"]/div/div/div/div/div/div[2]/button[2]"));
		e.click();
		Thread.sleep(2000);
		
		//WebElement e1 = driver.findElement(By.linkText("Golf Clubs"));
		WebElement golfClubs = driver.findElement(By.xpath("//*[@id=\"header-navigation\"]/div/ul/li[3]/a"));
		act.moveToElement(golfClubs).build().perform();
		driver.findElement(By.xpath("//*[@id='CLUBS_1']/ul/li[3]/ul/li[2]/a/span")).click();
		
		
		
//		WebElement element = driver.findElement(By.xpath("(//h3[contains(text(), 'Flex')])[2]"));
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element); //scrolling too much
		
		WebElement priceSelector = driver.findElement(By.xpath("//*[@id='secondary']/div[1]/div[8]/div/div/div[1]/div/div/div[1]/div"));
		int y = priceSelector.getLocation().y;
				
				
		
		js.executeScript("window.scrollBy(0,"+(y-300)+")");
		
		act.clickAndHold(priceSelector).moveByOffset(100, 0).build().perform();
		
		
	}

}
