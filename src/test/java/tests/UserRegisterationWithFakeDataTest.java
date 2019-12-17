package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationWithFakeDataTest extends TestBase{

	HomePage homeObject;
	UserRegisterationPage registerPage;
	LoginPage loginObject;
	Faker fakeData = new Faker();
		
	String fName = fakeData.name().firstName();
	String lName = fakeData.name().lastName();
	String Email = fakeData.internet().emailAddress();
	String oldPassword = fakeData.number().digits(8).toString();
	
	@Test(priority = 1)
	public void userCanRegisterSuccessfully()
	{
		homeObject = new HomePage(driver);
		homeObject.openRegisterationPage();
		
		registerPage = new UserRegisterationPage(driver);
		registerPage.userRegisteration(fName, lName, Email,
				oldPassword);
		Assert.assertTrue(registerPage.successMesg
				.getText()
				.contains("Your registration completed"));
	}
	
	@Test(dependsOnMethods= {"userCanRegisterSuccessfully"})
	public void RegisteredUserCanLogOut()
	{
		registerPage.userLogOut();
	}
	
	@Test(dependsOnMethods= {"RegisteredUserCanLogOut"})
	public void RegisteredUserCanLoginIN()
	{
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.userLogin(Email, oldPassword);
		Assert.assertTrue(registerPage.logoutLink.isDisplayed());
	}
}
