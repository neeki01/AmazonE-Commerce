package amazonFlight;

import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	static WebDriver driver;
	
	@FindBy(id="nav-link-accountList")
	WebElement accountlist;
	
	@FindBy(xpath="//div[@class='_82328473']//descendant::span[@class='colorBase sizeMedium _8d2f006b _79bb5d49']")
	WebElement From_City;
	
	@FindBy(xpath="//input[@name='searchText']")
	WebElement EnterCity;

	@FindBy(xpath="//div[@class='edcbbbec _8b807b7c beb3e30d']//descendant::div[@class='_90aa3c07 a407febf _6078df67']")
	WebElement HoverToCity;
	
	@FindBy(xpath="(//div[@class='edcbbbec _8b807b7c beb3e30d']//descendant::div[@class='_90aa3c07 a407febf _6078df67']//child::p[@class='c9d6cfb6'])[1]")
	WebElement selectOption;
	
	@FindBy(xpath="//div[@class='_576acefe']/input[@name='searchText']")
	WebElement DestinationCity;
	
	@FindBy(xpath="(//div[@class='_4e0ac60f _360de181 ad23ce76']//descendant::p[@class='c9d6cfb6'])[1]")
	WebElement DestinationClick;
	
	@FindBy(xpath="//div[@class='_32608d65']")
	WebElement HoverToDestination;
	
	@FindBy(xpath="//div[@class='_79bb5d49']/span[@class='dcb9db95 colorBase sizeMedium']")
	WebElement FirstDate;
	
	@FindBy(xpath="(//div[@class='dafe1197']//descendant::i[@class='_4b539ab8'])[1]")
	WebElement onewWayTrip;
	@FindBy(xpath="(//div[@class='dafe1197']//descendant::i[@class='_4b539ab8'])[2]")
	WebElement twoWayTripradiobtn;
	
	@FindBy(xpath="//div[@class='_2a05878b']//descendant::div[@class='_898b66e5 _87c3834d']")
	WebElement nextBtnCal;
	
	@FindBy(xpath="(//div[@class='_75c05602']//descendant::span[@class='dcb9db95 colorBase sizeMedium'])[2]")
	WebElement return_day;
	
	@FindBy(xpath="(//div[@id='2_10-2024']//descendant::div[@class='_8bd51405']/ul/li)[10]")
	WebElement returnDate;
	
	@FindBy(xpath="(//div[@class='ba81534f']//descendant::div[@class='_0d9cc301'])[1]")
	WebElement searchResult;
	
	@FindBy(xpath="//div[@id='fl_lp_search']/button")
	WebElement searchBtn;
	
	@FindBy(xpath="//div[@class='sizeMedium a8cdd5cb']//following::span[@class='_79bb5d49 _0bba7dca']")
	WebElement Classtype;
	
	@FindBy(xpath="((//div[@class='edcbbbec _8b807b7c ']//descendant::div[@class='_90aa3c07 _8ce2b066 _6078df67'])//following::div[@class='dafe1197'])[1]")
	WebElement selectclass;
	
	@FindBy(xpath="//div[@class='_19a7792e']//descendant::div[@class='_9dcb1fb9 _50742bdc']")
	WebElement nosuchflight;
	
	@FindBy(xpath="(//div[@class='edcbbbec _8b807b7c ']//child::div[@class='ecbd2509 _769d5a4a _6078df67']/button)[2]")
	WebElement noOfPassengers;
	
	@FindBy(xpath="//div[@id='nav-al-your-account']//child::a[@id='nav-item-signout']")
	WebElement signOutBtn;
	
	@FindBy(xpath="(//div[@class='edcbbbec _8b807b7c ']//child::div[@class='ecbd2509 _769d5a4a _6078df67']/button)[1]")
	WebElement travler;
	
	public void Account_dropdown(WebDriver driver)
	{
		Actions a1=new Actions(driver);
		a1.moveToElement(accountlist).perform();
	}
	public void fromCity()
	{  
		From_City.click();
	}
	public WebElement fromcityelement()
	{
		return From_City;
	}
	public void EnterCity()
	{
		EnterCity.sendKeys("DEL");
	}
	public void HoverToCity(WebDriver driver)
	{
		Actions a1=new Actions(driver);
		a1.moveToElement(HoverToCity).perform();;
	}
	public void clickCityOption()
	{
		selectOption.click();
	}
	public void EnterDestinationCity()
	{
		DestinationCity.sendKeys("BOM");;
	}
	public void hoverToDestination(WebDriver driver)
	{
		Actions a1=new Actions(driver);
		a1.moveToElement(HoverToDestination);
	}
	public void clickDestination()
	{
		DestinationClick.click();
	}
	public void addFirstDate()
	{
		FirstDate.click();
	}
	public void selectReturnDay()
	{
		return_day.click();
	}
	public void clickSearchBtn()
	{
		searchBtn.click();
	}
	public void clickTwoWayRaiodBtn()
	{
		twoWayTripradiobtn.click();
	}
	public void returnFutureDate()
	{
		Date d1=new Date();
		long d=d1.getTime();
		
	}
	public void ClcikOnNextbtn()
	{
		nextBtnCal.click();
	}
	public void SelectReturnDate()
	{
		returnDate.click();
	}
	public String SearchReault()
	{
		return searchResult.getText();
	}
	public void classType()
	{
		Classtype.click();
	}
	public void SelectClass()
	{
		selectclass.click();
	}
	public void clickOneWayTrip()
	{
		onewWayTrip.click();
	}
	public boolean noSuchFlight()
	{
		return nosuchflight.isDisplayed();
	}
	public void selectNoOfPassengers()
	{
		noOfPassengers.click();
	}
	public void clickOnSignOutbtn()
	{
		signOutBtn.click();
	}
	public void clickTravler()
	{
		travler.click();
	}
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
