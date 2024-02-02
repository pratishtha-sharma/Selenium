package pack1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Buyerregistration {
	static String DraddressC = "D:\\Automation_jeet_eclipse\\software and dependencies\\softwares\\chromedriver_win32 (3)\\chromedriver.exe";
	static String DraddressF = "D:\\Automation_jeet_eclipse\\software and dependencies\\geckodriver-v0.30.0-win64 (1)\\geckodriver.exe";

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", DraddressC);

		WebDriver driver = new ChromeDriver();
		driver.get("https://productdevelopment.projectstatus.in");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("Jtest1");
		driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("lastname1");
		driver.findElement(By.xpath("//input[@id='mobile']")).sendKeys("946052505093");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("jtest2022@yopmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Dots@123");
		driver.findElement(By.xpath("//input[@id='password_confirmation']")).sendKeys("Dots@123");
		Thread.sleep(1000);
		WebElement drp32 = driver.findElement(By.xpath("//*[@id=\'selectUSerType\']"));
		Select dropdown1 = new Select(drp32);
		// driver.findElement(By.xpath("//select[@id=\'selectUSerType\']")).click();
		dropdown1.selectByVisibleText("Seller");
		dropdown1.selectByVisibleText("Buyer");

		driver.findElement(By.cssSelector("#company_name")).sendKeys("dotscompany1");
		driver.findElement(By.cssSelector("#abn")).sendKeys("ABN12345678");
		Thread.sleep(1000);
		Select dropdown4 = new Select(driver.findElement(By.xpath("//select[@id='market_id']")));
		dropdown4.selectByVisibleText("Wellington");
		Thread.sleep(3000);
		WebElement drp89 = driver.findElement(By
				.cssSelector("#buyer > div:nth-child(2) > div > div > span > span.selection > span > ul > li > input"));
		drp89.click();
		// istofWebElement> drp77=dr
		Select dropdown45 = new Select(drp89);
		dropdown45.selectByVisibleText("W3");

//	dropdown2.selectByVisibleText("jaipur");
//	
//	 Thread.sleep(1000);
//	Select dropdown3 = new Select(driver.findElement(By.xpath("//ul[@class='//input[@class='select2-search__field']']"))); 
//	dropdown3.selectByIndex(2);
//	WebElement drp32=driver.findElement(By.xpath("//*[@id=\'selectUSerType\']"));

		Thread.sleep(1000);
		// Select dropdown4 = new
		// Select(driver.findElement(By.xpath("//select[@id='market_id']")));
		// dropdown4.selectByIndex(1);
		Thread.sleep(1000);
		// Select dropdown4 = new
		// Select(driver.findElement(By.xpath("//select[@id='selectUSerType']")));
		// dropdown4.selectByVisibleText("Seller");
		Select dropdown21 = new Select(driver.findElement(By.xpath("//*[@id=\"settlement_method\"]")));
		dropdown21.selectByIndex(1);
		Thread.sleep(1000);
		Select dropdown3 = new Select(driver.findElement(By.xpath("//*[@id=\"payment_method\"]")));
		dropdown3.selectByIndex(1);
		Thread.sleep(1000);

		// Business address
		driver.findElement(By.xpath("//input[@id='company_address']")).sendKeys("Dottestabc ");
		driver.findElement(By.xpath("//input[@id='suburb']")).sendKeys("suburb1");
		driver.findElement(By.xpath("//input[@id='state']")).sendKeys("rajasthanstate");
		driver.findElement(By.xpath("//input[@id='country']")).sendKeys("indiacountry");
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("my city");
		driver.findElement(By.xpath("//input[@id='post_code']")).sendKeys("Postcode123");
		driver.findElement(By.xpath("//input[@id='co_op_number']")).sendKeys("cop1234567890");

		// Market Delivery address
		driver.findElement(By.xpath("//input[@id='market_address']")).sendKeys("Jtest1");
		driver.findElement(By.xpath("//input[@id='market_city']")).sendKeys("Jtest1");
		driver.findElement(By.xpath("//input[@id='market_state']")).sendKeys("Jtest1");
		driver.findElement(By.xpath("//input[@id='market_country']")).sendKeys("Jtest1");
		driver.findElement(By.xpath("//input[@id='market_postcode']")).sendKeys("Jtest1");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//iframe[@id='sq-card-number']")).sendKeys("41111111111111111");
		driver.findElement(By.xpath("//iframe[@id='sq-cvv']")).sendKeys("234");
		driver.findElement(By.xpath("//iframe[@id='sq-expiration-date']")).sendKeys("0224");
		driver.findElement(By.xpath("//iframe[@id='sq-postal-code']")).sendKeys("123456");

		// driver.findElement(By.xpath("//input[@id='withoutcard']")).click();
		WebElement submit = driver.findElement(By.xpath("//button[@id='sq-creditcard']"));
		submit.click();
		// System.out.println(driver.findElement(By.cssSelector("#parent_id-error")).getText());
		Thread.sleep(5000);

		// driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div/div/div[3]/a/div/h2")).click();
		// driver.close();
		System.setProperty("webdriver.gecko.driver", DraddressF);
		WebDriver driver1 = new FirefoxDriver();
		driver1.get("https://yopmail.com/en/");
		driver1.manage().window().maximize();

		Thread.sleep(1000);
		driver1.findElement(By.cssSelector("#login")).sendKeys("jtest2022");
		Thread.sleep(1000);
		driver1.findElement(By.xpath("//*[@id=\"refreshbut\"]/button/i")).click();
		Thread.sleep(1000);
		driver1.findElement(By.xpath("//*[@id=\"recaptcha-anchor\"]/div[1]")).click();
		Thread.sleep(5000);
		driver1.findElement(By.xpath(
				"//*[@id=\"mail\"]/div/table/tbody/tr/td/table[1]/tbody/tr[3]/td/table/tbody/tr[1]/td/span/p[3]/a"))
				.click();

		driver1.close();
	}
}