package amazon.ProjectTest;

import java.util.Iterator;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import amazon.Project.AmazonCartProductAdded;
import amazon.Project.AmazonHome;
import amazon.Project.AmazonProductDetails;
import amazon.Project.AmazonProductSearchResult;

@Listeners(utilityPackage.IListnersAmazon.class)
public class TC_09_AmazonAddToCartTest extends Launch_Quit{

	@Test(retryAnalyzer=utilityPackage.IRetryLogic.class)
	public void addToCart()
	{
		AmazonHome az=new AmazonHome(driver);
		az.search("shoes");
		
		AmazonProductSearchResult ap=new AmazonProductSearchResult(driver);
		ap.amazon_product();
		
		Set<String> ids=driver.getWindowHandles();
		Iterator<String> id=ids.iterator();
		String parentId=id.next();
		String childId=id.next();
		
		driver.switchTo().window(childId);
		
		AmazonProductDetails apd=new AmazonProductDetails(driver);
		apd.cartButton();
		
		AmazonCartProductAdded acd=new AmazonCartProductAdded(driver);
		boolean cartBtn=acd.result();
		
		
		Assert.assertEquals(cartBtn, true,"Test Case failed");
		
		
		
	}
	
}
