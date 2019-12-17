package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CheckOutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.OrderDetailsPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;
import pages.UserRegisterationPage;

public class GuestCheckOutProductFromCartTest extends TestBase {

	HomePage homePageObject;
	UserRegisterationPage regsiterObject;
	SearchPage searchPageObject;
	ProductDetailsPage detailsObject;
	ShoppingCartPage cartPageObject;
	CheckOutPage checkObject;
	OrderDetailsPage orderDetailsObject;

	String fName = "one";
	String lName = "two";
	String Email = "ph1781091100@gmail.com";
	String oldPassword = "123nm4";
	String newPassword = "124nm5";

	String productName = "Apple MacBook Pro 13-inch";
	String productNameAutoComplete = "mac";

	String countryName = "Egypt";
	String address = "test address";
	String postCode = "215712";
	String phone = "58757654";
	String city = "Cairo";

	@Test(priority = 1)
	public void UserCanSearchWithAutoSearch() {
		try {
			searchPageObject = new SearchPage(driver);
			detailsObject = new ProductDetailsPage(driver);
			searchPageObject.productSearchWithAutoSearch(productNameAutoComplete);
			Assert.assertEquals(productName, detailsObject.productNameBreadCrumb.getText());
		} catch (Exception e) {
			System.out.println("Error ocuured  " + e.getMessage());
		}

	}

	@Test(priority = 2)
	public void userCanAddProductToShoppingCart() throws InterruptedException {
		detailsObject.addProductToCart();
		cartPageObject = new ShoppingCartPage(driver);

		Thread.sleep(1000);
		driver.navigate().to("https://demo.nopcommerce.com/cart");
		Assert.assertTrue(cartPageObject.totalLB1.getText().contains("3,600"));
	}

	@Test(priority = 3)
	public void guestCanCheckOutProduct() throws InterruptedException {
		checkObject = new CheckOutPage(driver);
		cartPageObject.openCheckOutPageAsAGuest();
		checkObject.guestCheckoutProduct(fName, lName,countryName, Email, 
				address, postCode, phone , city);
		Assert.assertTrue(checkObject.productName.isDisplayed());
		Assert.assertTrue(checkObject.productName.getText().contains(productName));
		Thread.sleep(1000);

		checkObject.confirmOrder();

		Assert.assertTrue(checkObject.thankYouLb1.isDisplayed());
		Thread.sleep(3000);
	}
	
	
	@Test(priority = 4)
	public void guestCanViewOrderDetails() throws InterruptedException
	{
		orderDetailsObject = new OrderDetailsPage(driver);
		checkObject.viewOrderDetails();
		
		Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));
		orderDetailsObject.downloadPDFinvoice();
		Thread.sleep(3000);
		orderDetailsObject.printOrderDetails();
		Thread.sleep(2000);
	}
}
