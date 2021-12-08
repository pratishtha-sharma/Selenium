import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.Select;



public class Ui_assignment {



public static void main(String[] args) throws InterruptedException {

// TODO Auto-generated method stub

System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");

WebDriver driver = new ChromeDriver();

driver.get("https://www.cleartrip.com/");

driver.manage().window().maximize();

//current date selection

driver.findElement(By.id("DepartDate")).click();

driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();

//adult dropdown

Select s= new Select(driver.findElement(By.id("Adults")));

Thread.sleep(3000);

s.selectByValue("4");

//children dropdown

Select s1= new Select(driver.findElement(By.id("Childrens")));

Thread.sleep(3000);

s1.selectByValue("2");

Select s2= new Select(driver.findElement(By.id("Infants")));

Thread.sleep(3000);

s2.selectByValue("1");

//more link option

driver.findElement(By.id("MoreOptionsLink")).click();

//class

Select s3= new Select(driver.findElement(By.id("Class")));

Thread.sleep(3000);

s3.selectByValue("First");

//preferred airlines

driver.findElement(By.id("AirlineAutocomplete")).sendKeys("AirIndia");

        //driver.findElement(By.xpath("//input[text()='Airline name']")).sendKeys("AirIndia");

//search button

driver.findElement(By.id("SearchBtn")).click();



System.out.println(driver.findElement(By.xpath("//div[@id='homeErrorMessage']")).getText());

Thread.sleep(5000);

driver.close();

}



}

