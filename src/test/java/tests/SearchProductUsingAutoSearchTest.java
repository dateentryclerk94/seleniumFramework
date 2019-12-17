package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductUsingAutoSearchTest extends TestBase{

	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	String productName = "Apple MacBook Pro 13-inch";
	String productNameAutoComplete = "mac";
	
	@Test
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
	
}
