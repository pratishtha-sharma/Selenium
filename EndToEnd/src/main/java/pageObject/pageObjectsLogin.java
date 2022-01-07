package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pageObjectsLogin {
	
	public WebDriver driver;
	
	public pageObjectsLogin(WebDriver driver) {
		
		this.driver= driver;
		PageFactory.initElements(driver, this); //testcase argument driver initialize to local drier object "this"
	}
	
	@FindBy(xpath="//h2[conains(text(),'Featured Courses')]")
	WebElement Title;
	
	public WebElement getTitle() {
		return Title;
	}
	
	@FindBy(css="ul[class='navigation clearfix']")
	WebElement Nav;
	
	public WebElement getNavBar() {
		return Nav;
	}

}