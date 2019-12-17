package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationTest extends TestBase{

	HomePage homeObject;
	UserRegisterationPage registerPage;
	LoginPage loginObject;
	
	String fName = "one";
	String lName = "two";
	String Email = "pq1lc000000@gmail.com";
	String oldPassword = "123nm4";
	String newPassword = "124nm5";
	
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
