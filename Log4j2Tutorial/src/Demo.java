import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Demo {

	private static Logger log = LogManager.getLogger(Demo.class.getName());
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	log.debug("I am debuggig");
	log.error("I am an error");
	log.fatal("This is a fatal error");
	log.info("This is an info object");
		
	}

}
