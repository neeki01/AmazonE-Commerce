package amazon.Project;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AmazonProductSearchResult {

	@FindBy(xpath="(//div[@class='s-image-padding']//descendant::div[@class='a-section aok-relative s-image-tall-aspect']/img)[2]")
	WebElement product;
	
	@FindBy(xpath="//select[@id='s-result-sort-select']")
	WebElement SortBy;
	
	@FindBy(xpath = "//span[@class='a-dropdown-prompt']")
	WebElement result_sort;
	
	public boolean sortByFeature(String ref_var)
	{
		Select s=new Select(SortBy);
		s.selectByVisibleText(ref_var);
		return false;	
	}
	
	public WebElement sortResultStore()
	{
		return result_sort;
	}
	
	public void amazon_product()
	{
		product.click();
	}
	
	public AmazonProductSearchResult(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
