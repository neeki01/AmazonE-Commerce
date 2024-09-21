package amazonFlight;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

	@FindBy(xpath="(//div[@class='_0d5ac290']//child::button)[1]")
	WebElement Bookbtn;
	
	public void SelectBookbtn()
	{
		Bookbtn.click();
	}
	
	public SearchPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
}
