package test;

import com.jayway.jsonpath.JsonPath;

public class PersonPathDec {

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

		PersonPathDec person = JsonPath.parse(json).read("$", PersonPathDec.class);
		// Object result = JsonPath.parse(json).read("$.name");
		// System.out.println(result);
		System.out.println(person.getName());
		System.out.println(person.getAge());
		System.out.println(person.getEmail());
	}

}
