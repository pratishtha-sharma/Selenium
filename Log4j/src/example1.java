import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class example1 {
	
    private static Logger log = LogManager.getLogger(example1.class.getName());
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		log.debug("Setting up the chrome for selenium");
		System.setProperty("webdriver.chrome.driver","F:\\Automation work\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		
		log.info("Chrome has been opened.");
		driver.get("https://www.amazon.in/");
		log.debug("Hitting the amazon website.");
		
		driver.manage().window().maximize();
		log.info("Window has been maximized");
		
		Actions act = new Actions(driver);
		log.debug("Entering data in search bar");
		act.moveToElement(driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"))).click().keyDown(Keys.SHIFT).sendKeys("mobile").doubleClick().build().perform();
		Thread.sleep(2000);
		
		act.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Best Sellers')]"))).contextClick().build().perform();
		log.info("Right click done");
		
		driver.close();
		
		
	}

}
