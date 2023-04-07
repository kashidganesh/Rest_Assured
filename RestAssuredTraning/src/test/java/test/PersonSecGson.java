package test;

import com.google.gson.Gson;

public class PersonSecGson {

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
    	PersonSecGson person = new PersonSecGson();
        person.setName("John");
        person.setAge(30);
        person.setEmail("john@example.com");

        Gson gson = new Gson();
        String json = gson.toJson(person);
        System.out.println(json);
    }

	
	
}
