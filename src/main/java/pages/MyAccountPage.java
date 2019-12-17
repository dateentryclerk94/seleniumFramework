package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase{

	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(linkText = "My account")
	WebElement myAccountLinkPage;
	
	@FindBy(linkText = "Change password")
	WebElement changePasswordLink;
	
	@FindBy(id = "OldPassword")
	WebElement OldPasswordTxtBox;
	
	@FindBy(id = "NewPassword")
	WebElement NewPasswordTxtBox;
	
	@FindBy(id= "ConfirmNewPassword")
	WebElement ConfirmNewPasswordTxtBox;
	
	@FindBy(css = "input.button-1.change-password-button")
	WebElement changePasswordBtn;
	
	@FindBy(css = "div.result")
	public WebElement resultlb1;
	
	public void openChangePasswordPage()
	{
		clickButton(myAccountLinkPage);
	}
	
	public void openChangePasswordLink()
	{
		clickButton(changePasswordLink);
	}
	
	public void changePassword(String oldPass , String newPass)
	{
		setTxtInsideTxtElement(OldPasswordTxtBox, oldPass);
		setTxtInsideTxtElement(NewPasswordTxtBox, newPass);
		setTxtInsideTxtElement(ConfirmNewPasswordTxtBox, newPass);
		clickButton(changePasswordBtn);
	}
	

}
