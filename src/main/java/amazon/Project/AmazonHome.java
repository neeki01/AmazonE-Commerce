package amazon.Project;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AmazonHome {
	
	static WebDriver driver;
	
	@FindBy(id="searchDropdownBox")
	WebElement Category;
	
	@FindBy(id="nav-link-accountList")
	WebElement accountlist;
	
	@FindBy(xpath="//div[@id='nav-flyout-ya-signin']//descendant::span[@class='nav-action-inner']")
	WebElement siginbutton;
	
	@FindBy(xpath="//a[@id='nav-item-signout']/span")
	WebElement signout;
	
	@FindBy(id="twotabsearchtextbox")
	WebElement search_product;
	
	@FindBy(xpath="//span[@class='a-button a-button-dropdown a-button-small']//descendant::span[@class='a-button-text a-declarative']")
	WebElement searchSuccessful;
	
	
//	@FindBy(tagName="a")
//	WebElement links;
	//step2
	public void Account_dropdown(WebDriver driver)
	{
		Actions a1=new Actions(driver);
		a1.moveToElement(accountlist).perform();
	}
	public void clickSignIn()
	{
		
		siginbutton.click();
	}
	public void clickSignOut()
	{
		
		signout.click();
	}
	public void search(String searchValue)
	{
		search_product.clear();
		search_product.sendKeys(searchValue+Keys.ENTER);
	}
	public boolean searchSuccessful()
	{
		return searchSuccessful.isDisplayed();
	}
	
	public void CategorySelection(String visibleText)
	{
		Select s1=new Select(Category);
		s1.selectByVisibleText(visibleText);
	}
	
	
	//step3
	
	public AmazonHome(WebDriver driver)
	
	{
		
		PageFactory.initElements(driver,this);
	}

	
	
}
