import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;



public class checkbox_assignment {



public static void main(String[] args) throws InterruptedException {

// TODO Auto-generated method stub

System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");

WebDriver driver= new ChromeDriver();

driver.get("http://qaclickacademy.com/practice.php");

driver.manage().window().maximize();

System.out.println(driver.findElement(By.xpath("//input[@value='option1']")).isSelected());

driver.findElement(By.xpath("//input[@value='option1']")).click();

System.out.println(driver.findElement(By.xpath("//input[@value='option1']")).isSelected());

Thread.sleep(2000);

driver.findElement(By.xpath("//input[@value='option1']")).click();

System.out.println(driver.findElement(By.xpath("//input[@value='option1']")).isSelected());



}



}

