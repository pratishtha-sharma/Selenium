import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;



public class frames_assignment {



public static void main(String[] args) {

// TODO Auto-generated method stub

System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");

WebDriver driver = new ChromeDriver();

driver.get("http://the-internet.herokuapp.com/");

driver.manage().window().maximize();

driver.findElement(By.xpath("//a[contains(text(),'Nested Frames')]")).click();

//System.out.println(driver.findElements(By.tagName("frameset")).size());

//switch to frame

driver.switchTo().frame("frame-top");

driver.switchTo().frame("frame-middle");

//grab middle text

        System.out.println(driver.findElement(By.cssSelector("#content")).getText());

       

        //switch back to default

        driver.switchTo().defaultContent();

driver.close();



}



}

