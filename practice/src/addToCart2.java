import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class addToCart2 {

	WebDriver driver;

	@BeforeTest
	public void browser() {
		
		System.setProperty("webdriver.chrome.driver", "F:\\Automation work\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
				
	}
	
	@Test
	public void addCart() throws InterruptedException {
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//WebDriverWait wait = new WebDriverWait(driver,5);
		
		String [] item = {"Beetroot" , "Carrot" , "Orange" , "Pumpkin"};
		
		List<WebElement> allProducts = driver.findElements(By.cssSelector("h4.product-name"));
		int j=0;
		for(int i=0; i<allProducts.size(); i++) {
			
			String[] text = allProducts.get(i).getText().split("-");
			String products = text[0].trim();
			//System.out.println(products);
			List<String> items = Arrays.asList(item);
			//System.out.println(items);
			
			
			if(items.contains(products)) {
				j++;
				//driver.findElements(By.xpath("//button[contains(text(),'ADD TO CART')]")).get(i).click(); //this xpath is not proper as it is selecting random items from list
				driver.findElements(By.xpath("//a[contains(text(),'+')]")).get(i).click();
				Thread.sleep(3000);
				driver.findElements(By.xpath("//div[@class='product-action']//button")).get(i).click();
				
				if(j == items.size()) {
					break;
				}
				
			}
			
		}
		
		//click on cart icon
		driver.findElement(By.xpath("//a[@class='cart-icon']")).click();
		
		Thread.sleep(1000);
		
		//click on proceed to checkout
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		
		
	}
	
}
