package pageObject;

import java.util.List;

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
	
	@FindBy(xpath="//h2[contains(text(),'Featured Courses')]")
	WebElement Title;
	public WebElement getTitle() {
		return Title;
	}
	
	@FindBy(css="ul[class='nav navbar-nav navbar-right']")
	WebElement Nav;
	public WebElement getNavBar() {
		return Nav;
	}
	
	@FindBy(css="input[id='user_email']")
	WebElement email;
	public WebElement getEmail() {
		return email;
	}
	
	@FindBy(css="input[id='user_password']")
	WebElement password;
	public WebElement getPassword() {
		return password;
	}
	
	@FindBy(css="input[type='submit']")
	WebElement submit;
	public WebElement Login() {
		return submit;
	}
	
	@FindBy(xpath="//div[@class='sumome-react-wysiwyg-move-handle']//div[1]//img")
	List<WebElement> popup;
	public int getPopupsize() {
		return popup.size();
	}
	
	@FindBy(xpath="//button[contains(text(),'NO THANKS')]")
	WebElement close;
	public WebElement closePopup() {
		return close;
	}

}
