package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class dropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "F:\\Automation work\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); //implicit wait
		
		//click on departure city
		driver.findElement(By.xpath("//input[@name='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
		//click on from city
		driver.findElement(By.xpath("//a[@text='Jaipur (JAI)']")).click();
		//click on to city
		driver.findElement(By.xpath("(//a[@text='Goa (GOI)'])[2]")).click();
		
		//select current date
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
		                                   
		/*//try select the custom date. We need to select month as October
		while(!driver.findElement(By.xpath("//div[@class='ui-datepicker-title']//span[@class='ui-datepicker-month']")).getText().contains("October"))
		{
			driver.findElement(By.cssSelector(".ui-datepicker-next.ui-corner-all>span")).click();
		}
		//select date 22 of month October.
		List<WebElement> dates = driver.findElements(By.cssSelector(".ui-datepicker-group.ui-datepicker-group-last"));  //get all dates
		for(int i=0; i<dates.size(); i++)
		{
			String date = dates.get(i).getText();
			if(date.equalsIgnoreCase("22"))
			{
				dates.get(i).click();
			}
		}*/
		
		//select passengers from the select dropdown
		driver.findElement(By.cssSelector("div#divpaxinfo.paxinfo")).click();
		//select adults
		Select adult = new Select(driver.findElement(By.xpath("//select[@name='ctl00$mainContent$ddl_Adult']")));
		adult.selectByValue("3");
		//select child
		Select child = new Select(driver.findElement(By.xpath("//select[@name='ctl00$mainContent$ddl_Child']")));
		child.selectByValue("2");
		
		//select currency
		Select currency = new Select(driver.findElement(By.xpath("//select[@name='ctl00$mainContent$DropDownListCurrency']")));
		currency.selectByValue("USD");
		
		//click on search button.
		driver.findElement(By.xpath("//input[@name='ctl00$mainContent$btn_FindFlights']")).click();	
		
		driver.quit();
		
		
		
	}

}
