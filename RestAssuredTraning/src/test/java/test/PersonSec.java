package test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class PersonSec {

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
		PersonSec person = new PersonSec();
		person.setName("John");
		person.setAge(30);
		person.setEmail("john@example.com");

		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(person);
		System.out.println(json);
	}

}
