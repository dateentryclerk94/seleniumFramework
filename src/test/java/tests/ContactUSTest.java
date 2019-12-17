package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUSPage;
import pages.HomePage;

public class ContactUSTest extends TestBase {

	HomePage homeObject;
	ContactUSPage contactObject;
	
	String FullName = "one";
	String email = "pq1lc0m00@gmail.com";
	String messg = "this is only for test . enjoy ";

	@Test
	public void userCanContactUS() {
		homeObject = new HomePage(driver);
		homeObject.openContactUSPage();
		contactObject = new ContactUSPage(driver);
		contactObject.contactUS(FullName , email , messg);
		Assert.assertTrue(contactObject.suceessMessg
				.getText()
				.contains("Your enquiry has been successfully sent"));

	}

}
