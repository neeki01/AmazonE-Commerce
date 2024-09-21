package AmazonFlightTest;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import amazonFlight.HomePage;
import amazonFlight.Login;
@Listeners(utilityPackage.IListnersAmazon.class)
public class TC_04_SearchOnWayFlight extends LaunchQuit{

	
	@Test(retryAnalyzer=utilityPackage.IRetryLogic.class)
	public void OneWayTest() throws EncryptedDocumentException, IOException, InterruptedException
	{
		Login login=new Login(driver);
		login.username("login", 0, 0);
		login.continue_button();
		
		login.password_amazon("login", 0, 1);
		login.signIn_Button();
		
		HomePage hp=new HomePage(driver);
		
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
		
		//hp.EnterDestinationCity();
		//hp.hoverToDestination(driver);
		//hp.clickDestination();
		
		hp.addFirstDate();
		hp.clickSearchBtn();
		
		
		String name=hp.SearchReault();
		Assert.assertEquals(name.contains("Number of stops"), true,"Test case is failed");
		
		
		
				
	}
}
