package AmazonFlightTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import amazonFlight.FlightDetailsPage;
import amazonFlight.HomePage;
import amazonFlight.Login;
import amazonFlight.PaymentPage;
import amazonFlight.ReviewPage;
import amazonFlight.SearchPage;
import amazonFlight.SeatSelection;
import amazonFlight.TravelersDetialsPage;

@Listeners(utilityPackage.IListnersAmazon.class)
public class TC_15_CheckPayement extends LaunchQuit{

	@Test(retryAnalyzer=utilityPackage.IRetryLogic.class)
	public void testPayment() throws EncryptedDocumentException, IOException, InterruptedException
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
		
		hp.EnterDestinationCity();
//		hp.hoverToDestination(driver);
//		hp.clickDestination();
//		
//		hp.addFirstDate();
		hp.classType();
		hp.clickTravler();
		Thread.sleep(1000);
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
		fdp.clickNextBtn();
		String proceed=driver.getWindowHandle();
		driver.switchTo().window(proceed);
		
		SeatSelection ss= new SeatSelection(driver);
		ss.clickNextProceed();
		
		ReviewPage rp=new ReviewPage(driver);
		rp.clickCheckBox();
		rp.clickOnProceedToPay();
		
		PaymentPage pp=new PaymentPage(driver);
		pp.clickOnCardPaymentOption();
		
//		//WebElement w=;
//		driver.switchTo().frame(pp.moveToFrame());
		
		
		pp.enterName();
		pp.enterCardNumber();
		pp.expirationMonthVerify();
		pp.expirationYearVerify();
		pp.clickAddDetailsbtn();
		pp.addCVV();
		
		Assert.assertTrue(pp.verifyPay(),"test case failed");
	}
}
