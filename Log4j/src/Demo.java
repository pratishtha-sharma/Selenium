import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Demo {

	private static Logger log = LogManager.getLogger(Demo.class.getName());
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		log.debug("I have clicked the button");
		log.info("Button is clicked");
		log.error("Button is not getting clicked");
		log.fatal("Button object is missing");

	}

}
