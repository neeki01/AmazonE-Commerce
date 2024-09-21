package amazon.ProjectTest;

import java.util.Iterator;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import amazon.Project.AmazonHome;
import amazon.Project.AmazonProductDetails;
import amazon.Project.AmazonProductSearchResult;

@Listeners(utilityPackage.IListnersAmazon.class)
public class TC_13 extends Launch_Quit{

	@Test//(retryAnalyzer = utilityPackage.IRetryLogic.class)
	public void offers()
	{
		AmazonHome az=new AmazonHome(driver);
		az.search("shoes");
		
		AmazonProductSearchResult apd=new AmazonProductSearchResult(driver);
		apd.amazon_product();
		
		Set<String> ids=driver.getWindowHandles();
		Iterator<String> id=ids.iterator();
		String parent_id=id.next();
		String child_id=id.next();

		driver.switchTo().window(child_id);
		
		AmazonProductDetails priceDetails= new AmazonProductDetails(driver);
		String name=priceDetails.clickOffers();
		
		Assert.assertEquals(name.contains("Offer"), true,"TestCase failed");
		
	}
}
