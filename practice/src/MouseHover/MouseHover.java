package MouseHover;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "F:\\Automation work\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.spicejet.com/");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		Actions a = new Actions(driver);

		WebElement addons = driver.findElement(By.xpath("//a[contains(text(),'Add-Ons')]"));
		
		a.moveToElement(addons).build().perform();

		//driver.findElement(By.xpath("//a[@href='ExtraSeat.aspx']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Extra Seat')]")).click();
		//driver.findElement(By.linkText("Extra Seat")).click();
		
		
		
		
		
		driver.quit();

	}

}
