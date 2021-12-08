import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class childWindow {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "F:\\Automation work\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://support.google.com/mail/answer/56256?hl=en");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@class='action-button']")).click();
		System.out.println("Title before opening another window");
        System.out.println(driver.getTitle());
        
        //get id of all the child windows
        Set<String> ids = driver.getWindowHandles();
        Iterator<String> it= ids.iterator();  // -----------> iterator
        String parentid = it.next();
        String childid = it.next();
        
        //switch to child window
        driver.switchTo().window(childid);
        System.out.println("Title after opening another window");
        System.out.println(driver.getTitle());
        
        //switch back to parent window
        driver.switchTo().window(parentid);
        System.out.println("Title after opening another window");
        System.out.println(driver.getTitle());
        
        //WebElement text = driver.findElement(By.xpath("//h3[contains(text(),'The username I want is taken')]"));  //rgba(32, 33, 36, 1)
        WebElement text = driver.findElement(By.xpath("//a[contains(text(),'Create an account ')]"));  //rgba(255, 255, 255, 1)
        String fontFamily = text.getCssValue("font-family");
        System.out.println("Font family of the given text is " + fontFamily);
        String fontWeight = text.getCssValue("font-weight");
        System.out.println("Font weight of the given text is " + fontWeight);
        String fontColor = text.getCssValue("color");
        System.out.println("Font color of the given text is " + fontColor);
        String fontSize = text.getCssValue("font-size");
        System.out.println("Font color of the given text is " + fontSize);
        
        Thread.sleep(4000);
        driver.quit();
		
	}

}
