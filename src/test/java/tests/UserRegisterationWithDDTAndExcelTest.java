package tests;

import java.io.IOException;

import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationWithDDTAndExcelTest extends TestBase{

	HomePage homeObject;
	UserRegisterationPage registerPage;
	LoginPage loginObject;
	
	@DataProvider(name = "ExcelData")
	public Object[][] userRegisterationData() throws IOException
	{
		ExcelReader ER = new ExcelReader();
		return ER.getExcelData(); 
	}
	
	@Test(priority = 1 , dataProvider = "ExcelData")
	public void userCanRegisterSuccessfully(String fName , String lName ,
		String Email , String oldPassword)
	{
		homeObject = new HomePage(driver);
		homeObject.openRegisterationPage();
		
		registerPage = new UserRegisterationPage(driver);
		registerPage.userRegisteration(fName, lName, Email,
				oldPassword);
		Assert.assertTrue(registerPage.successMesg
				.getText()
				.contains("Your registration completed"));
		registerPage.userLogOut();
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.userLogin(Email, oldPassword);
		Assert.assertTrue(registerPage.logoutLink.isDisplayed());
		registerPage.userLogOut();
	}
	
}
