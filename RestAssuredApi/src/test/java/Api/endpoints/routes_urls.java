package Api.endpoints;

/*
Create user- POST-  https://petstore.swagger.io/#/user/createUser
Get user- GET-  https://petstore.swagger.io/#/user/getUserByName /{username}
Update user- PUT-  https://petstore.swagger.io/#/user/updateUser /{username}
Delete user- DELETE-  https://petstore.swagger.io/#/user/deleteUser /{username}
 */

public class routes_urls {
	
	public static String base_url = "https://petstore.swagger.io/v2";
	
	//user module endpoints
	
	public static String post_url = base_url + "/user";
	public static String get_url = base_url + "/user/{username}";
	public static String put_url = base_url + "/user/{username}";
	public static String delete_url = base_url + "/user/{username}";
	
}
