package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderDetailsPage extends PageBase{

	public OrderDetailsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css = "a.button-2.print-order-button")
	WebElement printOrderBtn;
	
	@FindBy(css = "a.button-2.pdf-invoice-button")
	WebElement PDFinvoiceBtn;
	
	public void printOrderDetails()
	{
		clickButton(printOrderBtn);
	}

	public void downloadPDFinvoice()
	{
		clickButton(PDFinvoiceBtn);
	}
}
