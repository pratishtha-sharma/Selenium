package scope;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class scope {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
//		System.setProperty("webdriver.chrome.driver", "F:\\Automation work\\chromedriver_win32 (1)\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.gecko.driver","F:\\Automation work\\geckodriver-v0.26.0-win64\\GeckoDriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://qaclickacademy.com/practice.php");
		driver.manage().window().maximize();
		
		System.out.println(driver.findElements(By.tagName("a")).size()); // ==> total links in the page
		
		WebElement footerDriver = driver.findElement(By.id("gf-BIG")); //  =====> limiting the scope to footer only
		System.out.println(footerDriver.findElements(By.tagName("a")).size());
		
		//to find number of links in one column of the footer
		WebElement columnFooter = driver.findElement(By.xpath("//div[@id='gf-BIG']/table/tbody/tr/td[1]/ul")); //  =====> limiting the scope to one column in footer only
		System.out.println(columnFooter.findElements(By.tagName("a")).size());
		
		for(int i =1 ; i< columnFooter.findElements(By.tagName("a")).size() ; i++) // open all the tabs.
		{
			String select = Keys.chord(Keys.CONTROL , Keys.ENTER);
			columnFooter.findElements(By.tagName("a")).get(i).sendKeys(select);
			 Thread.sleep(5000L);
			 
		}
			
             //Actions click = new Actions(driver);
            //click.keyDown(Keys.CONTROL).sendKeys(Keys.ENTER).build().perform();
			
			Set<String> ids = driver.getWindowHandles();
			Iterator<String> it = ids.iterator();

			while(it.hasNext()) 
			{
				driver.switchTo().window(it.next());
				System.out.println(driver.getTitle());
				
			}
			
			driver.quit();
			
		}
		

	}



