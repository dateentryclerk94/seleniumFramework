package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReviewPage extends PageBase{

	public ProductReviewPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id = "AddProductReview_Title")
	WebElement reviewTitle;
	
	@FindBy(id = "AddProductReview_ReviewText")
	WebElement reviewText;
	
	@FindBy(id = "addproductrating_4")
	WebElement review4RDOBtn;
	
	@FindBy(name = "add-review")
	WebElement submitReview;
	
	@FindBy(css = "div.result")
	public WebElement reviewMessg;
	
	public void addProductReview(String titleTxt , String reviewTxt)
	{
		setTxtInsideTxtElement(reviewTitle, titleTxt);
		setTxtInsideTxtElement(reviewText, reviewTxt);
		clickButton(review4RDOBtn);
		clickButton(submitReview);
	}
	
}
