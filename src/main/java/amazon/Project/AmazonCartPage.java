package amazon.Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class AmazonCartPage {

	@FindBy(xpath="//select[@name='quantity']")
	WebElement qnty;	
	
	@FindBy(xpath="//div[@class='a-row a-spacing-mini sc-subtotal sc-subtotal-activecart sc-java-remote-feature']/span[@class='a-size-medium sc-number-of-items']")
	WebElement Subtotal;
	
	@FindBy(xpath="//input[@name='submit.delete.aaa1a7a4-be36-4d42-a584-190e0328bac7']")
	WebElement delete;
	
	
	public void clickQuantity(int item_count)
	{
		Select s1=new Select(qnty);
		s1.selectByIndex(item_count);
	}
	public String Subtotal()
	{
		return Subtotal.getText();
	}
	
	public void deleteProduct()
	{
		delete.click();
	}
	public AmazonCartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
