package Api.testCases;

import org.testng.annotations.Test;

import Api.endpoints.userEndpoints;
import Api.payload.User;
import Api.utilities.dataProviders;
import io.restassured.response.Response;
import junit.framework.Assert;

public class dataDrivenTests {
	
	
	@Test(priority = 1, dataProviderClass=dataProviders.class, dataProvider = "Data")
	//dataProviderClass=dataProviders.class is used as dataprovider is in separate class instad of using in same class
	public void testPostUserData(String userId, String username, String fname, String lname, String email, String pwd, String phone) {
		// data provider is sending the data and then we have to receive data by passing as parameter
		//using parameter we will create payload, we will use POJO class
		
		User userPayload = new User();
		
		userPayload.setId(Integer.parseInt(userId));
		userPayload.setUsername(username);
		userPayload.setFirstName(fname);
		userPayload.setLastName(lname);
		userPayload.setEmail(email);
		userPayload.setPassword(pwd);
		userPayload.setPhone(phone);
		
		Response response = userEndpoints.createUser(userPayload);

		Assert.assertEquals(response.getStatusCode(), 200);
		
		System.out.println("*******This is post request*******");

	}
	
	@Test(priority = 2, dataProviderClass=dataProviders.class, dataProvider = "UserNames")
	public void testGetUserByName(String username) {
		
		Response response = userEndpoints.readUser(username);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		System.out.println("*******This is get request*******");
		
	}
	
	@Test(priority = 3, dataProviderClass=dataProviders.class, dataProvider = "UserNames")
	public void deleteUserByName(String username) {
		
		Response response = userEndpoints.deleteUser(username);
		Assert.assertEquals(response.getStatusCode(), 200);
		
		System.out.println("*******This is delete request*******");
		
	}

}
