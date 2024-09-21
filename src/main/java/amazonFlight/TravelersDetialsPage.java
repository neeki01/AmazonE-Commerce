package amazonFlight;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TravelersDetialsPage {


	@FindBy(xpath="//div[@id='fl_tr_add']/div[@class='_7c598c35 colorLink d7c291ce']")
	WebElement addAdult;
	
	@FindBy(xpath="//div[@class='edb7cb84']/button")
	WebElement clickGender;
	
	@FindBy(xpath="(//div[@class='edb7cb84']/ul/li)[2]")
	WebElement selectGender;
	
	@FindBy(xpath="//div[@class='_1f3bc875']/input[@id='input-first_name']")
	WebElement addFirstName;
	
	@FindBy(xpath="//div[@class='_1f3bc875']/input[@id='input-last_name']")
	WebElement last_name;
	
	@FindBy(xpath="(//div[@id='fl_tr_cnf_change']/button)[1]")
	WebElement add;
	
	@FindBy(xpath="(//div[@id='fl_tr_delete']/div[@class='_8172d157 _6c913dd6 _16d013e2 _948be45e'])[2]")
	WebElement delete;
	
	@FindBy(xpath="//div[@class='_6dd480f7']//descendant::button")
	WebElement btnpayment;
	
	@FindBy(xpath="//div[@class='_1f3bc875']//child::input[@id='input-email']")
	WebElement email;
	
	@FindBy(xpath="(//div[@class='_49d43ddb _6078df67']//child::button)[1]")
	WebElement WindowOfDelete;
	
	@FindBy(xpath="(//div[@class='_4e0ac60f _9a75f8ae ad23ce76'])[2]")
	WebElement checkIfElementPresent;
	
	@FindBy(xpath="(//div[@class='c172d511']//descendant::i)[2]")
	WebElement selectPassenger;
	
	@FindBy(xpath="//div[@id='fl_tr_edit']/div[@class='fl_tr_editfl_tr_edit']")
	WebElement editbtn;
	
	public void AddAdult()
	{
		addAdult.click();
	}
	public void clickGenderbtn()
	{
		clickGender.click();
	}
	public void SelectGenderFemale()
	{
		selectGender.click();
	}
	public void AddFirstName()
	{
		addFirstName.sendKeys("Neeki");
	}
	public boolean verifyFirstName()
	{
		return addFirstName.isEnabled();
	}
	public void AddLastName()
	{
		last_name.sendKeys("Kumari");
	}
	public boolean verifySecondName()
	{
		return last_name.isEnabled();
	}
	public void addbtn()
	{
		add.click();
	}
	public void clickDelete()
	{
		delete.click();
	}
	public void ProceedPay()
	{
		btnpayment.click();
	}
	public void enterEmail()
	{
		email.sendKeys("neekitest@gmail.com");
	}
	public boolean verifyEmailBox()
	{
		return email.isEnabled();
	}
	public void clickDeleteOnWindow()
	{
		WindowOfDelete.click();
	}
	public boolean checkElement()
	{
		return checkIfElementPresent.isDisplayed();
	}
	public void selectName()
	{
		selectPassenger.click();
	}
	public void clickEditBtn()
	{
		editbtn.click();
	}
	public TravelersDetialsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
