package test;

import java.util.Arrays;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PersonDec {

	private String name;
	private int age;
	private String email;

	// getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static void main(String[] args) throws Exception {
		String json = "{\"name\":\"John\",\"age\":30,\"email\":\"john@example.com\"}";

		ObjectMapper mapper = new ObjectMapper();
		// JsonNode node = mapper.readValue(json, PersonDec.class);

		PersonDec person = mapper.readValue(json, PersonDec.class);

		System.out.println(person.getName());
		System.out.println(person.getAge());
		System.out.println(person.getEmail());
	}

}
