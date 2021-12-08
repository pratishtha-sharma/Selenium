
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class gridTable {

	public static void main(String[] args) {
	// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "F:\\Automation work\\chromedriver_win32 (1)\\chromedriver.exe");
	WebDriver driver = new ChromeDriver(); //launch chrome

	driver.manage().window().maximize(); //maximize window
	driver.manage().deleteAllCookies(); // delete all the cookies

	driver.get("https://www.cricbuzz.com/live-cricket-scorecard/30340/dc-vs-kxip-2nd-match-indian-premier-league-2020");
	driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

	WebElement table =  driver.findElement(By.cssSelector(".cb-col.cb-col-100.cb-ltst-wgt-hdr"));
	//WebElement row = table.findElements(By.cssSelector(".cb-col.cb-col-100.cb-scrd-itms"));
	int count = table.findElements(By.cssSelector(".cb-col.cb-col-100.cb-scrd-itms div:nth-child(3)")).size();
	System.out.println(count);
	int sum=0;

	for(int i=0; i<count-2; i++) {

	String value = table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).get(i).getText();
	//String value = table.findElements(By.cssSelector(".cb-col.cb-col-100.cb-scrd-itms div:nth-child(3)")).get(i).getText();
	int valueInt = Integer.parseInt(value);
	sum=sum+valueInt;

	}

	System.out.println("sum is: "+sum);

	String Extra = driver.findElement(By.xpath("//div[text()='Extras']/following-sibling::div[1]")).getText();
	int extraInt = Integer.parseInt(Extra);
	System.out.println("Extra runs: "+extraInt);

	sum = sum+extraInt;
	System.out.println("Sum (including extras) is: "+sum);
	
	String Total = driver.findElement(By.xpath("//div[text()='Total']/following-sibling::div[1]")).getText();
	int totalInt = Integer.parseInt(Total);
	System.out.println("Total runs: "+totalInt);
	
	if(sum==totalInt) {
		System.out.println("Total amount matched. Test successful");
	}else {
		System.out.println("Total amount did not match. Test failed");
	}

	driver.quit();

	}

	

}
