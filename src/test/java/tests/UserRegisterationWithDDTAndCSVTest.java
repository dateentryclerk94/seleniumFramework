package tests;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationWithDDTAndCSVTest extends TestBase{

	HomePage homeObject;
	UserRegisterationPage registerPage;
	LoginPage loginObject;
	
     CSVReader reader;
	
	@Test(priority = 1)
	public void userCanRegisterSuccessfully() throws IOException
	{
		String CSV_File = System.getProperty("user.dir") 
				+ "\\src\\test\\java\\data\\UserData.csv";
		reader = new CSVReader(new FileReader(CSV_File));
		String [] CSV_Cell;
		
		while((CSV_Cell = reader.readNext()) != null)
		{
			String finame = CSV_Cell[0];
			String laname = CSV_Cell[1];
			String e_mail = CSV_Cell[2];
			String Password = CSV_Cell[3];
			
			homeObject = new HomePage(driver);
			homeObject.openRegisterationPage();
			
			registerPage = new UserRegisterationPage(driver);
			registerPage.userRegisteration(finame, laname, e_mail,
					Password);
			Assert.assertTrue(registerPage.successMesg
					.getText()
					.contains("Your registration completed"));
			registerPage.userLogOut();
			homeObject.openLoginPage();
			loginObject = new LoginPage(driver);
			loginObject.userLogin(e_mail, Password);
			Assert.assertTrue(registerPage.logoutLink.isDisplayed());
			registerPage.userLogOut();
		}
		
	}

}
