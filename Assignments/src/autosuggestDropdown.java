import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class autosuggestDropdown {



public static void main(String[] args) throws InterruptedException {

// TODO Auto-generated method stub

System.setProperty("webdriver.chrome.driver", "F:\\Automation work\\chromedriver_win32 (1)\\chromedriver.exe");

WebDriver driver = new ChromeDriver();

driver.get("http://qaclickacademy.com/practice.php");

driver.manage().window().maximize();

WebElement country = driver.findElement(By.id("autocomplete"));

country.sendKeys("uni");

JavascriptExecutor js = (JavascriptExecutor) driver;

String countryName = "return document.getElementById(\"autocomplete\").value;";

        String text = (String) js.executeScript(countryName);

       

        while(!text.equalsIgnoreCase("united states"))

        {

        country.sendKeys(Keys.ARROW_DOWN);

        text = (String) js.executeScript(countryName);

        }



        Thread.sleep(3000);

        country.sendKeys(Keys.ENTER);

       

        System.out.println(text);

       

        driver.quit();

}



}

