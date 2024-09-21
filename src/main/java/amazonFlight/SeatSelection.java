package amazonFlight;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeatSelection {

	@FindBy(xpath="//div[@id='fl_sl_selected_tab']//child::li")
	WebElement clcikBOM;
	
	@FindBy(xpath="(//div[@class='_2aceb697 ']//descendant::button)[2]")
	WebElement YesProceed;
	
	public boolean clickBomTab()
	{
		return clcikBOM.isDisplayed();
	}
	public void clickNextProceed()
	{
		YesProceed.click();
	}
	public SeatSelection(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
