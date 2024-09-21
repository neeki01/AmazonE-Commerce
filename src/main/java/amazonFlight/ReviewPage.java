package amazonFlight;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReviewPage {

	@FindBy(xpath="//div[@class='_6c913dd6 _70146f30']//descendant::i")
	WebElement checkBoxClick;
	
	@FindBy(xpath="//div[@class='_6c913dd6 _70146f30']//descendant::button")
	WebElement proceedToPay;
	
	public void clickCheckBox()
	{
		checkBoxClick.click();
	}
	public void clickOnProceedToPay()
	{
		proceedToPay.click();
	}
	public ReviewPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
