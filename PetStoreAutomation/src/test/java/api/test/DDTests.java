package api.test;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import api.endpoints.UserEndpoints;
import api.payload.User;
import api.utilities.*;
import io.restassured.response.Response;

public class DDTests {

	// @Test(priority = 1, dataProvider = "Data", dataProviderClass =
	// DataProvider.class)
	public void testPostuser(String userID, String userName, String fname, String lname, String useremail, String pwd,
			String ph) {

		User userPayload = new User();
		userPayload.setId(Integer.parseInt(userID));
		userPayload.setUsername(userName);
		userPayload.setFirstName(fname);
		userPayload.setLastName(lname);
		userPayload.setEmail(useremail);
		userPayload.setPassword(pwd);
		userPayload.setPhone(ph);

		Response response = UserEndpoints.createUser(userPayload);
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test(priority = 2, dataProvider = "UserName", dataProviderClass = DataProvider.class)
	public void testreadUserByName(String userName) {

		Response response = UserEndpoints.readUser(userName);
		Assert.assertEquals(response.getStatusCode(), 200);

	}

//	@Test(priority = 3, dataProvider = "UserName", dataProviderClass = DataProvider.class)
	public void testDeleteUserByName(String userName) {

		Response response = UserEndpoints.deleteUser(userName);
		Assert.assertEquals(response.getStatusCode(), 200);

	}

}
