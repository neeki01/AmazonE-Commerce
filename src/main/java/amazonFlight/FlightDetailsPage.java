package amazonFlight;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FlightDetailsPage {

	
	@FindBy(xpath="//div[@id='fl_dt_cta']//descendant::a")
	WebElement ProceedPayment;
	
	@FindBy(xpath="//div[@class='d754b502 ']/div[@class='_7c598c35 ']")
	WebElement viewBaggageLink;
	
	@FindBy(xpath="//div[@class='_0d8acaa7']")
	WebElement tableTravler;
	
	@FindBy(xpath="(//div[@class='_383180cc']//descendant::div[@class='tabListInner'])[2]")
	WebElement cancelingClick;
	
	@FindBy(xpath="//div[@class='_4c1235c7 _5d17b3c7']")
	WebElement verifyCancelDetails;
	
	@FindBy(xpath="//div[@class='_6dd480f7']//descendant::div[@class='_7c598c35 a69d62e8']")
	WebElement clickFareLink;
	
	@FindBy(xpath="//div[@class='_78ac04ad dd749486']//descendant::div[@class='cf7081ff']")
	WebElement verifyFareDetails;
	
	@FindBy(xpath="(//div[@class='d1d03e67']//child::div[@class='_657d20b7 f54be1b2 _0c6150e5 _6078df67']/button)[1]")
	WebElement clickAddbtn;
	
	@FindBy(xpath="//div[@class='a82179ce']//descendant::span[@class='dcb9db95 _44cc784d a9212bfd']")
	WebElement verifyOfferApplied;
	
	@FindBy(xpath="//div[@class='_6dd480f7']//child::button[@class='_7e41f983 bba41d3c  _50baedd0  ada8b185 _6b9247a2']")
	WebElement nextBtn;
	
	
	
	public void ProceedPayment()
	{
		ProceedPayment.click();
	}
	public boolean viewBaggageLinkPresent()
	{
		return viewBaggageLink.isDisplayed();
	}
	public void clickViewBaggage()
	{
		viewBaggageLink.click();
	}
	public boolean verifyBuggageDetail()
	{
		return tableTravler.isDisplayed();
	}
	public void clickOnCancelBtn()
	{
		cancelingClick.click();
	}
	public boolean VerifyCancelTable()
	{
		return verifyCancelDetails.isDisplayed();
	}
	public void clickFareLink()
	{
		clickFareLink.click();
	}
	public boolean verifyAmountDetails()
	{
		return verifyFareDetails.isDisplayed();
	}
	public void verifyClickAddOffer()
	{
		clickAddbtn.click();
	}
	public String verifyAppliedOffer()
	{
		return verifyOfferApplied.getText();
	}
	public void clickNextBtn()
	{
		nextBtn.click();
	}
	
	public FlightDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
