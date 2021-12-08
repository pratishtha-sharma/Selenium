import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;



public class webTable_assign {



public static void main(String[] args) {

// TODO Auto-generated method stub

System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");

WebDriver driver= new ChromeDriver();

driver.get("http://qaclickacademy.com/practice.php");

driver.manage().window().maximize();

WebElement tables = driver.findElement(By.cssSelector(".table-display"));

int rowcount = tables.findElements(By.tagName("tr")).size();

System.out.println("Total number of rows are: " + rowcount); //number of rows count.

WebElement col = tables.findElement(By.xpath("//table[@id='product']/tbody[1]/tr[1]"));

int columncount = col.findElements(By.tagName("th")).size();

System.out.println("Total number of columns are: " + columncount); //number of columns count.

//Get the text of second row

String text = tables.findElement(By.xpath("//table[@id='product']/tbody[1]/tr[3]")).getText();

System.out.println(text);



driver.quit();

}



}

