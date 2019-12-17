package steps;

import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;
import pages.UserRegisterationPage;
import tests.TestBase;

public class UserRegisteration extends TestBase{

	HomePage homeObject;
	UserRegisterationPage registerPageObject;
	
	@Given("^the user in the home page$") 
	public void the_user_in_the_home_page()
	{ 
		homeObject = new HomePage(driver);
		homeObject.openRegisterationPage();
	}
	
	@When("^I click on the register link$")
	public void I_click_on_the_register_link()
	{
		Assert.assertTrue(driver.getCurrentUrl().contains("register"));
	}
	
//	@When("^I entered the user data$")
//	public void I_entered_the_user_data()
//	{
//		registerPageObject = new UserRegisterationPage(driver);
//		registerPageObject.userRegisteration("onw", "mnsk",
//				"sk000@hotmail.com", "1g576517");
//	}
	
	@When("^I entered \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\"$")
	public void i_entered(String firstname, String lastname, 
			String email, String password) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    registerPageObject = new UserRegisterationPage(driver);
	    registerPageObject.userRegisteration(firstname, lastname, email, password);
	}
	
	@Then("^the registeration page displayed successfully$")
	public void the_registeration_page_displayed_successfully()
	{
		registerPageObject.userLogOut();
	}
	
}
