package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

public class ProductHoverMenuTest extends TestBase{

	HomePage homeObject;
	
	@Test(priority = 1)
	public void userCanSelectSubCategoryFromMainMenu() throws InterruptedException
	{
		homeObject = new HomePage(driver);
		homeObject.selectNoteBooksMenu();
		Thread.sleep(1000);
		Assert.assertTrue(driver.getCurrentUrl()
				.contains("notebook"));
	}
}
