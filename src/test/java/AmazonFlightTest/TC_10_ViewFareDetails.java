package AmazonFlightTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import amazonFlight.FlightDetailsPage;
import amazonFlight.HomePage;
import amazonFlight.Login;
import amazonFlight.SearchPage;

@Listeners(utilityPackage.IListnersAmazon.class)
public class TC_10_ViewFareDetails extends LaunchQuit{

	@Test(retryAnalyzer=utilityPackage.IRetryLogic.class)
	public void testCaseFareDetails() throws EncryptedDocumentException, IOException, InterruptedException
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
		hp.clickSearchBtn();
		
		
		SearchPage sp=new SearchPage(driver);
		
		sp.SelectBookbtn();
		FlightDetailsPage fdp=new FlightDetailsPage(driver);
//		boolean ans=fdp.viewBaggageLinkPresent();
//		Assert.assertEquals(ans,true,"Test case failed");
		
		fdp.clickViewBaggage();
		
		boolean ans=fdp.verifyBuggageDetail();
		Assert.assertEquals(ans,true,"Test case failed");
		
		fdp.clickOnCancelBtn();
		
		boolean ans1=fdp.VerifyCancelTable();
		Assert.assertEquals(ans1,true,"Test case failed");
		
		fdp.clickFareLink();
		boolean ans2=fdp.verifyAmountDetails();
		Assert.assertEquals(ans2,true,"Test case failed");
		
		
	}
}
