package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage extends PageBase{

	public CheckOutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
		
	@FindBy(id = "BillingNewAddress_FirstName")
	WebElement firstName;
	
	@FindBy(id = "BillingNewAddress_LastName")
	WebElement lastname;
	
	@FindBy(id = "BillingNewAddress_Email")
	WebElement emailTxt;
	
	@FindBy(id = "BillingNewAddress_CountryId")
	WebElement countryList;
	
	@FindBy(id = "BillingNewAddress_City")
	WebElement cityBox;
	
	@FindBy(id = "BillingNewAddress_Address1")
	WebElement Address1;
	
	@FindBy(id = "BillingNewAddress_ZipPostalCode")
	WebElement zipCode;
	
	@FindBy(id = "BillingNewAddress_PhoneNumber")
	WebElement phoneNumber;
	
	@FindBy(xpath = "//*[@id=\"billing-buttons-container\"]/input")
	WebElement continueBtn;
	
	@FindBy(id = "shippingoption_1")
	WebElement shippingMethodRdo;
	
	@FindBy(xpath = "//*[@id=\"shipping-method-buttons-container\"]/input")
	WebElement shippingMethodContinueBtn;
    
	@FindBy(xpath = "//*[@id=\"payment-method-buttons-container\"]/input")
	WebElement paymentMethodContinueBtn;
	
	@FindBy(xpath = "//*[@id=\"payment-info-buttons-container\"]/input")
	WebElement paymentInformationContinueBtn;
	
	@FindBy(css = "a.product-name")
	public WebElement productName;
	
	@FindBy(css = "input.button-1.confirm-order-next-step-button")
	WebElement confirmBtn;
	
	@FindBy(css = "h1")
	public WebElement thankYouLb1;
	
	@FindBy(css = "div.title")
	public WebElement successMessg;
	
	@FindBy(linkText = "Click here for order details.")
	WebElement orderDetailsLink;
	
	@FindBy(css = "input.button-1.order-completed-continue-button")
	WebElement lastContinue;
	
	public void RegisteredUserCanCheckOutProduct(String countryName ,
			String address , String postCode , String phone ,
			String city , String ProductName) throws InterruptedException
	{
	   selectOption = new Select(countryList);
	   selectOption.selectByVisibleText(countryName);
	   
	   setTxtInsideTxtElement(cityBox, city);
	   setTxtInsideTxtElement(Address1, address);
	   setTxtInsideTxtElement(zipCode, postCode);
	   setTxtInsideTxtElement(phoneNumber, phone);
	   
	   clickButton(continueBtn);
	   clickButton(shippingMethodRdo);
	   clickButton(shippingMethodContinueBtn);
	   Thread.sleep(1000);
	   
	   clickButton(paymentMethodContinueBtn);
	   Thread.sleep(1000);
	   clickButton(paymentInformationContinueBtn); 
	   Thread.sleep(1000);
	}
	   
	public void confirmOrder() throws InterruptedException
	{
		Thread.sleep(1000);
		clickButton(confirmBtn);
	}
	
	public void viewOrderDetails()
	{
      clickButton(orderDetailsLink);		
	}
	
	public void guestCheckoutProduct(String fName , String lName 
			, String countryName  , String email ,  String address
			,  String postcode , String phoneNum ,  
			String city) throws InterruptedException
	{
	 setTxtInsideTxtElement(firstName, fName);
	 setTxtInsideTxtElement(lastname, lName);
	 setTxtInsideTxtElement(emailTxt, email);
	 selectOption = new Select(countryList);
	 selectOption.selectByVisibleText(countryName);
	 setTxtInsideTxtElement(cityBox, city);
	 setTxtInsideTxtElement(Address1, address);
	 setTxtInsideTxtElement(zipCode, postcode);
	 setTxtInsideTxtElement(phoneNumber, phoneNum);
	 
	 clickButton(continueBtn);
	 
	 clickButton(shippingMethodRdo);
	 clickButton(shippingMethodContinueBtn);
	 Thread.sleep(1000);
	 
	 clickButton(paymentMethodContinueBtn);
	 Thread.sleep(1000);
	 
	 clickButton(paymentInformationContinueBtn);
	 Thread.sleep(1000);
   	}
}
