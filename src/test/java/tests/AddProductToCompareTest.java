package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ComparePage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class AddProductToCompareTest  extends TestBase{

	String firstProductName  = "Apple MacBook Pro 13-inch";
	String firstProductNameAutoComplete  = "mac";
	String secondPrdouctName = "Asus N551JK-XO076H Laptop";
	String secondPrdouctNameAutoComplete = "Asus";
	
	HomePage homePageObject;
	SearchPage searchPageObject;
	ProductDetailsPage detailsObject;
	ComparePage compareObject;
	
	// 1- search for first product
	// 2- search for first product
	// 3- compare the two products
	// 4- clear compare list
	
	@Test(priority = 1)
	public void userCanCompareProducts() throws InterruptedException
	{
		homePageObject = new HomePage(driver);
		searchPageObject = new SearchPage(driver);
		detailsObject = new ProductDetailsPage(driver);
		compareObject = new ComparePage(driver);
		
		searchPageObject.productSearchWithAutoSearch(firstProductNameAutoComplete);
		Assert.assertTrue(detailsObject.productNameBreadCrumb
				.getText().contains(firstProductName));
		detailsObject.addProductToCompare();
		
		searchPageObject.productSearchWithAutoSearch(secondPrdouctNameAutoComplete);
		Assert.assertTrue(detailsObject.productNameBreadCrumb.
				getText().contains(secondPrdouctName));
		detailsObject.addProductToCompare();
		Thread.sleep(2000);
		
		driver.navigate().to("https://demo.nopcommerce.com/compareproducts");
		Assert.assertTrue(compareObject
				.Product1stInCompareListLastAdditionToCompare
				.getText().contains(secondPrdouctName));
		Assert.assertTrue(compareObject
				.product2ndInCompareListFirstAdditionToCompare
				.getText().contains(firstProductName));
		
		Thread.sleep(2000);
		
		compareObject.compareProducts();
	}
	
	@Test(priority = 2)
	public void userCanClearCompareList()
	{
		compareObject.clearCompareList();
		Assert.assertTrue(compareObject.noDataLB
				.getText()
				.contains("You have no items to compare."));
	}
}
