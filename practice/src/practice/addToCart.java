package practice;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class addToCart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "F:\\Automation work\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //----------> implicit wait
		WebDriverWait w = new WebDriverWait(driver , 5); //----------> explicit wait defined
		
		//write the array of objects that are needed to be clicked.
		String [] items = {"Cauliflower" , "Carrot" , "Orange"};
		
		//need to get the list of all products.
		List<WebElement> allItem = driver.findElements(By.cssSelector("h4.product-name"));
		int j=0;
		
		for(int i=0; i<allItem.size(); i++)
		{
			String [] text = allItem.get(i).getText().split("-"); //split the product name into 2
			String itemName = text[0].trim(); //trim the part that is not needed.
			//System.out.println(itemName);
			
			//now compare the name that we get in itemName is present in that items array or not. For this first we need to convert the items array into arraylist
			List<String> itemList = Arrays.asList(items);
			//System.out.println(itemList);
			
			if(itemList.contains(itemName))
			{ //if itemName has the item that is present in the Arraylist itemList then we will click on add to cart button.
				j++;
				driver.findElements(By.cssSelector(".product-action>button")).get(i).click(); //to write css for direct child div>a  
				
				//now to avoid traversing the whole list even if the elements in array items has been added we will break the loop.
				
				if(j == itemList.size())
					break;
			   
				/*
				if(j == items.length)
					break;
				*/
				
			}			
		}
		
		//click on cart icon
		driver.findElement(By.cssSelector(".cart-icon>img")).click();
		//click on proceed to checkout
		driver.findElement(By.cssSelector(".action-block>button")).click();
		//Now there are chances that after clicking on proceed to checkout the loader will come and we click on next element in between, 
		//but the element will not be found as the loader is still loading so we use explicit wait condition here
		//w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Enter promo code')]")));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter promo code']"))); //----------> explicit wait
		
		//Enter promocode
		driver.findElement(By.xpath("//input[@placeholder='Enter promo code']")).sendKeys("rahulshettyacademy");
		//click on apply button.
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Code applied ..!']")));
		
		
		//click on place order
		driver.findElement(By.xpath("//button[contains(text(),'Place Order')]")).click();
		
		//select the country
		Select s = new Select(driver.findElement(By.xpath("//div[@class='wrapperTwo']//div//select")));
		s.selectByValue("India");
		//click on the checkbox
		driver.findElement(By.cssSelector("input.chkAgree")).click();
		//click on proceed to finish
		driver.findElement(By.xpath("//button[contains(text(),'Proceed')]")).click();
		
		driver.quit();

	}

}
