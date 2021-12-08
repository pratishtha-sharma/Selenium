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

public class greenKart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "F:\\Automation work\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);  //--------> implicit wait
		WebDriverWait w = new WebDriverWait(driver , 5); //----------> explicit wait
		
		String items [] = {"Brocolli" , "Cucumber" , "Brinjal"}; //make array list of this
		
		List<WebElement> products= driver.findElements(By.cssSelector("h4.product-name"));
		int j=0;
		
		for (int i = 0; i < products.size(); i++) {
			
			//need to trim the name as the name also contains - 1kg and we are only using the name
			String[] text= products.get(i).getText().split("-");
			String name= text[0].trim();
			
			
			//check if this text is present in the array or not
			//convert array to arraylist
			List itemList = Arrays.asList(items);
			//List<String> itemList = Arrays.asList(items);

			
			if(itemList.contains(name)) {  //text.contains("Cucumber") ---> for single object
			 j++;
			//driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();  //using text in xpath as index value of items changes when we select 1 item and thus text is not useful there as all the items have same text.
			 //click on add to kart
			 driver.findElements(By.xpath("//div[@class='product-action'] //button[@type='button']")).get(i).click();
             Thread.sleep(3000);
			//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			  if(j == items.length)
				  break;
			
			
			//break;  --> can't use as we are using multiple values in the array, can use this with the single statement
		      }
		 
	         }
		
		
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		//driver.findElement(By.xpath("//div[@class='action-block'] //button[@type='button']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter promo code']"))); //----------> explicit wait
		
		//enter promo code
		driver.findElement(By.xpath("//input[@placeholder='Enter promo code']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button[class='promoBtn']")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Promo code applied successfully!']")));  //----------> explicit wait
		System.out.println(driver.findElement(By.xpath("//span[text()='Promo code applied successfully!']")).getText());
		
		//place order
		driver.findElement(By.xpath("//button[contains(text(),'Place Order')]")).click();
		
		//choose country
		Select s = new Select(driver.findElement(By.xpath("//div[@class='wrapperTwo']//div//select")));
		s.selectByValue("India");
		//click on checkbox
		driver.findElement(By.xpath("//input[@class='chkAgree']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Proceed')]")).click();
		
		
		Thread.sleep(5000);
		//driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.close();
 }
}
