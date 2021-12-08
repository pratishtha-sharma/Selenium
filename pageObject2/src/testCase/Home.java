package testCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import objectRepository.rediffHOMEPageObjFactory;
import objectRepository.rediffLOGINPage;


 class Login
 {
	 static WebDriver driver;
	 public void setup()
		{
			System.setProperty("webdriver.chrome.driver","F:\\Automation work\\chromedriver_win32 (1)\\chromedriver.exe");
			driver =new ChromeDriver();
			driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
			driver.manage().window().maximize();
		}
	public void LoginPage()
	{
	
		rediffLOGINPage rd =  new rediffLOGINPage(driver);
		
		rd.Email().sendKeys("abc@mailinator.com");
		rd.Password().sendKeys("123456a");
		//rd.Submit().click();
		rd.Home().click();
	}
	
	public void HomePage()
	{        		
        rediffHOMEPageObjFactory rh = new rediffHOMEPageObjFactory(driver);
		
		rh.Search().sendKeys("Bags");
		rh.Submit().click();
		
	}
	
 }

public class Home {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Login log = new Login();
		log.setup();
		log.LoginPage();
		log.HomePage();
		
		
		
		
		
	}
	

}
