package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegisterationPage;

public class EmailFriendTest extends TestBase{
	
	HomePage homeObject;
	UserRegisterationPage registerPageObject;
	SearchPage searchPageObject;
	ProductDetailsPage detailsObject;
	LoginPage loginObject;
	EmailPage emailObject;
	
	String fName = "one";
	String lName = "two";
	String Email = "pq1lc1000@gmail.com";
	String oldPassword = "123nm4";
	String newPassword = "124nm5";
	String productName = "Apple MacBook Pro 13-inch";
	String productNameAutoComplete = "mac";
	
	String emailFriend = "ojs@test.com";
	String messg = "Dear , look for this product";
	
	// 1- user register
	@Test(priority = 1)
	public void userCanRegisterSuccessfully()
	{
		homeObject = new HomePage(driver);
		homeObject.openRegisterationPage();
		
		registerPageObject = new UserRegisterationPage(driver);
		registerPageObject.userRegisteration(fName, lName, Email,
				oldPassword);
		Assert.assertTrue(registerPageObject.successMesg
				.getText()
				.contains("Your registration completed"));
	}
	
	//2- search product 
	@Test(priority = 2)
	public void UserCanSearchWithAutoSearch()
	{
		try {
			searchPageObject = new SearchPage(driver);
			detailsObject = new ProductDetailsPage(driver);
			searchPageObject.productSearchWithAutoSearch(productNameAutoComplete);
			Assert.assertEquals(productName, 
					detailsObject.productNameBreadCrumb.getText());
		} catch (Exception e) {
			System.out.println("Error ocuured  " + e.getMessage());
		}
		
	}
	
	//3- email friend 
	@Test(priority = 3)
	public void registeredUserCanSendProductToFriend()
	{
		emailObject = new EmailPage(driver);
		detailsObject.openEmailFriend();
		emailObject.sendEmailToFriend(emailFriend, messg);
		Assert.assertTrue(emailObject.successMessg
				.getText()
				.contains("Your message has been sent"));
	}
	
	//4- logout 
	@Test(priority = 4)
	public void RegisteredUserCanLogOut()
	{
		registerPageObject.userLogOut();
	}
	
}
