package calendar;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class calendar {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "F:\\Automation work\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companions");
		
	    driver.manage().window().maximize();
	    
	    driver.findElement(By.id("travel_date")).click();
	    
	    //select month
	    
	    //driver.findElement(By.xpath("//div[@class='datepicker-days']/table[1]/thead[1]/tr[1]/th[2]")).click();
	    while(!driver.findElement(By.xpath("//div[@class='datepicker-days']/table[1]/thead[1]/tr[1]/th[2]")).getText().contains("February"))
	    {
	    	driver.findElement(By.xpath("//div[@class='datepicker-days']/table[1]/thead[1]/tr[1]/th[3]")).click();
	    }
	    
	    //select date  -----> 25th Feb 2020
	    List<WebElement> dates = driver.findElements(By.className("day"));
	    //size of all the dates.
	    int count = dates.size();
	    //System.out.println(count);
	    
	    for(int i=0 ; i<count ; i++)
	    {
	    	String text = dates.get(i).getText();
	    	
	    	if(text.equalsIgnoreCase("25"))
	    	{
	    		dates.get(i).click();
	    		break;
	    	}
	    }
	    
	   // String month = driver.findElement(By.xpath("//div[@class='datepicker-days']/table[1]/thead[1]/tr[1]/th[2]")).getText().contains("February");
	    Thread.sleep(3000);
	    driver.quit();

	}

}
