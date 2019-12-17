package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends PageBase{

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css=  "input.button-1.checkout-as-guest-button")
	WebElement checkOutAsGuest;
	
	@FindBy(name = "removefromcart")
	WebElement removeFromCartCheck;
	
	@FindBy(css = "input.qty-input")
	WebElement quantityText;
	
	@FindBy(css = "span.product-subtotal")
	public WebElement totalLB1;
	
	@FindBy(name = "updatecart")
	WebElement updateCartBtn;
	
	public void removeProductFromCart()
	{
		clickButton(removeFromCartCheck);
		clickButton(updateCartBtn);
	}
	
	@FindBy(id = "termsofservice")
	WebElement agreeCheckBox;
	
	@FindBy(id = "checkout")
	WebElement checkOutBtn;
    
	public void updateQuantityInCart(String quantity)
	{
		clearText(quantityText);
		setTxtInsideTxtElement(quantityText, quantity);
		clickButton(updateCartBtn);
	}
	
	public void openCheckOutPage()
	{
		clickButton(agreeCheckBox);
		clickButton(checkOutBtn);
	}
	
	public void openCheckOutPageAsAGuest()
	{
		clickButton(agreeCheckBox);
		clickButton(checkOutBtn);
		clickButton(checkOutAsGuest);
	}
}
