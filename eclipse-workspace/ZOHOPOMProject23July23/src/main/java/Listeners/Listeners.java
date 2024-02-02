package Listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;


public class Listeners extends AbstractWebDriverEventListener {
	
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Before finding: "+by);
		System.out.println("Before finding: "+element);
		System.out.println("Before finding: "+driver);
	}

}
