package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class rediffLOGINPage {
	
	//PageObject Pattern

	WebDriver driver;
	
	public rediffLOGINPage(WebDriver driver) {
           this.driver = driver;
	}
	
	By username = By.xpath("//input[@id='login1']");
	By password = By.name("passwd");
	By submit = By.name("proceed");
	By home = By.linkText("rediff.com");
	
	
	public WebElement Email()
	{
		return driver.findElement(username);
	}
	
	
	public WebElement Password()
	{
		return driver.findElement(password);
	}
	
	public WebElement Submit()
	{
		return driver.findElement(submit);
	}
	
	public WebElement Home()
	{
		return driver.findElement(home);
	}

	
	
	
}
