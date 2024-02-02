package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginObject {
	
	WebDriver driver;
	
	public LoginObject(WebDriver driver) {
        this.driver = driver;
	}
	
	private By signout = By.xpath("//div[@class='head-dash-right ml-auto pull-right']//a[@class='log-link']");
	public WebElement Logout() {
		return driver.findElement(signout);
	}
	
	private By username = By.id("Email");
	public WebElement Email() {
		return driver.findElement(username);
	}
	
	private By password = By.id("Password");
	public WebElement Password() {
		return driver.findElement(password);
	}
	
	private By submit = By.id("btn-login");
	public WebElement SignIn() {
		return driver.findElement(submit);
	}
	
	private By confirm = By.xpath("//div[contains(text(),'Confirmation')]");
	public WebElement Hippa(){
		return driver.findElement(confirm);	
	}
	
	private By ok = By.xpath("//button[contains(text(),'OK')]");
	public WebElement closeHippa(){
		return driver.findElement(ok);	
	}
	

}
