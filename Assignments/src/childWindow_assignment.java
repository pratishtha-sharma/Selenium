import java.util.Iterator;

import java.util.Set;



import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;



public class childWindow_assignment {



public static void main(String[] args) throws InterruptedException {

// TODO Auto-generated method stub

System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");

WebDriver driver = new ChromeDriver();

driver.get("http://the-internet.herokuapp.com/");

driver.manage().window().maximize();

JavascriptExecutor js = (JavascriptExecutor) driver;

js.executeScript("window.scrollBy(0,800)");

Thread.sleep(3000);

driver.findElement(By.xpath("//a[contains(text(),'Multiple Windows')]")).click();

driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();

System.out.println("Title before opening other window ==> " + driver.getTitle());

Thread.sleep(5000);

//get id of all the child windows

Set<String> ids = driver.getWindowHandles();

Iterator<String> it = ids.iterator();

String parentid = it.next();

String childid = it.next();

//switch to child window

driver.switchTo().window(childid);

System.out.println("Title after opening another window ==> " + driver.getTitle());

System.out.println("Text in new window ==> " + driver.findElement(By.xpath("//h3[contains(text(),'New Window')]")).getText());

Thread.sleep(2000);

//switch back to parent window

driver.switchTo().window(parentid);

System.out.println("Text in parent window ==> " + driver.findElement(By.xpath("//h3[contains(text(),'Opening a new window')]")).getText());



}



}

