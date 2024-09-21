package AmazonFlightTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import amazonFlight.HomePage;
import amazonFlight.Login;

@Listeners(utilityPackage.IListnersAmazon.class)
public class TC_12_LoginSearchLogout extends LaunchQuit{

	@Test(retryAnalyzer=utilityPackage.IRetryLogic.class)
	public void testcaseSearchlogout() throws EncryptedDocumentException, IOException, InterruptedException
	{
		Login login=new Login(driver);
		login.username("login", 0, 0);
		login.continue_button();
		
		login.password_amazon("login", 0, 1);
		login.signIn_Button();
		
		HomePage hp=new HomePage(driver);
		
		Thread.sleep(1000);
		
		//hp.clickOneWayTrip();
		Thread.sleep(1000);
		hp.fromCity();
//		WebElement e=hp.fromcityelement();
//		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(1000));
//		wait.until(ExpectedConditions.visibilityOf(e));

		Thread.sleep(1000);
		hp.EnterCity();
		Thread.sleep(1000);
		hp.HoverToCity(driver);
		Thread.sleep(1000);
		hp.clickCityOption();
		Thread.sleep(1000);
		hp.EnterDestinationCity();
		Thread.sleep(1000);
		hp.hoverToDestination(driver);
		Thread.sleep(1000);
		hp.clickDestination();
		Thread.sleep(1000);
		hp.addFirstDate();
		//hp.clickSearchBtn();
		hp.classType();
		Thread.sleep(1000);
		hp.selectNoOfPassengers();
			//hp.addFirstDate();
		hp.clickSearchBtn();
		
		hp.Account_dropdown(driver);
		hp.clickOnSignOutbtn();
		
		boolean ans=login.verifyemail();
		Assert.assertTrue(ans,"Test case Failed");
		
	}
}
