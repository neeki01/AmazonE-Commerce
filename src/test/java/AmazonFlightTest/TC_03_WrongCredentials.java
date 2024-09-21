package AmazonFlightTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import amazonFlight.Login;

@Listeners(utilityPackage.IListnersAmazon.class)
public class TC_03_WrongCredentials extends LaunchQuit{

	
	@Test(retryAnalyzer=utilityPackage.IRetryLogic.class)
	public void WrongCredentials() throws EncryptedDocumentException, IOException
	{
		Login login=new Login(driver);
		login.username("login", 1, 0);
		login.continue_button();
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
		login.password_amazon("login", 1, 1);
		login.signIn_Button();
	
		
		boolean alert=login.wrongPasswordExpected();
		Assert.assertEquals(alert, true, "Login Failed");
	}
	}

