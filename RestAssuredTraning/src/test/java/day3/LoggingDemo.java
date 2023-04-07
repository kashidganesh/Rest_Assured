package day3;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class LoggingDemo {

	@Test(priority = 1)
	void testLogs() {

		given()

				.when().get("https://reqres.in/api/users?page=2")
				// .get("https://www.google.com/")

				.then()
				// .log().body();
				// .log().cookies()
				// .log().headers()
				.log().all();
	}

}
