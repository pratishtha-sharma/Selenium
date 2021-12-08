package chromebrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class customised_css {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.cssSelector("input[type='email']")).sendKeys("9680424428"); //css syntax ---> tagname[attribute='value']
		//driver.findElement(By.cssSelector("input#pass")).sendKeys("Shradha07P"); // tagname#value
	    driver.findElement(By.cssSelector("#pass")).sendKeys("Shradha07P"); // #value / #id
//		driver.findElement(By.cssSelector(".inputtext")).sendKeys("Shradha07P"); // #value
		
		driver.findElement(By.cssSelector("[value=\"Log In\"]")).click(); // css syntax ---> [attribute='value']		
		driver.close();  
	}

}
 