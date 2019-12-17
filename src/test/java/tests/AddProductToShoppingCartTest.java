package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;

public class AddProductToShoppingCartTest extends TestBase{

	SearchPage searchPageObject;
	ProductDetailsPage detailsObject;
	ShoppingCartPage cartPageObject;
	String productName = "Apple MacBook Pro 13-inch";
	String productNameAutoComplete = "mac";
	
	@Test(priority = 1)
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
	
	@Test(priority = 2)
	public void userCanAddProductToShoppingCart() throws InterruptedException
	{
		detailsObject.addProductToCart();
		cartPageObject = new ShoppingCartPage(driver);
		
		Thread.sleep(1000);
		driver.navigate().to("https://demo.nopcommerce.com/cart");
		Assert.assertTrue(cartPageObject.totalLB1
				.getText().contains("3,600"));
	}
	
	@Test(priority = 3)
	public void userCanRemoveProductFromShoppingCart()
	{
		cartPageObject.removeProductFromCart();
	}
}
