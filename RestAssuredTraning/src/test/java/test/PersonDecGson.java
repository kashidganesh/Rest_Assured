package test;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class PersonDecGson {

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

	public static void main(String[] args) {
		String json = "{\"name\":\"John\",\"age\":30,\"email\":\"john@example.com\"}";

		Gson gson = new Gson();
		JsonObject jsonObject = gson.fromJson(json, JsonObject.class);

		PersonDecGson person = new PersonDecGson();
		person.setName(jsonObject.get("name").getAsString());
		person.setAge(jsonObject.get("age").getAsInt());
		person.setEmail(jsonObject.get("email").getAsString());

		System.out.println(person.getName());
		System.out.println(person.getAge());
		System.out.println(person.getEmail());

	}

}
