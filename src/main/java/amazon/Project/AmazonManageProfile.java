package amazon.Project;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonManageProfile {

	@FindBy(xpath="//span[@class='nav-line-2 ']")
	WebElement account_List;
	
	@FindBy(xpath="//div[@id='nav-al-your-account']//descendant::span[contains(text(),'Your Account')]")
	WebElement your_account;
	
	@FindBy(xpath="(//div[@class='a-box-inner'])[12]//descendant::li[4]/span[@class='a-list-item']")
	WebElement profile_link;
	
	@FindBy(xpath="//span[@class='a-button a-button-normal name-header-button name-header-edit-profile-button']")
	WebElement edit_profile;
//	
//	@FindBy(xpath="//input[@name='profile[name]']")
//	WebElement public_name;
	
	@FindBy(xpath="//span[@id='save-public-activity-announce']")
	WebElement save_btn;
	
	@FindBy(xpath="//div[@class='a-column a-span12 privacy-tab-container']//descendant::input[@id='profile_name']")
	WebElement profileName;
	
	@FindBy(xpath="//div[@class='a-alert-content']/span[@class='a-size-medium privacy-success-alert-msg']")
	WebElement save_verify;
	
	public void account_listHover(WebDriver driver)
	{
		Actions a1=new Actions(driver);
		a1.moveToElement(account_List).perform();
	}
	
	public void clickYourACcount()
	{
		your_account.click();
	}

	public WebElement goToProfileLink()
	{
		return profile_link;
	}
	public void clickProfile()
	{
		profile_link.click();
	}
	public void clickEditProfile()
	{
		edit_profile.click();;
	}
	
	public void editPublicName()
	{
		profileName.clear();
		profileName.sendKeys("Neeki Kumari");
	}
	public void clickSaveBtn()
	{
		save_btn.click();
	}
	public WebElement getProfileName()
	{
		return profileName;
	}
	public boolean verifyProfileNam()
	{
		return save_verify.isEnabled();
	}
	public AmazonManageProfile(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
