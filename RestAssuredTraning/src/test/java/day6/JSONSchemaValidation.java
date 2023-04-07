package day6;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

public class JSONSchemaValidation {

//json ---> jsonschema converter
//https://jsonformatter.org/json-to-jsonschema	
	
 
	@Test
	void jsonschemaValidation() {
		
		given()
		
		.when()
		.get("https://reqres.in/api/users?page=230")
		
		.then()
		
		.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("storeJsonSchema.json"))
		.log().all()
		;
		
	}
	
}
