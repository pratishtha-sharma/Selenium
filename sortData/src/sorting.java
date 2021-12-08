import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class sorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "F:\\Automation work\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().window().maximize();
		
		List<WebElement> fruits = driver.findElements(By.cssSelector("tbody tr td:nth-child(2)"));
		
		driver.findElement(By.cssSelector("thead tr th:nth-child(2)")).click();
		driver.findElement(By.cssSelector("thead tr th:nth-child(2)")).click();
		
		ArrayList<String> orignalList = new ArrayList<String>();
		
		for(int i=0 ; i<fruits.size() ; i++)
		{
			orignalList.add(fruits.get(i).getText());
		}
		
		System.out.println("************"+orignalList+"************");
		
		ArrayList<String> copiedList = new ArrayList<String>();
		
		for(int j=0 ; j<orignalList.size(); j++)
		{
			copiedList.add(orignalList.get(j));
		}
		
		Collections.sort(copiedList);
		
		for(String s : copiedList)
		{
			System.out.println(s);
		}
		
		//System.out.println("************"+copiedList+"***********");
		System.out.println("***********************");
		
		Assert.assertTrue(orignalList.equals(copiedList));
		
		Collections.reverse(copiedList);
		
		for(String s : copiedList)
		{
			System.out.println(s);
		}

		driver.quit();
	}

}
