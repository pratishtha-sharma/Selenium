import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class actionClass {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
//		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.26.0-win64\\geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();
		
		System.setProperty("webdriver.chrome.driver", "F:\\Automation work\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		
		driver.get("https://www.myntra.com/");
		Actions a = new Actions(driver);
		WebElement e=  driver.findElement(By.xpath("//a[contains(text(),'Women')]"));
		
		a.moveToElement(e).build().perform(); //hover
		Thread.sleep(3000);
		a.moveToElement(e).contextClick().build().perform(); //right click
		Thread.sleep(3000);
		a.moveToElement(driver.findElement(By.cssSelector("input[class='desktop-searchBar']"))).click().keyDown(Keys.SHIFT).sendKeys("shirts").doubleClick().build().perform();
		


		Thread.sleep(5000);
		driver.quit();
	}

}
