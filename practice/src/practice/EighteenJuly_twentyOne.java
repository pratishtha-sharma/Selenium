package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EighteenJuly_twentyOne {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "F:\\Automation work\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies(); // delete all the cookies
		
		driver.get("https://staging.eprogresstracker.com/");
		
		driver.findElement(By.id("Email")).sendKeys("pratishtha.sharmads@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("Password@123");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		
		//driver.findElement(By.cssSelector(".ajs-button.ajs-ok")).click();
		
//		WebElement errorMsg = driver.findElement(By.cssSelector(".alert.alert-danger.msg-box.danger.alert-dismissable"));
//		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("Email")).sendKeys("testna19@24livehost.com");
		driver.findElement(By.id("Password")).sendKeys("Password@123");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
		Thread.sleep(5000);
		System.out.println("clicked on ok");
//		driver.findElement(By.id("Email")).sendKeys("pratishtha.sharmads@gmail.com");
//		System.out.println("email entered");
//		driver.findElement(By.id("Password")).sendKeys("Password@123");
//		System.out.println("password entered");
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//button[@type='submit']")).click();
		System.out.println("Logged in");
		
//		if (driver.findElement(By.cssSelector(".alert.alert-danger.msg-box.danger.alert-dismissable")).isDisplayed()) {
//			driver.findElement(By.xpath("//button[@class='close']")).click();
//			Thread.sleep(3000);
//			
//			driver.findElement(By.id("Email")).sendKeys("pratishtha.sharmads@gmail.com");
//			driver.findElement(By.id("Password")).sendKeys("Password@123");
//			Thread.sleep(2000);
//			driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
//			Thread.sleep(2000);
//			driver.findElement(By.xpath("//button[@type='submit']")).click();
//		}else {
//			driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
//			Thread.sleep(2000);
//			driver.findElement(By.id("Email")).sendKeys("pratishtha.sharmads@gmail.com");
//			driver.findElement(By.id("Password")).sendKeys("Password@123");
//			Thread.sleep(2000);
//			driver.findElement(By.xpath("//button[@type='submit']")).click();
//		}
			

	}

	
}
