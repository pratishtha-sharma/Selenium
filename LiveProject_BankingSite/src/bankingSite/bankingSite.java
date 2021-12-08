package bankingSite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class bankingSite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//System.setProperty("webdriver.chrome.driver", "F:\\Automation work\\chromedriver_win32 (1)\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "F:\\Automation work\\geckodriver-v0.27.0-win64\\geckodriver.exe");
		//WebDriver driver = new ChromeDriver();
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://www.demo.guru99.com/V4/");
		driver.manage().window().maximize();
		
		//verify login details
//		driver.findElement(By.name("uid")).sendKeys("mngr240373");
//		driver.findElement(By.name("password")).sendKeys("qAsupep");
//		
//		driver.findElement(By.name("btnLogin")).click();

		//get url after login
		driver.getCurrentUrl();

	}

}
