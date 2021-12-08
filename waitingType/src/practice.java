import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class practice {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "F:\\Automation work\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		driver.manage().window().maximize();
		
		String items [] = {"Cauliflower" , "Beetroot" , "Mushroom" , "Apple"};
		
		List<WebElement> products = driver.findElements(By.cssSelector(".product-name"));
		int x=0;
		for(int i=0 ; i<products.size() ; i++)
		{
			String[] text = products.get(i).getText().split("-");
			String itemName = text[0].trim();
			
			
			List itemList = Arrays.asList(items);
			
			if(itemList.contains(itemName))
			{
				driver.findElements(By.xpath("//a[@class='increment']")).get(0).click();
			}
			
			
			if(itemList.contains(itemName))
			{
				driver.findElements(By.cssSelector(".product-action")).get(i).click();
				Thread.sleep(3000);
				
				
				if(x == items.length)
					break;
				
			}
			
		}
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		
		
		Thread.sleep(2000);
		driver.quit();
	}

}
