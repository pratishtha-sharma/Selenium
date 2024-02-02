package com.AutoIt;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class fileUpload {
	
	@Test
	public void uploadFile() throws InterruptedException, IOException {
		
		String downloadPath = System.getProperty("user.dir");
		//code to change the default download path of browser and configure it to project
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>(); 
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath);
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.ilovepdf.com/pdf_to_jpg");
		driver.findElement(By.cssSelector("#pickfiles")).click();
		Thread.sleep(2000);
		Runtime.getRuntime().exec("C:\\Users\\admin\\Desktop\\newFileUpload.exe");
		WebDriverWait expWait= new WebDriverWait(driver, Duration.ofSeconds(5));
		expWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Convert to JPG')]")));
		driver.findElement(By.xpath("//span[contains(text(), 'Convert to JPG')]")).click();
		
		expWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#pickfiles")));
		
		//check if the file is successfully downloaded and then delete the same
		File file = new File(downloadPath+"/Cypress Certificate_page-0001.jpg");
		if(file.exists()) {
			System.out.println("Downloaded file found");
			Assert.assertTrue(file.exists());
			
			if(file.delete()) {
				System.out.println("Downloaded file is deleted");
			}
			
		}
		
	}

}