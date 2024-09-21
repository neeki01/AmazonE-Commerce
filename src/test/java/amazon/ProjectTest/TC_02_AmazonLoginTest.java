package amazon.ProjectTest;



import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import amazon.Project.AmazonHome;
import amazon.Project.AmazonLogin;

@Listeners(utilityPackage.IListnersAmazon.class)
public class TC_02_AmazonLoginTest extends Launch_Quit{

	@Test(retryAnalyzer=utilityPackage.IRetryLogic.class)
	public void usernameTestcase() throws EncryptedDocumentException, IOException 
	{
		
		AmazonHome amazon_home=new AmazonHome(driver);
		amazon_home.Account_dropdown(driver);
		amazon_home.clickSignIn();
		
		
		AmazonLogin login=new AmazonLogin(driver);
		login.username("login", 0, 0);
		login.continue_button();
		
		login.password_amazon("login", 0, 1);
		login.signIn_Button();
		
		String name=login.Address_Shown();
        Assert.assertEquals(name.equals("Deliver to Neeki"), true, "Login Failed");
		
	}
	
}
