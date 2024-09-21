package AmazonFlightTest;

import java.time.Duration;

//import org.openqa.selenium.chrome.Chr
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utilityPackage.IListnersAmazon;

public class LaunchQuit extends IListnersAmazon{
	//public static WebDriver driver;
	/*@BeforeMethod
	@Parameters("browser")
	public void generic_methods(String nameOfBrowser)
	{
				if(nameOfBrowser.equals("chrome"))
				{
					driver=new ChromeDriver();
					driver.get("https://www.amazon.in/");
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				}
				if(nameOfBrowser.equals("edge"))
				{
					driver=new EdgeDriver();
					driver.get("https://www.amazon.in/");
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				}		
			
	}*/
	@BeforeMethod
	public void generic_methods01()
	{
//					ChromeOptions ch=new ChromeOptions();
//					ch.addArguments("--headless");
					driver=new ChromeDriver();
					driver.get("https://www.amazon.in/flights?ref_=nav_em_sbc_desktop_flights_0_1_1_33");
					//driver.get("https://www.makemytrip.com/");
					//driver.get("https://www.goindigo.in/");
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	@AfterMethod
	public void after_coderun()
	{
		driver.quit();
	}
}
