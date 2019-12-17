package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class ChangeCurrencyTest extends TestBase{
 
	HomePage homeObject;
	ProductDetailsPage detailsObject;
	
	SearchPage searchObject;
	String productName = "Apple MacBook Pro 13-inch";
	String productNameAutoComplete = "mac";
	
	@Test(priority = 1)
	public void UserCanSearchWithAutoSearch()
	{
		try {
			searchObject = new SearchPage(driver);
			detailsObject = new ProductDetailsPage(driver);
			searchObject.productSearchWithAutoSearch(productNameAutoComplete);
			Assert.assertEquals(productName, 
					detailsObject.productNameBreadCrumb.getText());
		} catch (Exception e) {
			System.out.println("Error ocuured  " + e.getMessage());
		}
		
	}
	
	@Test(priority = 2)
	public void userCanChangeCurrency() 
	{
		homeObject = new HomePage(driver);
		detailsObject = new ProductDetailsPage(driver);	
		homeObject.changeCurrecny();
		Assert.assertTrue(detailsObject.productPriceLb1
				.getText()
				.contains("Ђ"));
		System.out.println(detailsObject.productPriceLb1.getText());
	}
}
