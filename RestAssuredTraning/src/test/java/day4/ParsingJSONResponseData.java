package day4;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ParsingJSONResponseData {

      @Test(priority = 1)
	void testJsonResponse() throws JsonProcessingException {
      
		//Appoach1
		
		/*
		 * given() .contentType("application.JSON")
		 * 
		 * .when() .get("https://reqres.in/api/users?page=2")
		 * 
		 * .then() .statusCode(200)
		 * .header("Content-Type","application/json; charset=utf-8")
		 * 
		 * .body("data[5].last_name",equalTo("Howell"));
		 */
		
		//Appoach2
		
	 Response	res =given()
		.contentType(ContentType.JSON)
		.when().get("https://reqres.in/api/users?page=2");
		  
		
		Assert.assertEquals( res.getStatusCode(), 200);  //validation 1
		Assert.assertEquals(res.header("Content-Type"),"application/json; charset=utf-8");
	
		String bookname = res.jsonPath().get("data[5].last_name").toString();
		Assert.assertEquals(bookname, "Howell");
		
		
		
		
		
	}
	
	
	//@Test(priority = 2)
		void testJsonResponseBodyData() {
	      
			//Appoach2
		    Response	res =given()
			.contentType(ContentType.JSON)
			.when().get("https://reqres.in/api/users?page=2");
			
		/*	Assert.assertEquals( res.getStatusCode(), 200);  //validation 1
			Assert.assertEquals(res.header("Content-Type"),"application/json; charset=utf-8");
			String bookname = res.jsonPath().get("data[5].last_name").toString();
			Assert.assertEquals(bookname, "Howell");*/
		    
		    //JSONObject class
//		    JSONObject jo=new JSONObject(res.asString());
//		    for (int i = 0; i < jo.getJSONArray("data").length() ; i++)
//		    {
//				String bookTitle = jo.getJSONArray("data").getJSONObject(i).get("last_name").toString();
//				System.out.println(bookTitle);
//			}
		    
		    
		    //search for title of the book in json - validation 1
		    JSONObject jo=new JSONObject(res.asString());
		    boolean status = false;
		    for (int i = 0; i < jo.getJSONArray("data").length() ; i++)
		    {
				String bookTitle = jo.getJSONArray("data").getJSONObject(i).get("last_name").toString();
				
				if (bookTitle.equals("Howell")) {
					status = true;
					break;
				}
			}
		    
		    Assert.assertEquals(status, true);
		    
		    
			//validation for total count 
			int totalprice=0;
		    for (int i = 0; i < jo.getJSONArray("data").length() ; i++)
		    {
				String DataId = jo.getJSONArray("data").getJSONObject(i).get("id").toString();
				
				totalprice = totalprice + Integer.parseInt(DataId);
			}
		    System.out.println("Total id count " +totalprice);
		    Assert.assertEquals(totalprice, 57);
		}
	
	

}
