package chromebrowser;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Amazon {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

	  System.setProperty("webdriver.chrome.driver", "E:\\ChromeDriver\\ChromeDriver2.46\\chromedriver.exe");

	  driver=new ChromeDriver();

	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	  driver.get("https://www.amazon.in/");

	  driver.manage().window().maximize();

	      System.out.println(driver.getTitle());

	  //define the action class and passed driver object

	      Select s = new Select(driver.findElement(By.id("searchDropdownBox")));

	      s.selectByValue("search-alias=aps");

	      driver.findElement(By.id("twotabsearchtextbox")).sendKeys("perfume");

	      driver.findElement(By.cssSelector("[value='Go']")).click();

	      System.out.println("Test passed");	     

	          driver.findElement(By.xpath("//*[contains(text(),'The Man Company Non-Gas Body Perfume for Men, Bleu, 120ml')]")).click();

	         Thread.sleep(5000);

	          Set<String> ids=driver.getWindowHandles();

	  Iterator<String> it=ids.iterator();

	  String parentid=it.next();

	  String childid=it.next();

	  driver.switchTo().window(childid);

	          driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();

	      System.out.println("item added to cart");

	      WebDriverWait d=new WebDriverWait(driver,10);

	      d.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//a[contains(text(),'Proceed to Buy (1 item)')])[1]")));

	      driver.findElement(By.xpath("(//a[contains(text(),'Proceed to Buy (1 item)')])[1]")).click();	     

	     // (//a[contains(text(),'Proceed to Buy (1 item)')])[1]

	}

}
