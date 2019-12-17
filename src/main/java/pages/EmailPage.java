package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailPage extends PageBase{

	public EmailPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id = "FriendEmail")
	WebElement friendEmailTxt;
	
	@FindBy(id = "PersonalMessage")
	WebElement personalMessageTxt;
	
	@FindBy(name = "send-email")
	WebElement sendEmailTxt;
	
	@FindBy(css = "div.result")
	public WebElement successMessg;
	
	public void sendEmailToFriend(String friendEmail , String message)
	{
		setTxtInsideTxtElement(friendEmailTxt, friendEmail);
		setTxtInsideTxtElement(personalMessageTxt, message);
		clickButton(sendEmailTxt);
	}

}
