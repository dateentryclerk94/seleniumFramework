package tests;

import java.security.KeyStore.TrustedCertificateEntry;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationWithDDTAndDataProviderTest extends TestBase{

	HomePage homeObject;
	UserRegisterationPage registerPage;
	LoginPage loginObject;
	
	
	@DataProvider(name = "testData")
	public static Object[][] userData()
	{
		return new Object[][] {
			{"moh" , "nma" , "hsi84290@gmail.com" , "6541265"},
			{"jhsd" , "gasuy" , "gs19d0@gmail.com" , "638178"}
			};
	}
	
	@Test(priority = 1 , alwaysRun = true , dataProvider = "testData")
	public void userCanRegisterSuccessfully(String fname , String lname ,
			String email , String oldpassword)
	{
		homeObject = new HomePage(driver);
		homeObject.openRegisterationPage();
		
		registerPage = new UserRegisterationPage(driver);
		registerPage.userRegisteration(fname, lname, email,
				oldpassword);
		Assert.assertTrue(registerPage.successMesg
				.getText()
				.contains("Your registration completed"));
		registerPage.userLogOut();
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.userLogin(email, oldpassword);
		Assert.assertTrue(registerPage.logoutLink.getText()
				.contains("Log out"));
		registerPage.userLogOut();
	}
	
}
