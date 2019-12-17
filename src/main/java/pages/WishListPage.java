package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends PageBase{

	public WishListPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "h1")
	public WebElement wishListHeader;
	
	@FindBy(name = "removefromcart")
	WebElement removeFromCartCheck;
	
	@FindBy(name = "updatecart")
	WebElement updateCartBtn;
	
	@FindBy(css = "td.product")
	public WebElement productCell;
	
	@FindBy(css = "div.no-data")
	public WebElement emptyCartLB1;
	
	public void removeProductFromWishList()
	{
		clickButton(removeFromCartCheck);
		clickButton(updateCartBtn);
	}
}
