package AmazonFlightTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import amazonFlight.HomePage;
import amazonFlight.Login;

@Listeners(utilityPackage.IListnersAmazon.class)
public class TC_14_RoundTripSearch extends LaunchQuit{

	@Test(retryAnalyzer=utilityPackage.IRetryLogic.class)
	public void testCaseRoundTrip() throws EncryptedDocumentException, IOException, InterruptedException
	{
		Login login=new Login(driver);
		login.username("login", 0, 0);
		login.continue_button();
		
		login.password_amazon("login", 0, 1);
		login.signIn_Button();
		
		HomePage hp=new HomePage(driver);
		hp.clickTwoWayRaiodBtn();
		Thread.sleep(1000);
		hp.fromCity();
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
		Thread.sleep(1000);
		hp.selectReturnDay();
		Thread.sleep(1000);
		hp.ClcikOnNextbtn();
		
		Thread.sleep(1000);
		hp.SelectReturnDate();
		hp.clickSearchBtn();
		
		String name=hp.SearchReault();
		Assert.assertEquals(name.contains("Number of stops"), true,"Test case is failed");
	}
}
