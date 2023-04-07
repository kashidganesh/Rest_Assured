package day7;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class FakerGenerateDummyData {

	
	@Test
	void testGenerateDummyData() {

		Faker faker = new Faker();

		String fullname = faker.name().fullName();
		String firstname = faker.name().firstName();
		String lastname = faker.name().lastName();

		String username = faker.name().username();
		String paswword = faker.internet().password();

		String phoneno = faker.phoneNumber().cellPhone();

		String email = faker.internet().safeEmailAddress();
		
		
		
		System.out.println("Full Name : "+fullname);
		System.out.println("Full Name : "+firstname);
		System.out.println("Full Name : "+lastname);
		
		System.out.println("Full Name : "+username);
		System.out.println("Full Name : "+paswword);
		
		System.out.println("Full Name : "+phoneno);
		
		System.out.println("Full Name : "+email);
		
		
		
		

	}

}
