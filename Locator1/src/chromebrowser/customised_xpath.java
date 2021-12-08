package chromebrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class customised_xpath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//*[@type='email']")).sendKeys("9680424428"); // ----> //*[@attribute='value']
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("Shradha07P");
		
		driver.findElement(By.xpath("//input[@value='Log In']")).click(); // xpath syntax ---> //tagname[@attribute='value']		
		driver.close();  
	}

}
