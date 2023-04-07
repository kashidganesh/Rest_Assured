package day8;

import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;
public class GetUser {
	@Test
	void test_CreateUser(ITestContext context) {

		//int id  =  (Integer) context.getAttribute("user_id");
		int id  =  (Integer) context.getSuite().getAttribute("user_id");
		String bearerToken = "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";
		
	 
		given()
		 .headers("Authorization","Bearer "+bearerToken)
		 .pathParam("id", id)
		    
		.when()
		  .post("https://gorest.co.in/public/v2/users/{id}")
        
		  .then()
		  .statusCode(200)
		  .log().all();
		  
		
	}
}
