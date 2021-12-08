import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class select_class {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.spicejet.com");
		

		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(3000L);

		driver.findElement(By.id("hrefIncAdt")).click();

		driver.findElement(By.id("hrefIncChd")).click();
		driver.findElement(By.id("btnclosepaxoption")).click();

		
		Select s= new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		//s.selectByValue("AED");
		//Thread.sleep(1000);
		s.selectByIndex(3);
		//s.selectByVisibleText("INR");
		
		
	}

}
