package amazon.ProjectTest;

import java.util.Iterator;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import amazon.Project.AmazonCartProductAdded;
import amazon.Project.AmazonHome;
import amazon.Project.AmazonProductDetails;
import amazon.Project.AmazonProductSearchResult;

public class TC_15 extends Launch_Quit{

	@Test
	public void addCartTo() throws InterruptedException
	{
		AmazonHome ah=new AmazonHome(driver);
		ah.search("shoes");
		
		AmazonProductSearchResult aps=new AmazonProductSearchResult(driver);
		aps.amazon_product();
		
		Thread.sleep(2000);
		Set<String> ids=driver.getWindowHandles();
		Iterator<String> id=ids.iterator();
		String parent_id=id.next();
		String child_id=id.next();
		driver.switchTo().window(child_id);
		
		Thread.sleep(2000);
		AmazonProductDetails apd=new AmazonProductDetails(driver);
		apd.cartButton();
		Thread.sleep(2000);
		
		AmazonCartProductAdded acd=new AmazonCartProductAdded(driver);
		boolean cartBtn=acd.result();
		Thread.sleep(2000);
		
		Assert.assertEquals(cartBtn, true,"Test Case failed");
	}
}
