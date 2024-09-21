package amazon.Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AmazonCheckoutPage {

	
	@FindBy(xpath="//h3[@class='a-color-base clickable-heading expand-collapsed-panel-trigger']")
	WebElement address;
	
	@FindBy(xpath="(//div[@class='a-column a-span5']/span)[1]")
	WebElement useAddress;
	
	@FindBy(xpath="(//div[@class='a-fixed-left-grid-col a-col-left']//child::input[@name='ppw-instrumentRowSelection'])[3]")
	WebElement paymentOtherUPI;
	
	@FindBy(xpath="(//div[@class='a-fixed-left-grid-col a-col-left']//child::input[@name='ppw-instrumentRowSelection'])[5]")
	WebElement COD;
	
	@FindBy(xpath="(//div[@class='a-fixed-left-grid-col a-col-left']//child::input[@name='ppw-instrumentRowSelection'])[2]")
	WebElement Net_banking;
	
	@FindBy(xpath="((//optgroup)[1]/option)//ancestor::select[@name='ppw-bankSelection_dropdown']")
	WebElement optionNetBanking;
	
	@FindBy(xpath="//span[@class='pmts-instrument-selector']//descendant::input")
	WebElement card;
	
	@FindBy(xpath="(//span[@class='a-declarative'])[8]//descendant::img[1]")
	WebElement addCards;
	
	@FindBy(xpath="//iframe[@name='ApxSecureIframe']")
	WebElement frame;
	
	@FindBy(xpath="//div[@class='a-section a-spacing-none apx-add-credit-card-number']/input[@name='addCreditCardNumber']")
	WebElement card_number;
	
	@FindBy(xpath="//div[@class='a-column a-span8 pmts-customer-card-name-input-box a-span-last']//child::input")
	WebElement nik_name;
	
	@FindBy(xpath="//span[@class='a-button-inner']//following::input[@name='ppw-widgetEvent:SetPaymentPlanSelectContinueEvent']")
	WebElement paymentMethod;
	
	@FindBy(xpath="//option//parent::select[@name='ppw-expirationDate_month']")
	WebElement expiry_Month;
	
	@FindBy(xpath="//option//parent::select[@name='ppw-expirationDate_year']")
	WebElement expiry_year;
	
	@FindBy(xpath="//span[@class='a-button-inner']/button[@name='ppw-widgetEvent:CancelAddCreditCardEvent']")
	WebElement cancle_card;
	
	@FindBy(xpath="//td[@class='a-color-price a-size-medium a-text-bold']/span")
	WebElement order_details;
	
	@FindBy(xpath="//span[@class='a-button-text']/span[@class='os-primary-action-button-text buy-button-line-height']")
	WebElement usePayementMethodbt;
	public void addressSelect()
	{
		address.click();
	}
	public WebElement useAddress()
	{
		return address;
	}
	
	public void addAddress()
	{
		useAddress.click();
	}
	public WebElement waitAddAddress()
	{
		return useAddress;
	}
	public WebElement waitPayment()
	{
		return paymentOtherUPI;
	}
	public WebElement paymentUPI()
	{
		paymentOtherUPI.click();
		return paymentOtherUPI;
	}
	public WebElement clickOnCOD()
	{
		COD.click();
		return COD;
	}
	public WebElement clickNetBanking()
	{
		Net_banking.click();
		return Net_banking;
	}
	public void selectSBIbank(String option)
	{
		Select s1=new Select(optionNetBanking);
		s1.selectByVisibleText(option);
	}
	public WebElement cardSelect()
	{
		card.click();
		return card;
	}
	public WebElement addDifferentCards()
	{
		addCards.click();
		return addCards;
	}
	public WebElement waitPaymentMethod()
	{
		return paymentMethod;
		//return paymentMethod;
	}
	public WebElement clickPaymentMethod()
	{
		paymentMethod.click();
		return paymentMethod;
	}
	public WebElement moveToiFrame()
	{
		return frame;
	}
	public boolean orderDetails()
	{
		return order_details.isDisplayed();
	}
	public void addCardNumber()
	{
		card_number.sendKeys("4569 55698 1234 1489");
	}
	public void nick_name()
	{
		nik_name.clear();
		nik_name.sendKeys("Neeki Kumari");
	}
	public void expiryMonth()
	{
		Select s1=new Select(expiry_Month);
		s1.selectByVisibleText("12");
	}
	public void expiryYear()
	{
		Select s1=new Select(expiry_year);
		s1.selectByVisibleText("2030");
	}
	public void cancelCardDetails()
	{
		cancle_card.click();
	}
	public boolean clickUsePaymentbtn()
	{
		return usePayementMethodbt.isEnabled();
	}
	public AmazonCheckoutPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
