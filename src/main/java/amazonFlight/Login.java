package amazonFlight;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilityPackage.DDTConcept;

public class Login {
	
	public DDTConcept ddt=new DDTConcept();
	WebDriver driver;
	
	@FindBy(name="email")
	WebElement email_username;
	
	@FindBy(id="continue")
	WebElement continue_button;
	
	@FindBy(id="ap_password")
	WebElement password;
	
	@FindBy(id="signInSubmit")
	WebElement signInSubmit;
	
	@FindBy(xpath="//span[@class='nav-line-1 nav-progressive-content']")
	WebElement addressee;
	
	@FindBy(xpath="//div[@class='a-alert-content']/ul/li/span")
	WebElement wrongPassword;
	
	public void username(String sheetname, int row,int cell) throws EncryptedDocumentException, IOException 
	{
		String user_name=ddt.credentialsUsername(sheetname,row, cell);
		email_username.sendKeys(user_name);
	}
	public boolean verifyemail()
	{
		return email_username.isDisplayed();
	}
	public void continue_button()
	{
		continue_button.click();	
	}
	
	public void password_amazon(String sheetname, int row,int cell) throws EncryptedDocumentException, IOException
	{
		String password01=ddt.credentialsPass(sheetname, row, cell);
		password.sendKeys(password01);
	}
	
	public void signIn_Button()
	{
		signInSubmit.click();
	}
	public boolean wrongPasswordExpected()
	{
		return wrongPassword.isDisplayed();
	}
	public String Address_Shown()
	{  
		
		return addressee.getText();
		
	}
	public Login(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
