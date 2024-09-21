package AmazonFlightTest;


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import amazonFlight.Login;

@Listeners(utilityPackage.IListnersAmazon.class)
public class TC_02_Login extends LaunchQuit{

	@Test(retryAnalyzer=utilityPackage.IRetryLogic.class)
	public void TestCase01() throws EncryptedDocumentException, IOException, InterruptedException
	{
		Login login=new Login(driver);
		login.username("login", 0, 0);
		login.continue_button();
		
		login.password_amazon("login", 0, 1);
		login.signIn_Button();
		
		Thread.sleep(1500);
		
		String title=driver.getTitle();
		Assert.assertEquals(title.contains("Flight Bookings"), true,"Testcases Failed");
	}
}
