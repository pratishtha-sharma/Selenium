
package pack1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SellerRegistration {
	
	    static String DraddressC="D:\\Automation_jeet_eclipse\\software and dependencies\\softwares\\chromedriver_win32 (3)\\chromedriver.exe";
	    static String DraddressF="D:\\Automation_jeet_eclipse\\software and dependencies\\geckodriver-v0.30.0-win64 (1)\\geckodriver.exe";	
	
	
	public static void main(String[] args) throws InterruptedException {
		for(int i=1;i<10;i++) {
			String s1="jtestx0000";
			String s2=s1+i;
			String s3="@yopmail.com";
		String Email= s2 + s3;
		String p1="946052583";
		
		String phone= p1+i;
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", DraddressC);
		
		WebDriver driver = new ChromeDriver();	
		driver.get("https://productdevelopment.projectstatus.in");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("Jtest1");
		driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("lastname1");
		driver.findElement(By.xpath("//input[@id='mobile']")).sendKeys(phone);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(Email);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Dots@123");
		driver.findElement(By.xpath("//input[@id='password_confirmation']")).sendKeys("Dots@123");
	    Thread.sleep(1000);
	    WebElement drp32=driver.findElement(By.xpath("//*[@id=\'selectUSerType\']"));
		Select dropdown1 = new Select(drp32);  
	 
		dropdown1.selectByVisibleText("Seller"); 

		driver.findElement(By.cssSelector("#company_name")).sendKeys("dotscompany1");
		driver.findElement(By.cssSelector("#abn")).sendKeys("ABN12345678");
    Thread.sleep(1000);
   Select dropdown4 = new Select(driver.findElement(By.xpath("//select[@id='parent_id']"))); 
    dropdown4.selectByVisibleText("Wellington");
    Thread.sleep(1000);
    
    Select dropdown45 = new Select(driver.findElement(By.xpath("//select[@id='submarket_id']"))); 
    dropdown45.selectByVisibleText("W3");
//	
		  
		    Thread.sleep(1000);
		 
			Select dropdown21 = new Select(driver.findElement(By.xpath("//*[@id=\"settlement_method\"]")));  
		    dropdown21.selectByIndex(1);
		    Thread.sleep(1000);
			Select dropdown3 = new Select(driver.findElement(By.xpath("//*[@id=\"payment_method\"]")));  
			dropdown3.selectByIndex(1);
		    Thread.sleep(1000);
			
		//Business address
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

	    //driver.findElement(By.xpath("//input[@id='withoutcard']")).click();
		WebElement submit=driver.findElement(By.xpath("//button[@id='sq-creditcard']"));
		submit.click();
		Thread.sleep(1000);
		//		System.out.println(driver.findElement(By.cssSelector("#parent_id-error")).getText());
//    	Thread.sleep(5000);
//		 Select dropdown451 = new Select(driver.findElement(By.xpath("select_plan_id"))); 
//		    dropdown451.selectByVisibleText("Monthly Access Pass");
//		    Thread.sleep(1000);
//		driver.findElement(By.cssSelector("//button[text()='Subscribe']")).click();
	 //   Thread.sleep(1000);
	 //   WebElement element = driver.findElement(By.cssSelector("#defaultcard > div.chkout-btn > button"));

	   // Actions actions = new Actions(driver);	
//
	 //   actions.moveToElement(element).click().perform();

		//driver.findElement(By.xpath("//img[@alt='Market Mobile']")).click();
	  //  Thread.sleep(1000);

		//driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div/div/div[3]/a/div/h2")).click();
	
//		WebDriver newWindow = driver.switchTo().newWindow(WindowType.WINDOW);
//		driver.manage().window().maximize();
//	    newWindow.get("https://www.google.com/intl/en-GB/gmail/about/");	
//		Thread.sleep(1000);
//	    driver.findElement(By.xpath("//a[@data-action='sign in']")).click(); 
//		Thread.sleep(1000);
//	    driver.findElement(By.cssSelector("#identifierId")).sendKeys("test.js0350@gmail.com");
//		Thread.sleep(1000);
//	    driver.findElement(By.cssSelector("#identifierNext> div > button > span")).click();
//	    Thread.sleep(1000);
//	    driver.findElement(By.cssSelector("#password > div.aCsJod.oJeWuf > div > div.Xb9hP > input")).sendKeys("Asdf@123456");
//	    Thread.sleep(1000);
//	    driver.findElement(By.cssSelector("#passwordNext")).click();
//	    Thread.sleep(1000);
//	    WebDriver newWindow1= driver.switchTo().newWindow(WindowType.TAB);*/
		System.setProperty("webdriver.gecko.driver", DraddressF);
		WebDriver driver1=new FirefoxDriver();
		
		driver1.get("https://yopmail.com/en/");
		//driver1.get("https://yopmail.com/en/mail?b=jtestx001&id=me_ZwVjAQN4ZGNlAGV3ZQNjZmHmBGLmBD==");
		Thread.sleep(2000);
		driver1.findElement(By.xpath("//input[@id='login']")).sendKeys(Email);
		Thread.sleep(1000);
		driver1.findElement(By.xpath("//*[@id=\"refreshbut\"]/button/i")).click();
		
		//driver.findElement(By.xpath("//*[@id=\"recaptcha-anchor\"]/div[1]")).click();
		Thread.sleep(1000);
		//driver1.findElement(By.xpath("/html/body/div[2]/div[2]/button/div[1]/span[2]"));
		Thread.sleep(4000);
		WebElement title1=driver1.findElement(By.xpath("/html/body/main/div/div/div/table/tbody/tr/td/table[1]/tbody/tr[3]/td/table/tbody/tr[1]/td/span/p[2]"));
		System.out.println(title1);
		String address=driver1.findElement(By.xpath("//a[text()='VERIFY MY EMAIL']")).getText();
		Thread.sleep(1000);
		//System.out.println(address);
		Thread.sleep(1000);
		//System.setProperty("webdriver.chrome.driver", DraddressF);
		
	
		Thread.sleep(3000);
		
	}
		}
}