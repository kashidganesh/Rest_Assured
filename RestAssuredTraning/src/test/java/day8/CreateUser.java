	package day8;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class CreateUser {

	@Test
	void test_CreateUser(ITestContext context) {

		Faker faker = new Faker();

		JSONObject data = new JSONObject();
		data.put("name", faker.name().fullName());
		data.put("gender", "Male");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "inactive");

		String bearerToken = "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";
		
		int id  =
		given()
		   .headers("Authorization","Bearer "+bearerToken)
		   .contentType("application/json")
		   .body(data.toString())
		.when()
		  .post("https://gorest.co.in/public/v2/users")
           .jsonPath().getInt("id");
		System.out.println("Generated id is : "+id);
		
		//context.setAttribute("user_id", id);
		context.getSuite().setAttribute("user_id", id);
	}

}
