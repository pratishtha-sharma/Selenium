package testpkg;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class testng3 {
	
	@BeforeSuite(groups=("Smoke")) //will run before executing any other test case, can be used for declaring global variable 
	public void demo()
	{
		System.out.println("I came first");
	}
	@Test
	public void failMethod()
	{
	   System.out.println("My name is fail method");
		Assert.assertTrue(false);	
	}
	
	@Test(dataProvider = "getData")
	public void mobileSignIn(String username, String password)
	{
		System.out.println("Sign in to continue by providing username and password");
	    System.out.println(username);
	    System.out.println(password);
	}
	
	@DataProvider
	public Object[][] getData()
	{
		 //using 3 set of username and password combination so wee are using dynamic array.
		 Object[][] data = new Object[3][2];
		 
		 //1st set
		 data[0][0] = "username1";
		 data[0][1] = "password1";
		 //2nd set
		 data[1][0] = "username2";
		 data[1][1] = "password2";
		 //3rd set
		 data[2][0] = "username3";
		 data[2][1] = "password3";
		 
		 return data;
		 
	}

}
