package chromebrowser;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class amazon_practice {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		 System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.amazon.in/");
		//driver.findElement(By.xpath("//a[@id='nav-link-accountList']")).click();
		driver.findElement(By.cssSelector("a[id='nav-link-accountList']")).click();
		
		//driver.findElement(By.cssSelector("[id='ap_email']")).sendKeys("9352503964");
		driver.findElement(By.cssSelector("input#ap_email")).sendKeys("9352503964");
		
        driver.findElement(By.cssSelector("input#continue.a-button-input")).click();
		//driver.findElement(By.cssSelector("input.a-button-input")).click();
        /*driver.findElement(By.linkText("Forgot Password")).click();
        driver.navigate().back(); */
        driver.findElement(By.cssSelector("#ap_password")).sendKeys("Prakhar123*");
        driver.findElement(By.xpath("//*[@id='remember_me_learn_more_link']")).click();
        driver.findElement(By.xpath("//i[@class='a-icon a-icon-close']")).click();
        //driver.findElement(By.xpath("//i[contains(@class,'a-icon')]")).click();
        //driver.findElement(By.cssSelector(("[name='rememberMe']"))).click();
        driver.findElement(By.xpath(("//input[@name='rememberMe']"))).click();
        Thread.sleep(2500);
		driver.findElement(By.cssSelector("input#signInSubmit")).click();
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).click();
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("mobiles");
		
		driver.findElement(By.xpath("//input[@class='nav-input']")).click();
		driver.findElement(By.xpath("//img[@alt='Redmi 7 (Comet Blue, 3GB RAM, 32GB Storage)']")).click();
             //driver.findElement(By.xpath("//div[@id='altImages']/ul/li[5]/span[1]/span[1]/span[1]/input[1]")).click(); 
		     //driver.findElement(By.xpath("//span[text()='2GB RAM']")).click();

		
		 Set<String> ids=driver.getWindowHandles();

		 java.util.Iterator<String> it=ids.iterator();

		 String parentid=it.next();

		 String childid=it.next();

		 driver.switchTo().window(childid);

		 JavascriptExecutor js = (JavascriptExecutor) driver;

		 js.executeScript("window.scrollBy(0,500)");

		 Thread.sleep(2500);

		 driver.findElement(By.xpath("//div[@class='twisterTextDiv text']//span[text()='2GB RAM']")).click();

		 System.out.println(driver.findElement(By.xpath("//div[@class='twisterTextDiv text']//span[text()='2GB RAM']")).getText());
		
		
		
		//Thread.sleep(3000);
		driver.close();
	}

}
