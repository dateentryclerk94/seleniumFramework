package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase{

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css = "strong.current-item")
	public WebElement productNameBreadCrumb;
    
	@FindBy(css = "input.button-2.email-a-friend-button")
	public WebElement emailFriendBtn;
	
	@FindBy(css = "span.price-value-4")
	public WebElement productPriceLb1;
	
	@FindBy(linkText = "Add your review")
	public WebElement addReviewLink;
	
	@FindBy(id = "add-to-wishlist-button-4")
	WebElement addToWishListBtn;
	
	@FindBy(css = "input.button-2.add-to-compare-list-button")
	WebElement addToCompareBtn;
	
	@FindBy(id = "add-to-cart-button-4")
	WebElement addToCartBtn;
	
	public void openEmailFriend()
	{
		clickButton(emailFriendBtn);
	}
	
	public void openAddReviewPage()
	{
		clickButton(addReviewLink);
	}
	
	public void addProductToWishList()
	{
		clickButton(addToWishListBtn);
	}
	
	public void addProductToCompare()
	{
		clickButton(addToCompareBtn);
	}
	
	public void addProductToCart()
	{
		clickButton(addToCartBtn);
	}
	
}
