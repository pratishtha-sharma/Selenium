package chromebrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class css_locator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
//		driver.manage().window().maximize();

		driver.findElement(By.cssSelector("input#email.inputtext")).sendKeys("test"); //can also use #email. Working with #email also.
		driver.findElement(By.cssSelector("input#pass.inputtext")).sendKeys("123456"); //can also use #pass
		//driver.findElement(By.linkText("Forgotten account?")).click();
		//driver.findElement(By.xpath("//*[@id=\"login_form\"]/table/tbody/tr[3]/td[2]/div/a")).click(); //forgot account xpath
		
		//driver.findElement(By.cssSelector(".inputtext.ckpass_detect_item.ckpass_pass_linkpass")).sendKeys("test");
		
		//driver.findElement(By.cssSelector("label[id='loginbutton']>input")).click(); //cssSelector of login button as given by trainer
		driver.findElement(By.cssSelector("label#loginbutton.uiButton.uiButtonConfirm")).click();
		System.out.println(driver.findElement(By.xpath("//*[@id=\"globalContainer\"]/div[3]/div/div/div")).getText());
		
		//System.out.println("Login Success");

		
		//driver.close();  
	} 

  
}
