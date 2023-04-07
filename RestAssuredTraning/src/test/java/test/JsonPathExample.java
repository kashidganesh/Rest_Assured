package test;

import com.jayway.jsonpath.JsonPath;

import net.minidev.json.JSONArray;

public class JsonPathExample {

	public static void main(String[] args) {
		String json = "[{\"name\":\"John\",\"age\":30,\"city\":\"New York\"},"+"{\"name\":\"Jane\",\"age\":25,\"city\":\"Chicago\"}]";
			      
				 
		

		JSONArray jsonArray = JsonPath.read(json, "$");

		// Access the first object in the array
		String name = JsonPath.read(jsonArray, "$[0].name");
		int age = JsonPath.read(jsonArray, "$[0].age");
		String city = JsonPath.read(jsonArray, "$[0].city");

		System.out.println("Name: " + name); // Output: John
		System.out.println("Age: " + age); // Output: 30
		System.out.println("City: " + city); // Output: New York
	}

}
