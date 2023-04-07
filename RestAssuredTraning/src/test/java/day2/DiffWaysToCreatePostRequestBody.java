package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
 
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

/*Diff ways to create request  body 
-------------
1. HashMap	
2. using org.json
3. POJO
4. using extrnal json file*/

public class DiffWaysToCreatePostRequestBody {
	
	//1) Post request body using HashMap
//	@Test(priority = 1)
	void testPostusingHashMap() {

		HashMap data = new HashMap();
		data.put("name", "Ganesh");
		data.put("location", "Mumbai");
		data.put("phone", "123456");

		String courseArr[] = { "c", "c++" };
		data.put("course", courseArr);

		given()
          .contentType("application/json")
          .body(data)
				.when()
                     .post("url")
                     
				.then()
				.statusCode(201)
				.body("name", equalTo("Ganesh"))
				.body("location", equalTo("Mumbai"))
				.body("phone", equalTo("123455"))
				.body("cource[0]", equalTo("c"))
				.body("cource[1]", equalTo("c++"))
				.header("Content-Type","application/json; charset=uft-8")
				.log().all();
				;
	}
	
	
	//2) Post request body using org.json
		@Test(priority = 2)
		void testPostusingJsonLibrary() {
 
			JSONObject data=new JSONObject();
			data.put("name", "Ganesh");
			data.put("location", "Mumbai");
			data.put("phone", "123456");

			String courseArr[] = { "c", "c++" };
			data.put("course", courseArr);
			
			given()
	          .contentType("application/json")
	          .body(data.toString())
					.when()
	                     .post("url")
	                     
					.then()
					.statusCode(201)
					.body("name", equalTo("Ganesh"))
					.body("location", equalTo("Mumbai"))
					.body("phone", equalTo("123455"))
					.body("cource[0]", equalTo("c"))
					.body("cource[1]", equalTo("c++"))
					.header("Content-Type","application/json; charset=uft-8")
					.log().all();
					;
		}
		
		
		//3) Post request body using pojo
			//	@Test(priority = 3)
				void testPostusingPojo() {
		 
					 Pojo_PostRequest data =new Pojo_PostRequest();
					 data.setName(  "Ganesh");
					 data.setLoaction(  "Mumbai");
					 data.setPhone( "123456");
						String courseArr[] = { "c", "c++" };
						data.setCources(courseArr);
					 
					 
					given()
			          .contentType("application/json")
			          .body(data)
							.when()
			                     .post("url")
			                     
							.then()
							.statusCode(201)
							.body("name", equalTo("Ganesh"))
							.body("location", equalTo("Mumbai"))
							.body("phone", equalTo("123455"))
							.body("cource[0]", equalTo("c"))
							.body("cource[1]", equalTo("c++"))
							.header("Content-Type","application/json; charset=uft-8")
							.log().all();
							;
				}
				
				
				
				//4) Post request body using ExternalJsonfile
			//	@Test(priority = 4)
				void testPostusingExternalJsonfile() throws FileNotFoundException {
		 
					 File f=new File(".\\body.json");
					 FileReader fr=new FileReader(f);
					 
					 JSONTokener jt=new JSONTokener(fr);
					 JSONObject data=new JSONObject(jt);
					 
					 
					given()
			          .contentType("application/json")
			          .body(data.toString())
							.when()
			                     .post("url")
			                     
							.then()
							.statusCode(201)
							.body("name", equalTo("Ganesh"))
							.body("location", equalTo("Mumbai"))
							.body("phone", equalTo("123455"))
							.body("cource[0]", equalTo("c"))
							.body("cource[1]", equalTo("c++"))
							.header("Content-Type","application/json; charset=uft-8")
							.log().all();
							;
				}
	
	
	
	//deleting student record
	//@Test(priority = 2)
	void testDelete() {
		
		given()
		
		.when()
		 .delete("url")
		
		.then()
		.statusCode(200)
		;
	}

}
