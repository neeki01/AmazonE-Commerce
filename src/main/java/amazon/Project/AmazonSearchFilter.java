package amazon.Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AmazonSearchFilter {
	static WebDriver driver;
	
	
	
	@FindBy(xpath="(//div[@class='sg-col-inner'])[6]/div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_1']")
	WebElement searchresult;
	
	@FindBy(xpath="//span[@id='a-autoid-1']")
	WebElement cart_btn;
	
	@FindBy(xpath="//li[@id='p_123/456549']/span/a/div/label/input/i[@class='a-icon a-icon-checkbox']")
	WebElement brands;
	
	@FindBy(xpath="//span[@class='a-size-base-plus a-color-base a-text-normal'][1]")
	WebElement product_brand;
	
	
	
	public String searchResult()
	{
		return searchresult.getText();
	}
	public boolean cartBtnIsPresent()
	{
		return cart_btn.isDisplayed();
	}
//	public String brandsDisplayed()
//	{
//		brands.click();
//		
//		return brands.getText();
//	}
//	public String productBrand()
//	{
//		return product_brand.getText();
//	}
	
	
	public AmazonSearchFilter(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


}
