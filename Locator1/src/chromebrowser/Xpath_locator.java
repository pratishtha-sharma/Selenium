package chromebrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Xpath_locator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("9680424428");
		driver.findElement(By.id("pass")).sendKeys("Shradha07P");
		//driver.findElement(By.cssSelector("#.inputtext.ckpass_detect_item.ckpass_pass_linkpass")).sendKeys("Shradha07P");
		//driver.findElement(By.xpath("//*[@id=\"u_0_2\"]")).click();  //*[@id="u_0_a"] xpath of login button (convert the double quotes in single in xpath as java do not accept double quotes inside double quotes)
		driver.findElement(By.xpath("//input[@aria-label='Log In']")).click(); //---> //input[@value='Log In'] --> by trainer



		//driver.findElement(By.linkText("Forgotten account?")).click();  //*[@id="login_form"]/table/tbody/tr[3]/td[2]/div/a
		//driver.findElement(By.xpath("//*[@id=\"login_form\"]/table/tbody/tr[3]/td[2]/div/a")).click();
		System.out.println("Login Success");

		
		//driver.close();  
	}
  
}
