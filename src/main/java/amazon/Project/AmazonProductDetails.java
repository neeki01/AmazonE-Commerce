package amazon.Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonProductDetails {


	@FindBy(xpath="//div[@class='a-section a-spacing-none aok-align-center aok-relative']//descendant::span[@class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay']")
	WebElement price;
	
	@FindBy(xpath="//span[@class='a-button-inner']//descendant::input[@id='add-to-cart-button']")
	WebElement cart_btn;
	
	@FindBy(xpath="//span[@class='a-button-inner']/input[@id='buy-now-button']")
	WebElement buy_now;
	
	@FindBy(xpath="(//div[@class='a-cardui-body']//descendant::div[@class='a-section headings-title'])[1]")
	WebElement offers;
	
	@FindBy(xpath="//div[@class='a-carousel-viewport']//descendant::div[@id='itembox-InstantBankDiscount']//descendant::h6")
	WebElement Offer;
	
	@FindBy(xpath="//div[@id='InstantBankDiscount-sideSheet']//following::header[@class='vsx-offers-desktop-lv__header']")
	WebElement slideBar;
	
	public boolean moveToChild()
	{
		return price.isDisplayed();
	}
	public void cartButton()
	{
		cart_btn.click();
	}
	
	public WebElement buyNow()
	{
		return buy_now;
	}
	public void clickBuyButton()
	{
		buy_now.click();
	}
	public String clickOffers()
	{
		return offers.getText();
	}
	
	public void clickOffers01()
	{
		Offer.click();
	}
	public String slideBar()
	{
		return slideBar.getText();
	}
	public AmazonProductDetails(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
