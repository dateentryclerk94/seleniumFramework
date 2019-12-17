package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase{

	public HomePage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver;
		actionOption = new Actions(driver);
	}
	
	@FindBy(linkText="Register")
	WebElement registerLink;
	
	@FindBy(linkText = "Log in")
	WebElement loginBtn;
	
	@FindBy(linkText = "Contact us")
	WebElement contactUSLink;
	
	@FindBy(id = "customerCurrency")
	public WebElement changeCustomerCurrency;
	
	@FindBy(linkText="Computers")
	WebElement ComputerMenu; 
	
	@FindBy(linkText="Notebooks")
	WebElement NotbooksMenu;
	
	public void openRegisterationPage()
	{
		registerLink.click();
	}
	
	public void openLoginPage()
	{
		clickButton(loginBtn);
	}

	public void openContactUSPage()
	{
		scrollToBottom();
		clickButton(contactUSLink);
	}
	
	public void changeCurrecny()
	{
		selectOption = new Select(changeCustomerCurrency);
		selectOption.selectByVisibleText("Euro");
	}
	
	public void selectNoteBooksMenu()
	{
		 actionOption
		.moveToElement(ComputerMenu)
		.moveToElement(NotbooksMenu)
		.click()
		.build()
		.perform();
	}
}
