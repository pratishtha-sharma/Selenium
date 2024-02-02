
	package pack1;


	import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

	public class Bidflow1 { 
		static String DraddressC="D:\\eclipse\\chromedriver_win32\\chromedriver.exe";
	    static String DraddressF="D:\\eclipse\\gecko driver\\geckodriver.exe";	
	
	   
	public static void main(String[] args) throws Exception {
		String   Url1="https://productdevelopment.projectstatus.in/";
		 System.setProperty("webdriver.chrome.driver", DraddressC);
		// System.setProperty("webdriver.gecko.driver", DraddressF);
		    //WebDriver driver1=new FirefoxDriver();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			// Load the website
			driver.get(Url1);
			driver.findElement(By.xpath("//input[@id=\"email\"]")).sendKeys("s.jdotsquares@gmail.com");
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Dots@123");
			driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div/div[2]/div[2]/button")).click();
			driver.findElement(By.xpath("/html/body/div/div[1]/div[3]/div/div/div[1]/a/div")).click();
			driver.findElement(By.xpath("//input[@placeholder='Enter Product Name']")).sendKeys("Allen product");
            Thread.sleep(1000);
		//	driver.findElement(By.xpath("//input[@value='Filter ']")).click();
			driver.findElement(By.xpath("//*[@id=\"product_bid_btn_69\"]")).click();
			driver.findElement(By.xpath("//input[@id='bid_quantity']")).sendKeys("2");
			driver.findElement(By.xpath("//input[@id='bid_price']")).sendKeys("20");
			driver.findElement(By.xpath("//button[@id='place_bid_btn']")).click();
			sellerbid();
			driver.findElement(By.xpath("//footer[@class='footer']//li[1]//a[1]")).click();
			driver.findElement(By.xpath("//input[@placeholder='Enter Product Name']")).sendKeys("NewSP1");
			driver.findElement(By.xpath("//tr[@id='bid_162']//a[@id='product_bid_btn']")).click();
			driver.findElement(By.xpath("//input[@id='bid_price']")).sendKeys("30");
			driver.findElement(By.xpath("//button[@id='place_bid_btn']")).click();
			sellerbid();
			
	}
	public static  void sellerbid() throws InterruptedException {
		String   Url1="https://productdevelopment.projectstatus.in/";
		 System.setProperty("webdriver.gecko.driver", DraddressF);
		    WebDriver driver1=new FirefoxDriver();
		    driver1.manage().window().maximize();
		    driver1.get(Url1);
driver1.findElement(By.xpath("//input[@id=\"email\"]")).sendKeys("Singh.jeetendra@dotsquares.com");
driver1.findElement(By.xpath("//input[@id='password']")).sendKeys("Dots@123");
driver1.findElement(By.xpath("//button[@type='submit']")).click();

driver1.findElement(By.xpath("//footer[@class='footer']//li[1]//a[1]")).click();
driver1.findElement(By.xpath("//input[@placeholder='Enter Product Name']")).sendKeys("NewSP1");
driver1.findElement(By.xpath("//tr[@id='bid_162']//a[@id='product_bid_btn']")).click();
driver1.findElement(By.xpath("//input[@id='bid_price']")).sendKeys("30");
driver1.findElement(By.xpath("//button[@id='place_bid_btn']")).click();
driver1.findElement(By.xpath("//*[@id=\"dropdownMenuButton\"]/div/span")).click();
driver1.findElement(By.xpath("/html/body/div/header/div/div/div[2]/div[1]/div/a[5]/span")).click();
Thread.sleep(1000);
}
		
	public static void logout() {
		
		String   Url1="https://productdevelopment.projectstatus.in/";
		 System.setProperty("webdriver.gecko.driver", DraddressF);
		WebDriver driver1=new FirefoxDriver();
		    driver1.manage().window().maximize();
		    driver1.get(Url1);
		    driver1.findElement(By.xpath("//*[@id=\"dropdownMenuButton\"]/div/span")).click();
		    driver1.findElement(By.xpath("/html/body/div/header/div/div/div[2]/div[1]/div/a[5]/span")).click();

	
		}
	}
