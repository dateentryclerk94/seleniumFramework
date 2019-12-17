package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComparePage  extends PageBase{

	public ComparePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(css = "a.clear-list")
	WebElement clearList;
	
	@FindBy(css = "table.compare-products-table")
	WebElement comparingTable;
	
	@FindBy(tagName = "tr")
	public List<WebElement> allRows;
	
	@FindBy(tagName = "td")
	public List<WebElement> allCols;
	
	@FindBy(css = "div.no-data")
	public WebElement noDataLB;
	
	@FindBy(linkText = "Asus N551JK-XO076H Laptop")
	public WebElement Product1stInCompareListLastAdditionToCompare;
	
	@FindBy(linkText = "Apple MacBook Pro 13-inch")
	public WebElement product2ndInCompareListFirstAdditionToCompare;
	
	
	public void clearCompareList()
	{
		clickButton(clearList);
	}
	
	public void compareProducts()
	{
		System.out.println(allRows.size());
		for(WebElement row : allRows)
		{
			System.out.println(row.getText() + "\t");
			
			for(WebElement col : allCols)
			{
				System.out.println(col.getText() + "\t");	
			}
			System.out.print("-----------------------\n");
		}
	}
	
}
