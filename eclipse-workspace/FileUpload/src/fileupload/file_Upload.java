package fileupload;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class file_Upload {
	
	WebDriver driver;
	String downloadPath;
	
	@BeforeTest
	public void openBrowser() {
		downloadPath = System.getProperty("user.dir");
		
		System.setProperty("webdriver.chrome.driver", "D:\\eclipse\\chromedriver_win32\\chromedriver.exe");
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();

		chromePrefs.put("profile.default_content_settings.popups", 0);

		chromePrefs.put("download.default_directory", downloadPath);

		ChromeOptions options=new ChromeOptions();

		options.setExperimentalOption("prefs", chromePrefs);

		driver=new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	
	@Test
	public void uploadFile() throws IOException, InterruptedException {
		driver.get("https://smallpdf.com/word-to-pdf");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@type='button' and @class='l3tlg0-0 hrcxSS']")).click();
		Thread.sleep(3000);
		
		WebElement box = driver.findElement(By.xpath("//div[@class='rplgd-0 iIYnHi']"));
		if (box.isDisplayed()) {
			driver.findElement(By.xpath("//span[contains(text(),'Got it')]")).click();
		}
		
		//Upload file
		Runtime.getRuntime().exec("C:\\Users\\admin\\Documents\\fileUpload.exe");
		WebElement downloadButton = driver.findElement(By.xpath("//span[contains(text(),'Download')]"));
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(downloadButton));
		
		downloadButton.click();
		
		// to check if the file is downloaded successfully
		
		Thread.sleep(5000);
		File f = new File(downloadPath+"\\converted.pdf");
		
		if(f.exists()) {
			Assert.assertTrue(f.exists());

			if(f.delete())

			System.out.println("file deleted");

			}
		}
		
	

}
