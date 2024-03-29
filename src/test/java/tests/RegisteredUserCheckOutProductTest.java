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

public class RegisteredUserCheckOutProductTest extends TestBase{

	HomePage homePageObject;
	UserRegisterationPage regsiterObject;
	LoginPage loginObject;
	SearchPage searchPageObject;
	ProductDetailsPage detailsObject;
	ShoppingCartPage cartPageObject;
	CheckOutPage checkObject;
	OrderDetailsPage orderDetailsObject;
	
	String fName = "one";
	String lName = "two";
	String Email = "pq1lc00810@gmail.com";
	String oldPassword = "123nm4";
	String newPassword = "124nm5";
	
	String productName = "Apple MacBook Pro 13-inch";
	String productNameAutoComplete = "mac";
	
	String countryName = "Egypt";
	String address = "test address";
	String postCode = "215712";
	String phone = "58757654";
	String city = "Cairo";
	
	
	// 1- user registered
	
	@Test(priority = 1)
	public void userCanRegisterSuccessfully()
	{
		homePageObject = new HomePage(driver);
		homePageObject.openRegisterationPage();
		
		regsiterObject = new UserRegisterationPage(driver);
		regsiterObject.userRegisteration(fName, lName, Email,
				oldPassword);
		Assert.assertTrue(regsiterObject.successMesg
				.getText()
				.contains("Your registration completed"));
	}
	
	// 2- search 
	
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
	
	// 3- add to cart 
	@Test(priority = 3)
	public void userCanAddProductToShoppingCart() throws InterruptedException
	{
		detailsObject.addProductToCart();
		cartPageObject = new ShoppingCartPage(driver);
		
		Thread.sleep(1000);
		driver.navigate().to("https://demo.nopcommerce.com/cart");
		Assert.assertTrue(cartPageObject.totalLB1
				.getText().contains("3,600"));
	}
	
	
	// 4- check out 
	@Test(priority = 4)
	public void userCanCheckOutProduct() throws InterruptedException
	{
		checkObject = new CheckOutPage(driver);
		cartPageObject.openCheckOutPage();
		checkObject.RegisteredUserCanCheckOutProduct
		(countryName, address, postCode, phone, city, productName);
		
		Assert.assertTrue(checkObject.productName.isDisplayed());
		   Assert.assertTrue(checkObject.productName
				   .getText().contains(productName));
		   Thread.sleep(1000);
		   
		   checkObject.confirmOrder();
		   
		   Assert.assertTrue(checkObject.thankYouLb1.isDisplayed());
		   Thread.sleep(1000);
		   
		   checkObject.viewOrderDetails();
		   
		   Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));
		   
		   orderDetailsObject = new OrderDetailsPage(driver);
		   orderDetailsObject.downloadPDFinvoice();
		   orderDetailsObject.printOrderDetails();
	}
	
	
	// 5- logout 
	@Test(priority = 5)
	public void RegisteredUserCanLogOut()
	{
		regsiterObject.userLogOut();
	}
	
	
}
