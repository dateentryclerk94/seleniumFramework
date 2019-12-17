package tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import data.JSONDataReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationWithDDTAndJSONTest extends TestBase{

	HomePage homeObject;
	UserRegisterationPage registerPage;
	LoginPage loginObject;
    


	@Test(priority = 1)
	public void userCanRegisterSuccessfully() throws FileNotFoundException, IOException, ParseException
	{
		JSONDataReader jsonReader = new JSONDataReader();
		jsonReader.JsonReader();
		
		homeObject = new HomePage(driver);
		homeObject.openRegisterationPage();

		registerPage = new UserRegisterationPage(driver);
		
		registerPage.userRegisteration(jsonReader.firstname, jsonReader.lastname,
				jsonReader.email,
				jsonReader.password);
		Assert.assertTrue(registerPage.successMesg
				.getText()
				.contains("Your registration completed"));
		registerPage.userLogOut();
		
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.userLogin(jsonReader.email, jsonReader.password);
		Assert.assertTrue(registerPage.logoutLink.isDisplayed());
		
		registerPage.userLogOut();
	}


}
