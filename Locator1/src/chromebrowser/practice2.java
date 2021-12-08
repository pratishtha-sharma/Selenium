package chromebrowser;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class practice2 {

	static WebDriver driver;

	public static void main(String[] args) throws IOException {

	System.setProperty("webdriver.chrome.driver","C:\\\\chromedriver_win32\\\\chromedriver.exe");

	driver = new ChromeDriver();

	//driver.manage().window().maximize();

	driver.get("https://google.com/");

	System.out.println(driver.getTitle());

	driver.findElement(By.xpath("//input[@name='q']")).click();

	driver.findElement(By.xpath("//input[@name='q']")).sendKeys("JAVA");

	driver.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.ENTER);



	List<WebElement> links =   driver.findElements(By.xpath("//*[@id=\"resultStats\"]"));

	int count = links.size();

	System.out.println(count);

	for (int i =0;i<count;i++) {

	//String linkname = driver.findElements(By.xpath("//*[@id='res']//a/h3")).get(i).getText();
	String linkname = driver.findElements(By.xpath("//div[contains(@id,'res')]")).get(i).getText();

	System.out.println(linkname);
	
	}
   
	driver.findElement(By.xpath("//div[@class='ellip']")).click();
	System.out.println(driver.getTitle());
	
	}


}
