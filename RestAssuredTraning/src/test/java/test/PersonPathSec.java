package test;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class PersonPathSec {
	private String name;
	private int age = 0;
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
		PersonPathSec person = new PersonPathSec();
		person.setName("John");
		person.setAge(30);
		person.setEmail("john@example.com");

		DocumentContext documentContext = JsonPath.parse(person);
		String json = documentContext.jsonString();

		System.out.println(json);

	}

}
