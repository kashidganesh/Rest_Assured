package day8;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class UpdateUser {
	
	
	@Test
	void test_CreateUser(ITestContext context) {

		Faker faker = new Faker();

		JSONObject data = new JSONObject();
		data.put("name", faker.name().fullName());
		data.put("gender", "Male");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "active");

		String bearerToken = "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";
		
		//int id  =  (Integer) context.getAttribute("user_id");
		int id  =  (Integer) context.getSuite().getAttribute("user_id");
		
		given()
		   .headers("Authorization","Bearer "+bearerToken)
		   .contentType("application/json")
		   .pathParam("id", id)
		   .body(data.toString())
		.when()
		  .put("https://gorest.co.in/public/v2/users/{id}")
            
		  .then()
		  .statusCode(200)
		  .log().all();
		
	}

}
