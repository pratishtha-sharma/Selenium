package testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import objectRepository.rediffHOMEPageObjFactory;
import objectRepository.rediffLOGINPage;

public class LoginApplication {
	
	//Login class is done with PageObject pattern
	//Home page is done using PageObjectFactory Method

	@Test
	public void Login()
	{
		System.setProperty("webdriver.chrome.driver","F:\\Automation work\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.manage().window().maximize();
		
		rediffLOGINPage rd =  new rediffLOGINPage(driver);
		rd.Email().sendKeys("abc@mailinator.com");
		rd.Password().sendKeys("123456a");
		//rd.Submit().click();
		rd.Home().click();
		
		rediffHOMEPageObjFactory rh = new rediffHOMEPageObjFactory(driver);
		rh.Search().sendKeys("Bags");
		rh.Submit().click();
		
		
	}
}
