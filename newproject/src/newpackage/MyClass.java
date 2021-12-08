package newpackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyClass {
	
	public static void main(String[] args) {
  //selenium code-
		
		//Create driver object for chrome browser
		//implement methods of webdriver
		//invoke web broSystem.out.printlnwser .exe file
		
		/*Class name=X
				X driver= new X(); */
	//
		
	   System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
   	   WebDriver driver = new ChromeDriver();
	   driver.get("https://www.google.com");     /*to hit url in browser*/
	   System.out.println(driver.getTitle());    /*get title*/
   	    
       System.out.println(driver.getCurrentUrl());  // to verify if we landed on correct page
         
        // System.out.println(driver.getPageSource());  // to get page source
	   
	  //   driver.get("https://www.slack.com");
	    // driver.navigate().back(); //navigate back  to google.com automatically
	    // driver.navigate().forward(); //navigate forward
	     
	     
	   //  driver.close(); //close current driver
	     //driver.quit(); //close all browser opened by selenium
	   
		
	}
}
