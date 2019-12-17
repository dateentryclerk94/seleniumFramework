package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ContactUSPage extends PageBase{

	public ContactUSPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id = "FullName")
	WebElement fullNameTxt;
	
	@FindBy(id = "Email")
	WebElement emailTxt;
	
	@FindBy(id = "Enquiry")
	WebElement enquiryTxt;
	
	@FindBy(name = "send-email")
	WebElement submitBtn;
	
	@FindBy(css = "div.result")
	public WebElement suceessMessg;
	
	public void contactUS(String fullName , String Email , String messg)
	{
	setTxtInsideTxtElement(fullNameTxt, fullName);
	setTxtInsideTxtElement(emailTxt, Email);
	setTxtInsideTxtElement(enquiryTxt, messg);
	clickButton(submitBtn);
	}
}
