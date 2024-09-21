package amazonFlight;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PaymentPage {

	@FindBy(xpath="//div[@class='a-fixed-left-grid-inner']//descendant::input[@name='ppw-instrumentRowSelection']")
	WebElement cardOptionselect;
	
	@FindBy(xpath="(//div[@class='a-box-inner a-padding-small'])[2]")
	WebElement frameMove;
	
	@FindBy(xpath="//div[@class='a-section a-spacing-none pmts-inline-field-block']//input[@name='ppw-accountHolderName']")
	WebElement addName;
	
	@FindBy(xpath="//div[@class='a-section a-spacing-none pmts-inline-field-block']//input[@name='addCreditCardNumber']")
	WebElement addcardNumber;
	
	@FindBy(xpath="//div[@class='a-section pmts-add-credit-card-component-container']//descendant::select[@name='ppw-expirationDate_month']")
	WebElement expirationMonth;
	
	@FindBy(xpath="//div[@class='a-section pmts-add-credit-card-component-container']//descendant::select[@name='ppw-expirationDate_year']")
	WebElement expirationYear;
	
	@FindBy(xpath="//div[@class='a-section pmts-add-credit-card-component-container']//descendant::input[@class='a-button-input']")
	WebElement clickAddDetails;
	
	@FindBy(xpath="//input[@name='addCreditCardVerificationNumber']")
	WebElement cvv;
	
	@FindBy(xpath="//span[@id='pp-sF3zII-162']")
	WebElement clickPay;
	
	public void clickOnCardPaymentOption()
	{
		cardOptionselect.click();
	}
	public WebElement moveToFrame()
	{
		return frameMove;
	}
	public void enterName()
	{
		addName.clear();
		addName.sendKeys("Neeki Kumari");
	}
	public void enterCardNumber()
	{
		addcardNumber.sendKeys("6522 9402 63861 935");
	}
	public void expirationMonthVerify()
	{
		Select s=new Select(expirationMonth);
		s.selectByVisibleText("11");
	}
	public void expirationYearVerify()
	{
		Select s=new Select(expirationYear);
		s.selectByVisibleText("2026");
	}
	public void clickAddDetailsbtn()
	{
		clickAddDetails.click();
	}
	public void addCVV()
	{
		cvv.sendKeys("123");
	}
	public boolean verifyPay()
	{
		return cardOptionselect.isSelected();
	}
	public PaymentPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
