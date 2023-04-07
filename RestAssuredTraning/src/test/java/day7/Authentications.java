package day7;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class Authentications {

//	@Test(priority = 1)
	void testBasicAuthentication() {
		
		given()
		  .auth().basic("postman", "password")
		.when()
		   .get("https://postman-echo.com/basic-auth")
		
		.then()
		 .statusCode(200)
		 .body("authenticated", equalTo(true))
		 .log().all();
		
		;
		
	}
	
	//@Test(priority = 2)
	void testDigestcAuthentication() {
		
		given()
		  .auth().digest("postman", "password")
		.when()
		   .get("https://postman-echo.com/basic-auth")
		
		.then()
		 .statusCode(200)
		 .body("authenticated", equalTo(true))
		 .log().all();
		
		;
		
	}
	
	
	//@Test(priority = 3)
	void testpreemptiveAuthentication() {
		
		given()
		.auth().preemptive().basic("postman", "password")
		.when()
		   .get("https://postman-echo.com/basic-auth")
		
		.then()
		 .statusCode(200)
		 .body("authenticated", equalTo(true))
		 .log().all();
		
		;
		 
	}
	
	
	//@Test(priority = 4)
	void testBearerTokenAuthentication() {
		
		String bearerToken ="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";
		
		given()
		 .header("Authorization","Bearer "+bearerToken)
		.when()
		   .get("https://api.github.com/users")
		 
		.then()
		 .statusCode(200)
		 .log().all();
		
	}
	
	
//	@Test(priority = 5)
	void testOAuth1Authentication() {
		
		 
		
		given()
		 .auth().oauth("consumerKey","consumerSecrat","accessToken","tokenSecrate") //this is for OAuth1.0 authentication 
		.when()
		   .get("https://api.github.com/users")
		
		.then()
		 .statusCode(200)
		 .log().all();
		
	}
	
	
//	@Test(priority = 6)
	void testOAuth2Authentication() {
		
		 
		
		given()
		 .auth().oauth2("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") //this is for OAuth1.0 authentication 
		.when()
		   .get("https://api.github.com/user/repos")
		
		.then()
		 .statusCode(200)
		 .log().all();
		
	}
	
	//https://openweathermap.org/api
	
	@Test(priority = 7)
	void testAPIKeyAuthentication() {
		
		 
		//Method 1
		/*given()
		 .queryParam("appid","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") //appid is APIKey
		.when()
		   .get("https://api.openweathermap.org/data/2.5/forecast/daily?q=Delhi&units=metric&cnt=7")
		
		.then()
		 .statusCode(200)
		 .log().all();*/
		
		
		//Method2
		given()
		.queryParam("appid","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")
		.pathParam("mypath", "data/2.5/forecast/daily")
		 .queryParam("q", "Delhi")
		 .queryParam("units", "metric")
		 .queryParam("cnt", "7")
		 
		
		
		.when()
		.get("https://api.openweathermap.org/{mypath}")
		.then()
		 .statusCode(200)
		 .log().all()
		;
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
