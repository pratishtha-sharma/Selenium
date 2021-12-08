import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;



public class explicitWait {



public static void main(String[] args) {

// TODO Auto-generated method stub

System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");

WebDriver driver = new ChromeDriver();

driver.get("http://www.itgeared.com/demo/1506-ajax-loading.html");

driver.manage().window().maximize();

WebDriverWait w = new WebDriverWait(driver , 5);

//click on "Click to load get data via Ajax!"

driver.findElement(By.linkText("Click to load get data via Ajax!")).click();

w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#results")));

System.out.println(driver.findElement(By.xpath("//div[@id='results']")).getText());



      driver.quit();



}



}

