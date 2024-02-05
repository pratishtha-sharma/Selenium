package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/cucumber", glue="com.stepDefinitions", monochrome=true, plugin= {"html:target/cucumber.html"}, tags="@submitOrder")
//glue means we add step definition file, monochrome is for adding report in readable format, plugin is for report type and where to store the same
//cucumber can not scan the testng assertion and libraries so for that a class is provided which can be extended to help cucumber understand and run testng command
public class TestNGTestRunner extends AbstractTestNGCucumberTests {
	
	

}
