package day6;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

//Pojo ----- Serilization -->  Json object --- de-serilize ---->Pojo

public class SerilizationDeserilization {

	// Pojo -------> Json (Serilization)
	@Test(priority = 1)
	void convertPojo2Json() throws JsonProcessingException {

		// created java object using pojo class
		Student data = new Student(); // pojo

		data.setName("Ganesh");
		data.setLoaction("Mumbai");
		data.setPhone("123456");
		String courseArr[] = { "c", "c++" };
		data.setCources(courseArr);

		// convert java object ----> json object (serilization)
		ObjectMapper objMapper = new ObjectMapper();
		String jsondata = objMapper.writeValueAsString(data);
		System.out.println(jsondata);
		//.body(jsondata);

	}

	// Json -------> Pojo (De-Serilization)
	//@Test(priority = 2)
	void convertJson2pojo() throws JsonProcessingException {

		String jsondata = "{\r\n" + "  \"name\" : \"Ganesh\",\r\n" + "  \"loaction\" : \"Mumbai\",\r\n"
				+ "  \"phone\" : \"123456\",\r\n" + "  \"cources\" : [ \"c\", \"c++\" ]\r\n" + "}";

		// convert json data ---> Pojo object

		ObjectMapper objMapper = new ObjectMapper();
		Student stupojo = objMapper.readValue(jsondata, Student.class); //convert json to pojo
		System.out.println(" location : " + stupojo.getLoaction());
		System.out.println(" name : " + stupojo.getName());
		System.out.println(" Cources : " + stupojo.getCources()[0]);
		System.out.println(" Cources : " + stupojo.getCources()[1]);

	}

}
