package chromebrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class practice1 {



public static void main(String[] args) throws InterruptedException {

	System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");

    WebDriver driver = new ChromeDriver();

    driver.get("https://www.ichangemycity.com/");

   driver.manage().window().maximize();

   System.out.println(driver.getTitle());

   driver.findElement(By.xpath("//input[@placeholder='Search for a city']")).click();

   driver.findElement(By.xpath("//input[@placeholder='Search for a city']")).sendKeys("Bangalore");

   //driver.findElement(By.xpath("//a[contains(text(),'Bangalore')]")).click();  //*[@id="modalCities"]/div/div/div[2]/div/ul[2]/li[1]/a
   driver.findElement(By.xpath("//*[@id=\"modalCities\"]/div/div/div[2]/div/ul[2]/li[1]/a")).click();  //*[@id="modalCities"]/div/div/div[2]/div/ul[2]/li[1]/a 
   
  Thread.sleep(4000);

   driver.findElement(By.xpath("//a[contains(text(),'sign in')]")).click();

}

}
