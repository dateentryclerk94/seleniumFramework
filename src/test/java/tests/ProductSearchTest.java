package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class ProductSearchTest extends TestBase{

	String prdouctName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	
	@Test
	public void userCanSearchForProduct()
	{
		searchObject = new SearchPage(driver);
		detailsObject = new ProductDetailsPage(driver);
		searchObject.productSearch(prdouctName);
		searchObject.openProductDeatilsPage();
		Assert.assertTrue(detailsObject.productNameBreadCrumb
			.getText()
		    .equalsIgnoreCase(prdouctName));
		//Assert.assertEquals(prdouctName, 
				//detailsObject.productNameBreadCrumb.getText());
	}
}
