package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pageObjectsHome {
	
	public WebDriver driver;
	
	public pageObjectsHome(WebDriver driver) {
		
		this.driver= driver;
		PageFactory.initElements(driver, this); //testcase argument driver initialize to local drier object "this"
	}
	
	@FindBy(css="a[hreff='sign_in']")
	WebElement Login;
	
	public WebElement getLogin() {
		return Login;
	}

}