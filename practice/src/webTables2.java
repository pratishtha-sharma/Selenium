import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class webTables2 {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "F:\\Automation work\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");
		
		//WebElement tables = driver.findElement(By.xpath("//table[@id='product' and @class='table-display']"));
		
		//table1
		List<WebElement> table = driver.findElements(By.xpath("//table[@class='table-display']//tbody//tr//td[3]"));
		int sum=0;
		
		for(int i=0; i<table.size(); i++) {
			String value = table.get(i).getText();
			int intval = Integer.parseInt(value);
			sum=sum + intval;
		}
		
		System.out.println(sum);
		
		//Table2
		List<WebElement> table2 = driver.findElements(By.xpath("//div[@class='tableFixHead']//tbody//tr//td[4]"));
		int total =0;
		
		for(int j=0; j<table2.size(); j++) {
			String val = table2.get(j).getText();
			int newval = Integer.parseInt(val);
			total = total + newval;
		}
		
		System.out.println(total);
		
		String text = driver.findElement(By.xpath("//div[contains(text(),' Total Amount Collected: 296 ')]")).getText().split(" ")[3];
		int num = Integer.parseInt(text);
		
		Assert.assertEquals(num, total);

	}

}
