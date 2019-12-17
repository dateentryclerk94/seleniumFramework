package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegisterationPage;

public class MyAccountTest extends TestBase{

	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	MyAccountPage myAccountObject;
	String fName = "one";
	String lName = "two";
	String Email = "pq1lc00910@gmail.com";
	String oldPassword = "123ni4";
	String newPassword = "124nm5";
	
	@Test(priority = 1 , alwaysRun = true)
	public void userCanRegisterSuccessfully()
	{
		homeObject = new HomePage(driver);
		homeObject.openRegisterationPage();
		registerObject = new UserRegisterationPage(driver);
		
		registerObject.userRegisteration(fName, lName, Email,
				oldPassword);
		Assert.assertTrue(registerObject.successMesg
				.getText()
				.contains("Your registration completed"));
	}
	
	@Test(priority = 2)
	public void registeredUserCanChangePassword() {
		myAccountObject = new MyAccountPage(driver);
		myAccountObject.openChangePasswordPage();
		myAccountObject.openChangePasswordLink();
		myAccountObject.changePassword(oldPassword, newPassword);
		Assert.assertTrue(myAccountObject.resultlb1
				.getText()
				.contains("Password was changed"));
	}
	
	@Test(priority = 3)
	public void RegisteredUserCanLogOut()
	{
		registerObject.userLogOut();
	}
	
	@Test(priority = 4)
	public void RegisteredUserCanLoginIN()
	{
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.userLogin(Email, newPassword);
		Assert.assertTrue(registerObject.logoutLink.isDisplayed());
	}
	
}
