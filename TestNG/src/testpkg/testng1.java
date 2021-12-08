package testpkg;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class testng1 {

	@Test
	public void Demo0()
	{
		System.out.println("I am test 1");
	}
	
	@Test(dependsOnMethods= {"Demo2", "Demo0"}) //to run some test case2 before test case1
	public void Alpha()
	{
		System.out.println("I am test 2");
	}
	
	@AfterTest //will run after test tag
	public void Demo()
	{
		System.out.println("hellooooo");
	}
	
	@Test(groups=("Smoke")) //to group some test cases and run only them
	public void Demo1()
	{
		System.out.println("hiii");
	}
	
	@Parameters({"URL"}) //url  will come from xml to java to this method
	@Test
	public void Demo2(String urlname)
	{
		System.out.println("I am Demo2");
		System.out.println(urlname);
	}
	
	@Test(enabled=false)  //not included while executing
	public void Bug()
	{
		System.out.println("I am Bug");
	}
	
	@Test(timeOut=4000)  //timeOut of 40 sec, so that if the test case is taking a bit time to execute then it will not fail as we have provided the timeout period
	public void timeOut()
	{
		System.out.println("I am timeOut");
	}
	
//	@AfterMethod //will run after every method
//	public void afterMethod()
//	{
//		System.out.println("I AM GONNA EXECUTE After ALL THE TEST METHODS OF THIS CLASS");
//	}
	
//	@BeforeMethod //will run before every method
//	public void beforeMethod()
//	{
//		System.out.println("I AM GONNA EXECUTE Before ALL THE TEST METHODS OF THIS CLASS");
//	}
	
}
