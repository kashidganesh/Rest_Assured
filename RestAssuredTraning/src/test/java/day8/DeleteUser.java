package day8;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class DeleteUser {

	@Test
	void test_CreateUser(ITestContext context) {

		 
		String bearerToken = "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";
		
		//int id  =  (Integer) context.getAttribute("user_id");
		int id  =  (Integer) context.getSuite().getAttribute("user_id");
		
		given()
		   .headers("Authorization","Bearer "+bearerToken)
		   .pathParam("id", id)
		.when()
		  .delete("https://gorest.co.in/public/v2/users/{id}")
		  .then()
		  .statusCode(200)
		  .log().all();
		
	}

	
}
