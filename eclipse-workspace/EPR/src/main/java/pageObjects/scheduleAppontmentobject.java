package pageObjects;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;


public class scheduleAppontmentobject {

	private static final Logger log = LogManager.getLogger(scheduleAppontmentobject.class);
	
    WebDriver driver;
	
	public scheduleAppontmentobject(WebDriver driver) {
        this.driver = driver;
	}
	
	
	
}
