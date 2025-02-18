package Api.endpoints;

import static io.restassured.RestAssured.*;

import Api.payload.User;
import io.restassured.response.Response;
import io.restassured.http.ContentType;

//Created to perform CRUD operations

public class userEndpoints {

	public static Response createUser(User payload) {

		Response response = given() // given- is pre-requisite
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)

				.when() // when- is request
				.post(routes_urls.post_url);

		// validation on response will be done as part of testcase

		return response;

	}

	public static Response readUser(String userName) {

		Response response = given() // given is pre-requisite
				.pathParam("username", userName)

				.when() // when is request
				.get(routes_urls.get_url);

		// validation on response will be done as part of testcase

		return response;

	}
	
	public static Response updateUser(String userName, User payload) {

		Response response = given() // given is pre-requisite
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.pathParam("username", userName)

				.when() // when is request
				.put(routes_urls.put_url);

		// validation on response will be done as part of testcase

		return response;

	}
	
	public static Response deleteUser(String userName) {

		Response response = given() // given is pre-requisite
				.pathParam("username", userName)

				.when() // when is request
				.delete(routes_urls.delete_url);

		// validation on response will be done as part of testcase

		return response;

	}

}
