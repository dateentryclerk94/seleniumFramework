package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.w3c.dom.UserDataHandler;

import data.LoadProperties;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationWithDDTAndPropertiesFileTest extends TestBase{

	HomePage homeObject;
	UserRegisterationPage registerPage;
	LoginPage loginObject;
	
	String frstname = 
			LoadProperties.userData.getProperty("fName");
	     // class name    . static var accessed directly . function
	     // that contain more than value
	String lastname = LoadProperties.userData.getProperty("lName");
	String mail = LoadProperties.userData.getProperty("Email");
	String oldpass = LoadProperties.userData.getProperty("oldPassword");
	
	
	@Test(priority = 1)
	public void userCanRegisterSuccessfully()
	{
		homeObject = new HomePage(driver);
		homeObject.openRegisterationPage();
		
		registerPage = new UserRegisterationPage(driver);
		registerPage.userRegisteration(frstname, lastname, mail,
				oldpass);
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
		loginObject.userLogin(mail, oldpass);
		Assert.assertTrue(registerPage.logoutLink.isDisplayed());
	}
}
