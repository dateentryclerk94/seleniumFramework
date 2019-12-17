package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.WishListPage;

public class AddProductToWishListTest extends TestBase {

	SearchPage searchPageObject;
	ProductDetailsPage detailsObject;
	WishListPage wishListObject;

	String productName = "Apple MacBook Pro 13-inch";
	String productNameAutoComplete = "mac";

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
	public void userCanAddProductToWishList() {
		wishListObject = new WishListPage(driver);
		detailsObject.addProductToWishList();
		driver.navigate().to("https://demo.nopcommerce.com/wishlist");
		wishListObject = new WishListPage(driver);
		Assert.assertTrue(wishListObject.wishListHeader.isDisplayed());
		Assert.assertTrue(wishListObject.productCell.getText().contains(productName));
	}

	@Test(priority = 3)
	public void userCanRemoveProductFromWishList() {
		wishListObject.removeProductFromWishList();
		Assert.assertTrue(wishListObject.emptyCartLB1.getText().contains("The wishlist is empty!"));
	}

}
