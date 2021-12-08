package calendar;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class calendar1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "F:\\Automation work\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
		Thread.sleep(3000);
		
		//select month
		while(!driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/span[@class='ui-datepicker-month']")).getText().contains("March"))
		{
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		}
		
		//select date
		List<WebElement> dates = driver.findElements(By.cssSelector(".ui-state-default"));
		
		int count = dates.size();
		
		for(int i=0 ; i<count ; i++)
		{
			String text = dates.get(i).getText();
			
			if(text.equalsIgnoreCase("29"))
			{
				//Thread.sleep(2000);
				dates.get(i).click();
			}
		}
		
		
		Thread.sleep(3000);
		driver.quit();
		
		
	}

}
