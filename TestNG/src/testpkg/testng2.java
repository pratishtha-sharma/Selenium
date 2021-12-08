package testpkg;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class testng2 {

	@Test(groups=("Smoke")) //to group some test cases and run only them
	public void Demo3()
	{
		System.out.println("vapas se hellooooo jii");
	}
	
	@AfterSuite //execute after running all the test case, at the end
	public void Demo4()
	{
		System.out.println("I came last");
	}
	
	@Test(groups=("Smoke"))
	public void Demo5()
	{
		System.out.println("lo mai aa gaya");
	}
	
	@Parameters({"URL","API_Key"}) //url  will come from xml to java to this method
	@Test
	public void Demo6(String urlname, String apikey)
	{
		System.out.println("check me, I have 2 parameters");
		System.out.println(urlname);
		System.out.println(apikey);
	}
	
}
