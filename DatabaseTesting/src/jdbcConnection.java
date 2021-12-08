import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class jdbcConnection {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String host = "localhost";
		String port = "3306";

		//"jdbc:mysql:"+host+":"+port+"/dbName"
		Connection con = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/qadbt", "root", "123456");
		
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("select * from Employeeinfo where name = 'sam'");
		//ResultSet rs = s.executeQuery("select * from Employeeinfo");
		while(rs.next())  //data in java stored at 0 index while the result from db is stored at 1 to we have to point it to 1 index and also used for further incrementing
		{
			//System.setProperty("webdriver.chrome.driver", "F:\\Automation work\\chromedriver_win32 (1)\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\driverExe\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("https://login.salesforce.com/?locale=in");
			driver.manage().window().maximize();
			
		 
			driver.findElement(By.xpath("//input[@name='username']")).sendKeys(rs.getString("name"));
		    //System.out.println(rs.getString("name"));
		}
	}

}
