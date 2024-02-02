package AutoSuggestive_Dropdown;
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

public class addToCart {

		WebDriver driver;

		@BeforeTest
		public void browser() {
			
			System.setProperty("webdriver.chrome.driver", "D:\\eclipse\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
					
		}
		
		@Test
		public void addCart() throws InterruptedException {
			
			driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			//WebDriverWait wait = new WebDriverWait(driver,5);
			
			String [] product = {"Cucumber" , "Brinjal" , "Mushroom" , "Musk Melon"};
			
			List<WebElement> allProducts = driver.findElements(By.cssSelector("h4.product-name"));
			
			for(int i=0; i<allProducts.size(); i++) {
				
				String[] text = allProducts.get(i).getText().split("-"); 
				String products = text[0].trim(); //all elements
				//System.out.println(products);
				int j=0;
				List<String> itemList = Arrays.asList(product); //4
				
				if(itemList.contains(products)) {
					//click on + icon to increase quantity
					j++;
					driver.findElements(By.xpath("//a[contains(text(),'+')]")).get(i).click();
					
					Thread.sleep(3000);
					
					driver.findElements(By.xpath("//div[@class='product-action']")).get(i).click();
					
					if(j == itemList.size()) {
						break;
					}
				}
				
				
			}
			
			
		}

}
