package amazon.ProjectTest;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import amazon.Project.AmazonHome;
import amazon.Project.AmazonLogin;
import amazon.Project.AmazonManageProfile;


@Listeners(utilityPackage.IListnersAmazon.class)
public class TC_04_AmazonManageProfileTest extends Launch_Quit{
    
	@Test//(retryAnalyzer=utilityPackage.IRetryLogic.class)
	
	public void clickManageProfileTest() throws EncryptedDocumentException, IOException, InterruptedException
	{
		
		
		AmazonHome az=new AmazonHome(driver);
		az.Account_dropdown(driver);
		az.clickSignIn();
		

		AmazonLogin login=new AmazonLogin(driver);
		login.username("login",0,0);
		login.continue_button();
		login.password_amazon("login",0,1);
		login.signIn_Button();
		
		
		AmazonManageProfile amp=new AmazonManageProfile(driver);
		amp.account_listHover(driver);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		amp.clickYourACcount();
		
		
		
		int xx=amp.goToProfileLink().getLocation().getX();
		int yy=amp.goToProfileLink().getLocation().getY();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,"+yy+")");
		
		
		amp.clickProfile();
		amp.clickEditProfile();
//
//		WebElement a1=amp.getProfileName();
//		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.visibilityOf(a1));
	
		amp.editPublicName();
		Thread.sleep(1000);
		amp.clickSaveBtn();
		
		WebElement a2=amp.getProfileName();
		WebDriverWait wait01=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait01.until(ExpectedConditions.visibilityOf(a2));
		
		boolean name=amp.verifyProfileNam();
		
		Assert.assertEquals(name, true, "Test case Failed");
	
		
	}
	
}
