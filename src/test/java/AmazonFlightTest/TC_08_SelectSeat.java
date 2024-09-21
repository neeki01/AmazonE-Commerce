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
import amazonFlight.SeatSelection;
import amazonFlight.TravelersDetialsPage;

@Listeners(utilityPackage.IListnersAmazon.class)
public class TC_08_SelectSeat extends LaunchQuit{

	@Test(retryAnalyzer=utilityPackage.IRetryLogic.class)
	public void TestSeatSelection() throws EncryptedDocumentException, IOException, InterruptedException
	{
		Login login=new Login(driver);
		login.username("login", 0, 0);
		login.continue_button();
		
		login.password_amazon("login", 0, 1);
		login.signIn_Button();
		
		HomePage hp=new HomePage(driver);
		
		Thread.sleep(1000);
		hp.clickOneWayTrip();
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
		
		hp.classType();
		hp.clickTravler();
		hp.clickSearchBtn();
		Thread.sleep(1000);
		SearchPage sp=new SearchPage(driver);
		
		sp.SelectBookbtn();
		
		Thread.sleep(1000);
		
		FlightDetailsPage fdp=new FlightDetailsPage(driver);
		
		fdp.ProceedPayment();
		
		TravelersDetialsPage tdp=new TravelersDetialsPage(driver);
		Thread.sleep(1000);
		tdp.AddAdult();
		Thread.sleep(1000);
		tdp.clickGenderbtn();
		tdp.SelectGenderFemale();	
		tdp.AddFirstName();
		tdp.AddLastName();
		tdp.addbtn();
		tdp.enterEmail();
		tdp.clickDelete();
		String delete=driver.getWindowHandle();
		driver.switchTo().window(delete);
		tdp.clickDeleteOnWindow();
		tdp.ProceedPay();
		
		SeatSelection ss=new SeatSelection(driver);
		boolean ans=ss.clickBomTab();
		
		Assert.assertTrue(ans,"Test case failed");
		
	}
}
