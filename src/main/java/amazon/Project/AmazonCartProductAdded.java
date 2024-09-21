package amazon.Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonCartProductAdded {

	
	@FindBy(xpath="//input[@name='proceedToRetailCheckout']")
	WebElement result01;
	
	@FindBy(xpath="//span[@class='a-button a-spacing-top-base a-button-span12 a-button-base celwidget']/span/a[@class='a-button-text']")
	WebElement go_toCart;
	
	public boolean result()
	{
		boolean display_cart=result01.isDisplayed();
		return display_cart;
	}
	public void goToCartBtn()
	{
		go_toCart.click();
	}
	
	public AmazonCartProductAdded(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
}
