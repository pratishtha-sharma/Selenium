import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ParentChild {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("http://google.com");
		//driver.findElement(By.xpath("//div[@class='RNNXgb']/div/div[1]/input")).sendKeys("Google chrome"); //for google search
	    driver.findElement(By.xpath("//div[@class='SDkEP']/div/input")).sendKeys("Google chrome");

	}

}
