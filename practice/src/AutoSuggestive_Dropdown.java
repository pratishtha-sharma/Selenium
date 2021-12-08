import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AutoSuggestive_Dropdown {
	
	WebDriver driver;

	@BeforeTest
	public void browser() {
		
		System.setProperty("webdriver.chrome.driver", "F:\\Automation work\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
				
	}
	
	@Test
	public void makemytrip() throws InterruptedException {
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.xpath("//div[@class='loginModal displayBlock modalLogin dynHeight personal ']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("fromCity")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("jai");
		Thread.sleep(1000);
		
		//enter all the elements of the dropdown in the list
		List<WebElement> options= driver.findElements(By.xpath("//li[@role='option']/div/div/p[2]"));
//		List<WebElement> options= driver.findElements(By.xpath("//ul[@class='react-autosuggest__suggestions-list']//li[@role='option']"));
		
//		for(int i=0; i<= options.size()+1; i++) {
////			String text= options.get(i).getText();
////			System.out.println(text);	
//			if(options.get(i).getText().equalsIgnoreCase("New Delhi, India")) {
//				options.get(i).click();
//			}
//		}
		
		for(WebElement option : options)

		{

		if(option.getText().equalsIgnoreCase("Jaipur Airport"))

		{

		option.click();

		break;

		}
		}
		
		
		//To city
//		Thread.sleep(1000);
//		driver.findElement(By.id("toCity")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("Pune");
		Thread.sleep(1000);
		
		List<WebElement> tocities= driver.findElements(By.xpath("//li[@role='option']/div/div/p[2]"));
		
		for(WebElement tocity : tocities)

		{

		if(tocity.getText().equalsIgnoreCase("Pune Airport"))

		{

			tocity.click();

		break;

		}
		}
		

		//Select month
		while(!driver.findElement(By.xpath("//div[@class='DayPicker-Months']//div[@class='DayPicker-Month']//div[@class='DayPicker-Caption']")).getText().contains("January")) {
			driver.findElement(By.cssSelector(".DayPicker-NavButton.DayPicker-NavButton--next")).click();
		}
		
		Thread.sleep(3000);
		
		//Select to date
		List<WebElement> fromDates = driver.findElements(By.cssSelector(".DayPicker-Day"));
		int count= fromDates.size();
		Thread.sleep(2000);
		for(int i=0; i<count; i++) {
			String text = driver.findElements(By.cssSelector(".DayPicker-Day")).get(i).getText();
			if(text.contains("14")) {
				driver.findElements(By.cssSelector(".DayPicker-Day")).get(i).click();
				break;
			}
		}
		
		//Select from date
		driver.findElement(By.cssSelector(".latoBlack.font12.greyText")).click();
		while(!driver.findElement(By.xpath("//div[@class='DayPicker-Months']//div[@class='DayPicker-Month']//div[@class='DayPicker-Caption']")).getText().contains("January")) {
			driver.findElement(By.cssSelector(".DayPicker-NavButton.DayPicker-NavButton--next")).click();
		}
//		JavascriptExecutor js = (JavascriptExecutor) driver;  
//		js.executeScript("window.scrollBy(0,200)");
		
		List<WebElement> toDates = driver.findElements(By.cssSelector(".DayPicker-Day"));
		int count1= toDates.size();
		Thread.sleep(5000);
		for(int i=0; i<count1; i++) {
			String text = driver.findElements(By.cssSelector(".DayPicker-Day")).get(i).getText();
			if(text.contains("18")) {
				driver.findElements(By.cssSelector(".DayPicker-Day")).get(i).click();
				break;
			}
		}
		Thread.sleep(1000);
		//Search
		driver.findElement(By.cssSelector(".primaryBtn.font24.latoBold.widgetSearchBtn ")).click();
		
	}

}
