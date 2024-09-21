package amazon.ProjectTest;

import java.time.Duration;

//import org.openqa.selenium.chrome.Chr
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utilityPackage.IListnersAmazon;

public class Launch_Quit extends IListnersAmazon{
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
					ChromeOptions ch=new ChromeOptions();
					ch.addArguments("--headless");
					driver=new ChromeDriver(ch);
					driver.get("https://www.amazon.in/");
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	@AfterMethod
	public void after_coderun()
	{
		driver.quit();
	}
}
