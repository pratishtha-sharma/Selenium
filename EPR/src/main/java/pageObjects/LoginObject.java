package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginObject {
	
	WebDriver driver;
	
	public LoginObject(WebDriver driver) {
        this.driver = driver;
	}
	
	By username = By.id("Email");
	public WebElement Email() {
		return driver.findElement(username);
	}
	
	By password = By.id("Password");
	public WebElement Password() {
		return driver.findElement(password);
	}
	
	By submit = By.id("btn-login");
	public WebElement SignIn() {
		return driver.findElement(submit);
	}
	
	By confirm = By.xpath("//div[contains(text(),'Confirmation')]");
	public WebElement Hippa(){
		return driver.findElement(confirm);	
	}
	
	By ok = By.xpath("//button[contains(text(),'OK')]");
	public WebElement closeHippa(){
		return driver.findElement(ok);	
	}
	

}
