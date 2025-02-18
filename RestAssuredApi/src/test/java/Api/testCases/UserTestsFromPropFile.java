package Api.testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import Api.endpoints.userEndpointsPropFile;
import Api.payload.User;
import io.restassured.response.Response;
import junit.framework.Assert;

public class UserTestsFromPropFile {

	Faker faker; // used to create the data and then pass to POJO
	User userPayload;
	public Logger logger;

	@BeforeClass
	public void setUpData() {
		// data will be generated using faker library and that data will be passed to
		// POJO class and that data will be passed along with the post request

		faker = new Faker();
		userPayload = new User();

		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		
		// this piece of code will help in generating logs
		logger = LogManager.getLogger(this.getClass()); //by using LogManager we have initiated the object 

	}

	@Test(priority = 1)
	public void testPostUserData() {
		// data from above method will be passed in this post testcase
		// we have to call the post user endpoint here and pass the payload

		Response response = userEndpointsPropFile.createUser(userPayload);
		// now do the validation using then()
		response.then().log().all(); // log all the response

		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("This is used to create the user"); // to print in log file
		
		System.out.println("*******This is post request*******");

	}

	@Test(priority = 2)
	public void testGetUserByName() {
		Response response = userEndpointsPropFile.readUser(this.userPayload.getUsername());

		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("This is used to get the user details");
		
		System.out.println("*******This is get request*******");

	}

	@Test(priority = 3)
	public void updateUserByName() {

		// update data using same payload
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());

		Response response = userEndpointsPropFile.updateUser(this.userPayload.getUsername(), userPayload);

		response.then().log().all(); // log all the response
		

		Assert.assertEquals(response.getStatusCode(), 200);
		
		//another way of writing assertion is
		//response.then().log().body().statusCode(200);
		response.then().log().body();
		
		
		//checking data after updating by retrieving, get method
		Response updatedResponse = userEndpointsPropFile.readUser(this.userPayload.getUsername());

		updatedResponse.then().log().all();
		Assert.assertEquals(updatedResponse.getStatusCode(), 200);
		
		logger.info("This is used to update the user");
		System.out.println("*******This is put request*******");
		

	}
	
	
	@Test(priority = 4)
	public void deleteUserByName() {
		
		Response response = userEndpointsPropFile.deleteUser(this.userPayload.getUsername());
		
		//response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("This is used to delete the user");
		
		System.out.println("*******This is delete request*******");
		
	}
	

}
