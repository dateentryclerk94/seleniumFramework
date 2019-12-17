package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegisterationPage extends PageBase{

	public UserRegisterationPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(id = "gender-male")
	WebElement genderRdoBtn;
	
	@FindBy(id = "FirstName")
	WebElement fnTxtBox;
	
    @FindBy(id = "LastName")
    WebElement lnTxtBox;
    
    @FindBy(id = "Email")
    WebElement emailTxtBox;
    
    @FindBy(id = "Password")
    WebElement PasswordTxtBox;
    
    @FindBy(id = "ConfirmPassword")
    WebElement ConfirmPasswordTxtBox;
    
    @FindBy(id = "register-button")
    WebElement registerBtn;
    
    @FindBy(css = "div.result")
    public WebElement successMesg;
    
    @FindBy(linkText = "Log out")
    public WebElement logoutLink;

	//public Object successMessage;
    
   //@FindBy(linkText = "My account")
   //WebElement myAccountLink;
    
    public void userRegisteration(String firstName , String lastName ,
    		String email , String password)
    {
    	clickButton(genderRdoBtn);
    	setTxtInsideTxtElement(fnTxtBox,firstName);
    	setTxtInsideTxtElement(lnTxtBox,lastName);
    	setTxtInsideTxtElement(emailTxtBox,email);
    	setTxtInsideTxtElement(PasswordTxtBox,password);
    	setTxtInsideTxtElement(ConfirmPasswordTxtBox,password);
    	clickButton(registerBtn);
    }
    
    public void userLogOut()
    {
    	clickButton(logoutLink);
    }
    
    /*
    public void openMyAccountPage()
    {
    	clickButton(myAccountLink); 
    }
    */
}
