package Api.endpoints;

import static io.restassured.RestAssured.*;

import java.util.ResourceBundle;

import Api.payload.User;
import io.restassured.response.Response;
import io.restassured.http.ContentType;

//Created to perform CRUD operations

public class userEndpointsPropFile {
	
	public static ResourceBundle getURL(){
		ResourceBundle routes = ResourceBundle.getBundle("routes");  // to get data from properties file
		return routes;
		//also try this with Properties class
	}

	public static Response createUser(User payload) {
		
		String post_url = getURL().getString("post_url"); 

		Response response = given() // given- is pre-requisite
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)

				.when() // when- is request
				.post(post_url);

		// validation on response will be done as part of testcase

		return response;

	}

	public static Response readUser(String userName) {
		
		String get_url = getURL().getString("get_url"); 

		Response response = given() // given is pre-requisite
				.pathParam("username", userName)

				.when() // when is request
				.get(routes_urls.get_url);

		// validation on response will be done as part of testcase

		return response;

	}
	
	public static Response updateUser(String userName, User payload) {
		
		String put_url = getURL().getString("put_url"); 

		Response response = given() // given is pre-requisite
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.pathParam("username", userName)

				.when() // when is request
				.put(put_url);

		// validation on response will be done as part of testcase

		return response;

	}
	
	public static Response deleteUser(String userName) {
		
		String delete_url = getURL().getString("delete_url"); 

		Response response = given() // given is pre-requisite
				.pathParam("username", userName)

				.when() // when is request
				.delete(delete_url);

		// validation on response will be done as part of testcase

		return response;

	}

}
