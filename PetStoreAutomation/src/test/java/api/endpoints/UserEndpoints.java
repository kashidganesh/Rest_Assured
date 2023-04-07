package api.endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payload.User;

//Create for perfrom Craete, Update, Delete requests for the user API.
public class UserEndpoints {

	
	public static Response createUser(User payload) {
		Response response =
		given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		.when()
		.post(Routes.post_url);
		
		return response;
	}
	
	
	public static Response readUser(String userName) {
		Response response =
		given()
		 .pathParam("userName", userName)
		.when()
		.get(Routes.get_url);
		
		return response;
	}
	
	public static Response updateUser(String userName,User payload) {
		Response response =
		given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("userName", userName)
		.body(payload)
		.when()
		.post(Routes.update_url);
		
		return response;
	}
	
	

	public static Response deleteUser(String userName) {
		Response response =
		given()
		 .pathParam("userName", userName)
		.when()
		.delete(Routes.delete_url);
		
		return response;
	}
	
	
	
	
}
