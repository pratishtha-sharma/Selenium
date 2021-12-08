import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Rbook {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "F:\\Automation work\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://172.105.52.110:3000/login");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//enter username and password
		driver.findElement(By.name("user_name")).sendKeys("ak12");
		driver.findElement(By.name("password")).sendKeys("123456");
		
		//click on login.
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		Thread.sleep(2000);
		
		//Select Request from menu option.
		driver.findElement(By.xpath("//div[@class='left_navarea']/nav[1]/ul[1]/li[4]")).click();
		
		Thread.sleep(1000);
		
		//select deposit request 
		driver.findElement(By.xpath("//div[@class='left_navarea']/nav[1]/ul[1]/li[4]/ul/li[1]")).click();
		
		//enter data in all the required field
		for(int i=0; i<5; i++)
		{
			driver.findElement(By.name("transaction_id")).sendKeys("1234567890");
			driver.findElement(By.name("points")).sendKeys("50");
			driver.findElement(By.name("comment")).sendKeys("Send Data");
			driver.findElement(By.xpath("//input[@value='Confirm']")).click();
			Thread.sleep(1000);
			driver.switchTo().alert().accept();
			Thread.sleep(1000);
		}
		
		
		driver.quit();
	}
}