package Api.utt_restPractice;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

import static io.restassured.matcher.RestAssuredMatchers.*;

public class allHttpMethods {
	
	int id; 
	
	@Test (priority = 1)
	void getUsers() {
		
		given()
		
		.when()
		   .get("https://reqres.in/api/users?page=2")
		   
		.then()
		   .statusCode(200)
		   .body("page", equalTo(2))
		   .log().all();
		
	}
	
	@Test (priority = 2)
	void createUsers() {
		
		
		
		HashMap data = new HashMap();
		data.put("name", "Kylie");
		data.put("job", "Manager");
		
		id = given()
		   .contentType("application/json")
		   .body(data)
		 
		   
		  
		.when()
		   .post("https://reqres.in/api/users")
		   .jsonPath().getInt("id"); //from response we are getting particular id and returning the value
		   
//		.then()
//		   .statusCode(201)
//		   .log().all();
	}
	
	
	@Test (priority = 3, dependsOnMethods= {"createUsers"})
	void updateUser() {
		
       
		
		HashMap data = new HashMap();
		data.put("name", "John");
		data.put("job", "Developer");
		
		given()
		   .contentType("application/json")
		   .body(data)
		  
		  
		.when()
		   .put("https://reqres.in/api/users/" + id)
		   
		.then()
		   .statusCode(200)
		   .log().all();
		
	}

	@Test (priority = 4, dependsOnMethods= {"updateUser"})
	void deleteUser() {
		
		
		given()
				  
		  
		.when()
		   .delete("https://reqres.in/api/users/" + id)
		   
		.then()
		   .statusCode(204)
		   .log().all();
		
	}

}
