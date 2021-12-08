package pkg2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Demo1 {

	private static Logger log = LogManager.getLogger(Demo1.class.getName());
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		log.debug("My name is debug method");
		log.info("My name is info method");
		log.error("Hello I am an error");
		log.fatal("Something is missing. It is fatal"); 
		
		
	}

}
