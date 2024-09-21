package amazon.ProjectTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import amazon.Project.AmazonHome;
import amazon.Project.AmazonLogin;

@Listeners(utilityPackage.IListnersAmazon.class)
public class TC_03_AmazonLoginFailTestt extends Launch_Quit{
	
	@Test(retryAnalyzer=utilityPackage.IRetryLogic.class)
	public void WrongCredentials() throws EncryptedDocumentException, IOException
	{	
		AmazonHome amazon_home=new AmazonHome(driver);
		amazon_home.Account_dropdown(driver);
		//amazon_home.clickSignOut();
		
		amazon_home.clickSignIn();
	
		AmazonLogin login=new AmazonLogin(driver);
		login.username("login", 1, 0);
		login.continue_button();
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
		login.password_amazon("login", 1, 1);
		login.signIn_Button();
	
		
		boolean alert=login.wrongPasswordExpected();
		Assert.assertEquals(alert, true, "Login Failed");
	}
}