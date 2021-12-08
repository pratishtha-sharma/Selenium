package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class rediffHOMEPageObjFactory {
	
	//PageObjectFactory Pattern

	WebDriver driver;
	
	public rediffHOMEPageObjFactory(WebDriver driver) {
           this.driver = driver;
           PageFactory.initElements(driver, this); //Initialize the page factory method when we are using the FindBy Annotation.
	}
	
//	By search = By.id("srchword");
//	By submit = By.xpath("//input[@type='submit']");
	
	
	//@FindBy annotation is used in place of By keyword and driver.FindElement  to find the locator of element
	
	@FindBy(id="srchword")
	WebElement search;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement submit;
	
	public WebElement Search()
	{
		return search;
	}
	
	public WebElement Submit()
	{
		return submit;
	}
	

	
	
	
}
