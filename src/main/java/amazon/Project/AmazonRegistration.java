package amazon.Project;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonRegistration {

	@FindBy(xpath="//div[@id='nav-flyout-ya-newCust']//following::a")
	WebElement register;
	
	@FindBy(xpath="//div[@class='a-row a-spacing-base']//following-sibling::input[@id='ap_customer_name']")
	WebElement username;
	
	
//	@FindBy(id="createAccount")
//	WebElement createAccount;
	
	@FindBy(xpath="//div[@class='a-fixed-left-grid-col a-col-right']/input[@id='ap_phone_number']")
	WebElement ph_no;
	
	@FindBy(id="ap_customer_name")
	WebElement customer_name;
	
	@FindBy(xpath="//div[@class='a-row a-spacing-base']//following::input[@id='ap_password']")
	WebElement customer_password;
	
	@FindBy(xpath="//span[@class='a-button-inner']//following::input[@id='continue']")
	WebElement OTP_Button;
	
	@FindBy(xpath="(//div[@class='a-section']//following-sibling::a[@class='a-link-normal'])[3]")
	WebElement Verify_condition;
	
	public void register_user()
	{
		register.click();
	}
	public void user_name()
	{
		username.sendKeys("Neeki");
	}
//	public void continue_button()
//	{
//		continue_btn.click();
//	}
//	public void CreateAccount()
//	{
//		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		createAccount.click();;
//	}
	public void phoneNo()
	{
		//ph_no.clear();
		ph_no.sendKeys("8130945891");
	}
	public void Customer_Password()
	{
		customer_password.sendKeys("NK456@123");
	}
	public void otp_continue()
	{
		OTP_Button.click();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	public boolean verify_Condition()
	{
		return Verify_condition.isDisplayed();
	}
	public AmazonRegistration(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
