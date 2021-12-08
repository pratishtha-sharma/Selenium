package webTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class webTables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "F:\\Automation work\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		int sum=0;
		
		driver.get("https://www.cricbuzz.com/live-cricket-scorecard/23957/bgt-vs-nw-17th-match-super-league-t10-league-2019");
		driver.manage().window().maximize();
		
		WebElement tables = driver.findElement(By.cssSelector(".cb-col.cb-col-100.cb-ltst-wgt-hdr"));
		//int row = tables.findElements(By.cssSelector(".cb-col.cb-col-100.cb-scrd-itms")).size();
		int count = tables.findElements(By.cssSelector(".cb-col.cb-col-100.cb-scrd-itms div:nth-child(3)")).size();
		
		for(int i=0 ; i<count-2 ; i++)
		{
			//System.out.println(tables.findElements(By.cssSelector(".cb-col.cb-col-100.cb-scrd-itms div:nth-child(3)")).get(i).getText());
			String value = tables.findElements(By.cssSelector(".cb-col.cb-col-100.cb-scrd-itms div:nth-child(3)")).get(i).getText();
			int intvalue = Integer.parseInt(value);
			sum=sum + intvalue;
		}
		System.out.println(sum);
		
		String extras = tables.findElement(By.xpath("//div[text()='Extras']/following-sibling::div")).getText();
		int extra = Integer.parseInt(extras);
		int TotalSum = sum + extra;
		System.out.println(TotalSum);
		

		String total = tables.findElement(By.xpath("//div[text()='Total']/following-sibling::div")).getText();
		System.out.println("The actual total is = " + total);
		int Total = Integer.parseInt(total);
		
		if(TotalSum == Total)
		{
			System.out.println("The total value is correct");
		}
		else
		{
			System.out.println("The total is wrong. Please check again");
		}

		
		
		driver.quit();
		
	}

}
