package chromebrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class chromebrowser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("9680424428");
		driver.findElement(By.name("pass")).sendKeys("Shradha07P");
		//driver.findElement(By.id("u_0_a")).click();
		//driver.findElement(By.linkText("Forgotten account?")).click();
		
		//driver.close();  
	}

}
