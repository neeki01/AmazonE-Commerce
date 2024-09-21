package amazon.ProjectTest;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import amazon.Project.AmazonCheckoutPage;
import amazon.Project.AmazonHome;
import amazon.Project.AmazonLogin;
import amazon.Project.AmazonProductDetails;
import amazon.Project.AmazonProductSearchResult;

@Listeners(utilityPackage.IListnersAmazon.class)
public class TC_12_AmazonPaymentMethodSelectAll extends Launch_Quit{

	@Test(priority=3)
	public void usingCODOption() throws EncryptedDocumentException, IOException
	{
		AmazonHome home=new AmazonHome(driver);
		home.Account_dropdown(driver);
		home.clickSignIn();
		
		AmazonLogin login=new AmazonLogin(driver);
		login.username("login", 0, 0);
		login.continue_button();
		login.password_amazon("login", 0, 1);
		login.signIn_Button();
		
		
		home.search("earing");
		
		AmazonProductSearchResult product=new AmazonProductSearchResult(driver);
		product.amazon_product();
		
		Set<String> ids=driver.getWindowHandles();
		Iterator<String> id=ids.iterator();
		String parent_id=id.next();
		String child_id=id.next();
		
		driver.switchTo().window(child_id);
		
		AmazonProductDetails productBuy=new AmazonProductDetails(driver);
		productBuy.clickBuyButton();
		
		
		
		AmazonCheckoutPage checkoutAddress=new AmazonCheckoutPage(driver);
		
		WebElement a2=checkoutAddress.waitPayment();
		WebDriverWait wait01=new WebDriverWait(driver,Duration.ofSeconds(15));
		wait01.until(ExpectedConditions.visibilityOf(a2));
		
		
		WebElement e1=checkoutAddress.clickOnCOD();
		if(e1.isSelected())
		{
			boolean ans=checkoutAddress.clickUsePaymentbtn();
			Assert.assertEquals(ans, true,"Test case failed");
		}
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
		wait01.until(ExpectedConditions.visibilityOf(a2));
		
//		WebElement a=checkoutAddress.moveToiFrame();
//		
////		WebDriverWait wait02=new WebDriverWait(driver,Duration.ofSeconds(15));
////		wait01.until(ExpectedConditions.visibilityOf(a));
////		
//		driver.switchTo().frame(a);
//		
//		checkoutAddress.addCardNumber();
//		checkoutAddress.nick_name();
//		checkoutAddress.expiryMonth();
//		checkoutAddress.expiryYear();
//		checkoutAddress.cancelCardDetails();
//		
//		driver.switchTo().defaultContent();
		WebElement e2=checkoutAddress.cardSelect();
		if(e2.isSelected())
		{
			boolean ans=checkoutAddress.clickUsePaymentbtn();
			Assert.assertEquals(ans, true,"Test case failed");
		}
		WebElement e3=checkoutAddress.clickNetBanking();
		if(e3.isSelected())
		{
			checkoutAddress.selectSBIbank("HDFC Bank");
			
			boolean ans=checkoutAddress.clickUsePaymentbtn();
			Assert.assertEquals(ans, true,"Test case failed");
		}
		
		WebElement e4=checkoutAddress.paymentUPI();
		if(e4.isSelected())
		{
			boolean ans=checkoutAddress.clickUsePaymentbtn();
			Assert.assertEquals(ans, true,"Test case failed");
		}
		
		
		
	}
	/*
	@Test(priority=0)
	public void payUsingcards() throws EncryptedDocumentException, IOException
	{
		AmazonHome home=new AmazonHome(driver);
		home.Account_dropdown(driver);
		home.clickSignIn();
		
		AmazonLogin login=new AmazonLogin(driver);
		login.username("login", 0, 0);
		login.continue_button();
		login.password_amazon("login", 0, 1);
		login.signIn_Button();
		
		
		home.search("earing");
		
		AmazonProductSearchResult product=new AmazonProductSearchResult(driver);
		product.amazon_product();
		
		Set<String> ids=driver.getWindowHandles();
		Iterator<String> id=ids.iterator();
		String parent_id=id.next();
		String child_id=id.next();
		
		driver.switchTo().window(child_id);
		
		AmazonProductDetails productBuy=new AmazonProductDetails(driver);
		productBuy.clickBuyButton();
		AmazonCheckoutPage checkoutAddress=new AmazonCheckoutPage(driver);
		checkoutAddress.cardSelect();
		checkoutAddress.addDifferentCards();
		
		WebElement a2=checkoutAddress.waitPayment();
		WebDriverWait wait01=new WebDriverWait(driver,Duration.ofSeconds(15));
		wait01.until(ExpectedConditions.visibilityOf(a2));
		
		WebElement a=checkoutAddress.moveToiFrame();
		driver.switchTo().frame(a);
		
		checkoutAddress.addCardNumber();
		checkoutAddress.nick_name();
		checkoutAddress.expiryMonth();
		checkoutAddress.expiryYear();
		checkoutAddress.cancelCardDetails();
		
		driver.switchTo().defaultContent();
		
		boolean ans=checkoutAddress.clickUsePaymentbtn();
		Assert.assertEquals(ans, true,"Test case failed");
	}
	@Test(priority=1)
	public void usingNetBanking() throws EncryptedDocumentException, IOException
	{
		AmazonHome home=new AmazonHome(driver);
		home.Account_dropdown(driver);
		home.clickSignIn();
		
		AmazonLogin login=new AmazonLogin(driver);
		login.username("login", 0, 0);
		login.continue_button();
		login.password_amazon("login", 0, 1);
		login.signIn_Button();
		
		
		home.search("earing");
		
		AmazonProductSearchResult product=new AmazonProductSearchResult(driver);
		product.amazon_product();
		
		Set<String> ids=driver.getWindowHandles();
		Iterator<String> id=ids.iterator();
		String parent_id=id.next();
		String child_id=id.next();
		
		driver.switchTo().window(child_id);
		
		AmazonProductDetails productBuy=new AmazonProductDetails(driver);
		productBuy.clickBuyButton();
		AmazonCheckoutPage checkoutAddress=new AmazonCheckoutPage(driver);
		checkoutAddress.clickNetBanking();
		checkoutAddress.selectSBIbank("HDFC Bank");
		
		boolean ans=checkoutAddress.clickUsePaymentbtn();
		Assert.assertEquals(ans, true,"Test case failed");
	}
	@Test(priority=2)
	public void usingOtherUPI() throws EncryptedDocumentException, IOException
	{
		AmazonHome home=new AmazonHome(driver);
		home.Account_dropdown(driver);
		home.clickSignIn();
		
		AmazonLogin login=new AmazonLogin(driver);
		login.username("login", 0, 0);
		login.continue_button();
		login.password_amazon("login", 0, 1);
		login.signIn_Button();
		
		
		home.search("earing");
		
		AmazonProductSearchResult product=new AmazonProductSearchResult(driver);
		product.amazon_product();
		
		Set<String> ids=driver.getWindowHandles();
		Iterator<String> id=ids.iterator();
		String parent_id=id.next();
		String child_id=id.next();
		
		driver.switchTo().window(child_id);
		
		AmazonProductDetails productBuy=new AmazonProductDetails(driver);
		productBuy.clickBuyButton();
		AmazonCheckoutPage checkoutAddress=new AmazonCheckoutPage(driver);
		checkoutAddress.paymentUPI();
		
		boolean ans=checkoutAddress.clickUsePaymentbtn();
		Assert.assertEquals(ans, true,"Test case failed");
	}*/
}
