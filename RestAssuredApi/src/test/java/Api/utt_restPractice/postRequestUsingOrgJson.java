package Api.utt_restPractice;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.matcher.RestAssuredMatchers.*;

public class postRequestUsingOrgJson {
	
	String id;
	
	@Test(priority = 1)
	void testPostUsingOrgJsonLibrary() {
		
		JSONObject data = new JSONObject();
		data.put("name", "Scott");
		data.put("location", "Canada");
		data.put("phone", "9685444474");
		
		String coursesArr[] = {"C", "C++"};		
		data.put("courses", coursesArr);
		
		//id = given()
	    given()
		   .contentType("application/json")
		   .body(data.toString())
		
		.when()
		   .post("http://localhost:3000/students")
		   //.jsonPath().getString("id"); //from response we are getting particular id and returning the value
		   
		.then()
		   .statusCode(201)
		   .body("name", equalTo("Scott"))
		   .body("location", equalTo("Canada"))
		   .body("phone", equalTo("9685444474"))
		   .body("courses[0]", equalTo("C"))
		   .body("courses[1]", equalTo("C++"))
		   .header("Content-Type", "application/json")
		   .log().all();
		
	}
	
//	@Test (priority = 2, dependsOnMethods= {"testPostUsingOrgJsonLibrary"})
//	void deleteUser() {
//		
//		
//		given()
//				  
//		  
//		.when()
//		   .delete("http://localhost:3000/students" + id)
//		   
//		.then()
////		   .statusCode(204)
//		   .log().all();
//		
//	}

}
