package steps;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.CheckOutPage;
import pages.OrderDetailsPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;
import tests.TestBase;

public class E2ETests extends TestBase{
	
	SearchPage searchPageObject;
	ProductDetailsPage detailsObject;
	ShoppingCartPage cartObject;
	CheckOutPage checkOutObject;
	OrderDetailsPage orderObject;
	
	String productName = "Apple MacBook Pro 13-inch";
	
	@Given("^user is on the Home Page$")
	public void user_is_on_the_Home_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(driver.getCurrentUrl()
				.contains("https://demo.nopcommerce.com/"));
	}

	@When("^he search for \"([^\"]*)\"$")
	public void he_search_for(String productName) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		searchPageObject = new SearchPage(driver);
		searchPageObject.productSearchWithAutoSearch(productName);
		detailsObject = new ProductDetailsPage(driver);
		Assert.assertTrue(detailsObject.productNameBreadCrumb
				.getText().contains(productName));
	}

	@When("^choose to buy two items$")
	public void choose_to_buy_two_items() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		cartObject = new ShoppingCartPage(driver);
		detailsObject.addProductToCart();
		driver.navigate().to("https://demo.nopcommerce.com/cart");
	    
	}

	@When("^moves to checkout cart and enter personal details on checkout page and place an order$")
	public void moves_to_checkout_cart_and_enter_personal_details_on_checkout_page_and_place_an_order() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    checkOutObject = new CheckOutPage(driver);
	    cartObject.openCheckOutPageAsAGuest();
	    checkOutObject.guestCheckoutProduct("onw", "hgds", "Egypt",
	    		"dsgi82@gmail.com", "kgsdkjA", "61287681",
	    		"6129861928", "CAIRO");
	    Assert.assertTrue(checkOutObject.productName.isDisplayed());
	    Assert.assertTrue(checkOutObject.productName.getText()
	    		.contains(productName));
	    checkOutObject.confirmOrder();
	    Assert.assertTrue(checkOutObject.thankYouLb1.isDisplayed());
	}

	@Then("^he can view the order and download the invoice$")
	public void he_can_view_the_order_and_download_the_invoice() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    orderObject = new OrderDetailsPage(driver);
	    checkOutObject.viewOrderDetails();
	    Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));
	    orderObject.downloadPDFinvoice();
		Thread.sleep(3000);
		orderObject.printOrderDetails();
		Thread.sleep(2000);
	}

}
