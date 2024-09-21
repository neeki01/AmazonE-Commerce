package amazon.ProjectTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import amazon.Project.AmazonHome;

@Listeners(utilityPackage.IListnersAmazon.class)
public class TC_06_AmazonSearchFilterTest extends Launch_Quit{

	
	@Test//(retryAnalyzer=utilityPackage.IRetryLogic.class)
	public void searchByCategory()
	{
		AmazonHome asf=new AmazonHome(driver);
		asf.CategorySelection("Beauty");
		asf.search("Beauty");
		
		String title=driver.getTitle();
		
		Assert.assertEquals(title, "Amazon.in : Beauty", "Test case failed");
		
		
		
	}
	

	}
	

