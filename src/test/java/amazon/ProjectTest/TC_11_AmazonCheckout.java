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
public class TC_11_AmazonCheckout extends Launch_Quit{

	@Test(retryAnalyzer=utilityPackage.IRetryLogic.class)
	public void amazonCheckoutCode() throws EncryptedDocumentException, IOException
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
		String parent_Id=id.next();
		String child_id=id.next();
		driver.switchTo().window(child_id);

		AmazonProductDetails productBuy=new AmazonProductDetails(driver);
		productBuy.clickBuyButton();
		
		AmazonCheckoutPage checkoutAddress=new AmazonCheckoutPage(driver);
		
		WebElement a2=checkoutAddress.waitPayment();
		WebDriverWait wait01=new WebDriverWait(driver,Duration.ofSeconds(15));
		wait01.until(ExpectedConditions.visibilityOf(a2));
		
		//checkoutAddress.clickOnCOD();
		checkoutAddress.paymentUPI();
		checkoutAddress.clickOnCOD();
		
		WebElement a3=checkoutAddress.waitPaymentMethod();
		WebDriverWait wait3=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait3.until(ExpectedConditions.visibilityOf(a3));
		
		checkoutAddress.clickPaymentMethod();
		
		WebElement a=checkoutAddress.useAddress();	
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(a));
		
		
		checkoutAddress.addressSelect();
		
		WebElement a4=checkoutAddress.waitAddAddress();
		WebDriverWait wait2=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait2.until(ExpectedConditions.visibilityOf(a4));
		
		checkoutAddress.addAddress();
		boolean price_name=checkoutAddress.orderDetails();
		
		Assert.assertEquals(price_name, true,"TestCase Failed");	
		
	}


		
	}
