package myteam11pkg;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class myteam11 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications"); // to close the chrome notification pop up

		System.setProperty("webdriver.chrome.driver", "F:\\Automation work\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize(); //maximize window
		driver.manage().deleteAllCookies(); // delete all the cookies

		driver.get("https://www.myteam11.com/fantasy-sports/landing");
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		//login
		driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
		//driver.findElement(By.xpath("//input[@class='form-control ng-pristine ng-invalid filed-error ng-touched']")).sendKeys("8005648871");
		driver.findElement(By.name("mobile")).sendKeys("9460094455");
		Thread.sleep(3000);

		//click on send otp button
		driver.findElement(By.xpath("//button[contains(text(),'SEND OTP')]")).click();

		//get otp. prompting user to enter otp using JoptionPane Once the user enters the displayed otp and clicks ‘OK'
		String otp = JOptionPane.showInputDialog("Please enter the otp value:");
		//Type the entered otp to the text box
		driver.findElement(By.xpath("//div[@class='otpBox']/div/input[@name='a']")).sendKeys(otp);

		//click on verify otp
		driver.findElement(By.xpath("//button[contains(text(),'Verify OTP')]")).click();

		driver.findElement(By.xpath("//a[contains(text(),'Skip')]")).click();

		//click on the match
		driver.findElement(By.xpath("//div[@class='match-data' and @data-step='3']/div[@class='matchinside']")).click();
		Thread.sleep(1000);
		//click on create team
		driver.findElement(By.xpath("//span[contains(text(),'Create Team')]")).click();
		Thread.sleep(2000);

		
		   // driver.navigate().refresh();
		    driver.findElement(By.xpath("//a[contains(text(),'Skip')]")).click();
		   
		    //select wicket keeper
		  //get the value of credits for wicket keepers
		    //credits xpath
		    List<WebElement> creditsList = driver.findElements(By.xpath("//div[@class='table_desin pos_rlt']/div[@class='row']/div[4]"));
		    System.out.println("Number of players in wicket keeper list:"+creditsList.size());
//		    String a[] = new String[creditsList.size()];
//		    for(int i=0; i<creditsList.size(); i++) {
//		    String credit = driver.findElements(By.xpath("//div[@class='table_desin pos_rlt']/div[@class='row']/div[4]")).get(i).getText();
//		     
//		    //Storing the data in array
//		    a[i]=credit;
//		    //System.out.println(a[i]);
//		    }
		   
		   
		   
		    Thread.sleep(1000);    
		    WebElement scroll1 = driver.findElement(By.xpath("//div[@class='btmstatus_text']")); //bring the controller to pop up
		    scroll1.click();
		    Thread.sleep(2000);
		    // Scroll Down using Actions class
		     Actions actions = new Actions(driver);
		     //actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform();
		     actions.sendKeys(Keys.PAGE_DOWN).build().perform();
		     actions.sendKeys(Keys.PAGE_DOWN).build().perform();
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("window.scrollTo(0, 1000)");
		   
		   
		    List<WebElement> wicketKeeper = driver.findElements(By.xpath("//a[@class='select_player']")); //players xpath
		    int count =0;
		    
		    if(creditsList.size() == 2) {
		    	
		    	for(int i=creditsList.size()-1; i>=0; i--) { //for clicking from last value when there are only two players in the list
				    wicketKeeper.get(i).click();
				    count++;
				   
				    if(count == 2) {
				    break;
				    }
				     
				}
		    	
		    }else {
		    	
		    	for(int i=creditsList.size()-1; i>0; i--) { //for clicking from last value
				    wicketKeeper.get(i).click();
				    count++;
				   
				    if(count == 2) {
				    break;
				    }
				     
				}
		    }
		    

		      Thread.sleep(1000);
		    //select the number of batsman
		    driver.findElement(By.xpath("//a[contains(text(),'BAT (0)')]")).click();
		   
		List<WebElement> battersCredit = driver.findElements(By.xpath("//div[@class='table_desin pos_rlt']/div[@class='row']/div[4]"));
		System.out.println("Number of players in Batsmen list:"+battersCredit.size());

		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
	    actions.sendKeys(Keys.PAGE_DOWN).build().perform();
	    js.executeScript("window.scrollTo(0, 1000)");
		
		
		List<WebElement> batsmen = driver.findElements(By.xpath("//a[@class='select_player']"));

		Thread.sleep(5000);
		int c=0;
		for(int j=battersCredit.size()-1; j>0; j--) {
		batsmen.get(j).click();
		    c++;
		   
		    if(c == 3) {
		    break;
		    }
		}

		Thread.sleep(2000);
		//select the number of all rounder
		driver.findElement(By.xpath("//a[contains(text(),'AR (0)')]")).click();
		List<WebElement> allrounderCredits = driver.findElements(By.xpath("//div[@class='table_desin pos_rlt']/div[@class='row']/div[4]"));

		System.out.println("Number of players in All Rounders list:"+allrounderCredits.size());
		
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
	    actions.sendKeys(Keys.PAGE_DOWN).build().perform();
	    js.executeScript("window.scrollTo(0, 1000)");

		List<WebElement> allrounder = driver.findElements(By.xpath("//a[@class='select_player']"));
		Thread.sleep(5000);
		int c1=0;
		for(int k=allrounderCredits.size()-1; k>0; k--) {
		allrounder.get(k).click();
		    c1++;
		   
		    if(c1 == 3) {
		    break;
		    }
		}

		Thread.sleep(2000);
		//select the number of bowler
		driver.findElement(By.xpath("//a[contains(text(),'BOWL (0)')]")).click();
		List<WebElement> bowlerCredits = driver.findElements(By.xpath("//div[@class='table_desin pos_rlt']/div[@class='row']/div[4]"));

		System.out.println("Number of players in All Rounders list:"+bowlerCredits.size());
		
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
	    actions.sendKeys(Keys.PAGE_DOWN).build().perform();
	    js.executeScript("window.scrollTo(0, 1000)");

		List<WebElement> bowler = driver.findElements(By.xpath("//a[@class='select_player']"));
		Thread.sleep(5000);
		int c2=0;
		for(int l=bowlerCredits.size()-1; l>0; l--) {
		bowler.get(l).click();
		    c2++;
		   
		    if(c2 == 3) {
		    break;
		    }
		}

		//click on next button
		driver.findElement(By.xpath("//span[contains(text(),'NEXT')]")).click();

		//select captain
		driver.findElement(By.xpath("//div[@class='row align-items-center']/div[2]")).click();
		
		//select vice captain
//		List <WebElement> viceCaptainList =  driver.findElements(By.xpath("//div[@class='row align-items-center']/div[3]"));
		driver.findElement(By.xpath("(//div[@class='row align-items-center']/div[3])[2]")).click();
		
		//click on save button
		driver.findElement(By.xpath("//span[contains(text(),'SAVE')]")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//img[@alt='back icon']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@alt='back icon']")).click();
//		for(int i=0; i<viceCaptainList.size(); i++) {
//			
//			if(i==1) {
//				viceCaptainList.get(i).click();
//				break;
//			}
//		}
			
			
		driver.quit();

	    
	}

}
