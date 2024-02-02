package sikuli;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class Test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		
		Screen screen = new Screen();
		
		Pattern p1 = new Pattern("C:\\Users\\admin\\Downloads\\gmailImage.PNG");
		Pattern p2 = new Pattern("C:\\Users\\admin\\Downloads\\signIn1.PNG");
		Pattern p3 = new Pattern("C:\\Users\\admin\\Downloads\\emailId.PNG");
		Pattern p4 = new Pattern("C:\\Users\\admin\\Downloads\\next.PNG");
		
		System.setProperty("webdriver.chrome.driver", "D:\\eclipse\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		
		screen.wait(p1, 10);
		screen.click(p1);
		screen.click(p2);
		screen.type(p3, "test@gmail.com");
		screen.click(p4);
		
	}

}
