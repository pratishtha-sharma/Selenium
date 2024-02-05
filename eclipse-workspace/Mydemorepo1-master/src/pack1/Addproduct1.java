
package pack1;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class Addproduct1 {
	public static void main(String[] args) throws Exception {
		String Url1 = "https://productdevelopment.projectstatus.in/";
		System.setProperty("webdriver.chrome.driver",
				"D:\\eclipse\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Load the website
		driver.get(Url1);
		driver.findElement(By.xpath("//input[@id=\"email\"]")).sendKeys("Singh.jeetendra@dotsquares.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Dots@123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//i[@class='icon-list-new-product']")).click();
		for (int i = 1; i < 15; i++) {
			String s1 = "Pname";
			String Pname = s1 + i;
			String s2 = "Psubtype";
			String Psubtype = s2 + i;
			String s3 = "Pquantity";
			String Pquantity = s3 + i;
			String s4 = "ppu";
			String ppu = s4 + i;
//String   s5="sp";
//String   sp=s5+i;
			String s6 = "Availq";
			String Availq = s6 + i;
			String s7 = "Finfo";
			String Finfo = s7 + i;
			driver.findElement(By.xpath("//input[@placeholder='Product Name']")).sendKeys(Pname);
			driver.findElement(By.xpath("//input[@placeholder='Product Sub Type']")).sendKeys(Psubtype);
			// sold by
//	 WebElement drp32=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/span[1]/span[1]/span[1]/span[1]"));
//	drp32.click();	
//	 Select dropdown1 = new Select(drp32);  
//	 dropdown1.deselectAll();
//		dropdown1.selectByVisibleText("Box");
			
			driver.findElement(By.xpath("//span[@class='select2-selection select2-selection--single']/span[contains(text(), 'Tray')]")).click();
			List<WebElement> soldBy = driver.findElements(By.xpath("//ul[@id='select2-sold_by-k6-results']/li[@class='select2-results__option']"));
			
			Thread.sleep(2000);
			for(i=0; i<soldBy.size(); i++) {
				String text = soldBy.get(i).getText();
				System.out.println("testttttt");
				//WebElement value = driver.findElement(By.cssSelector("#select2-sold_by-k6-result-2s3g-2.select2-results__option"));
				
				if(text.contains("Box")) {
					soldBy.get(i).click();
					break;
				}
			}
//		
			List<WebElement> webElements1 = driver.findElements(By.xpath(
					"/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/span[1]/span[1]/span[1]/span[1]"));

			/*for (WebElement webElement1 : webElements1) {

				if (webElement1.getAttribute("title").equals("Box"))

				{
					WebElement web1 = webElement1.findElement(By.className("selectboxit-text"));

					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].click();", web1);
				}
			}*/

			// Product Size
//		 WebElement drp33=driver.findElement(By.xpath("/html/body/div/div[1]/div[3]/div/div/div/div/form/div/div[3]/div/div/span/span[1]/span/span[1]"));
//			Select dropdown2 = new Select(drp33);  
//			dropdown2.selectByVisibleText("small");

			/*List<WebElement> drps1 = driver.findElements(By.xpath(
					"/html/body/div/div[1]/div[3]/div/div/div/div/form/div/div[3]/div/div/span/span[1]/span/span[1]"));

			for (WebElement webE1 : drps1) {
				if (webE1.getText().equalsIgnoreCase("Box")) {

					webE1.click();
					break;
				}
			}*/

//maturity
			/*WebElement drp34 = driver.findElement(By.xpath("//span[@id='select2-sold_by-3l-container']"));
			Select dropdown3 = new Select(drp34);
			dropdown3.selectByVisibleText("0.25");
			// product class
			WebElement drp35 = driver.findElement(By.xpath("//span[@id='select2-sold_by-3l-container']"));
			Select dropdown4 = new Select(drp35);
			dropdown4.selectByVisibleText("2");

			driver.findElement(By.xpath("//input[@id='unit_weight_input']")).sendKeys(Pquantity);
			WebElement drp36 = driver.findElement(By.xpath("//span[@id='select2-sold_by-3l-container']"));
			Select dropdown5 = new Select(drp36);
			dropdown5.selectByVisibleText("Grams");
			driver.findElement(By.xpath("//input[@id='price_input']")).sendKeys(Pname);
			driver.findElement(By.xpath("//input[@id='price_input']")).sendKeys(ppu);
			// driver.findElement(By.xpath("//input[@id='selling_price_input']")).sendKeys(sp);
			driver.findElement(By.xpath("//input[@placeholder='Available Quantity']")).sendKeys(Availq);
			driver.findElement(By.xpath("//input[@placeholder='Further Information']")).sendKeys(Finfo);
			WebElement drp37 = driver.findElement(By.xpath("//span[@id='select2-sold_by-3l-container']"));
			Select dropdown6 = new Select(drp37);
			dropdown6.selectByVisibleText("In a week");
			driver.findElement(By.xpath("//input[@value='Add Product ']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[@class='add-new-btn']//a[@class='btn green-btn-outline']")).click();*/
		}

	}
}
