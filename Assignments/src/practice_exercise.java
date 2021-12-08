import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class practice_exercise {



public static void main(String[] args) throws InterruptedException {

// TODO Auto-generated method stub

       System.setProperty("webdriver.chrome.driver", "F:\\Automation work\\chromedriver_win32 (1)\\chromedriver.exe");

      WebDriver driver = new ChromeDriver();

      driver.get("http://qaclickacademy.com/practice.php");

      driver.manage().window().maximize();
      Thread.sleep(1000);

      driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[2]/input")).click();

      String name = driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[2]")).getText();
      
      Thread.sleep(3000);
      
      Select s = new Select(driver.findElement(By.id("dropdown-class-example")));
      s.selectByVisibleText(name);
      
      Thread.sleep(2000);
      
      driver.findElement(By.id("name")).sendKeys(name);
      driver.findElement(By.id("alertbtn")).click();
      
      String name1 = driver.switchTo().alert().getText();
      driver.switchTo().alert().accept();
      
      if(name1.contains(name))
      {
    	  System.out.println("Test has passed");
      }
      else
      {
    	  System.out.println("Test has failed");
      }
       

        driver.quit();

}



}

