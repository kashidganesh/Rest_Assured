package day5;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

import org.testng.annotations.Test;

public class FileUploadAndDownload {

	//@Test(priority = 1)
	void SingleFileUpload() {

		
		 File myfile =new File("path");
		given()
		 .multiPart("file",myfile)
		 .contentType("multipart/form-data")
		 
		
		.when()
		  .post("url")
		
		
		.then()
		.statusCode(200)
		.body("fileName", equalTo("Text1.txt"))
		.log().all();
		
	}
	
	
	@Test(priority = 2)
		void multipleFileUpload() {

		      File myfile1 =new File("path");
			 File myfile2 =new File("path");
			 
			given()
			 .multiPart("files",myfile1)
			 .multiPart("files",myfile2)
			 .contentType("multipart/form-data")
			 
			
			.when()
			  .post("url")
			
			
			.then()
			.statusCode(200)
			.body("[0].fileName", equalTo("Text1.txt"))
			.body("[1].fileName", equalTo("Text2.txt"))
			.log().all();
			
		}
	
	
	@Test(priority = 3)
	void multipleFileUploadArr() {

	      File myfile1 =new File("path");
		 File myfile2 =new File("path");
		 File filearr[]= {myfile1,myfile2};
		 
		given()
		 .multiPart("files",filearr)
		 .contentType("multipart/form-data")
		 
		
		.when()
		  .post("url")
		
		
		.then()
		.statusCode(200)
		.body("[0].fileName", equalTo("Text1.txt"))
		.body("[1].fileName", equalTo("Text2.txt"))
		.log().all();
		
	}
	
	
	@Test(priority = 4)
	void fileDownload() {

	      
		given()
		 
		 
		
		.when()
		  .post("url")
		
		
		.then()
		.statusCode(200)
		.body("fileName", equalTo("Text1.txt"))
		.log().body();
		
		 
		
	}
	
	

	
	

}
