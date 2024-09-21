package amazon.ProjectTest;

import java.util.Iterator;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import amazon.Project.AmazonCartPage;
import amazon.Project.AmazonCartProductAdded;
import amazon.Project.AmazonHome;
import amazon.Project.AmazonProductDetails;
import amazon.Project.AmazonProductSearchResult;

@Listeners(utilityPackage.IListnersAmazon.class)
public class TC_10_AmazonItemsAddedQuantity extends Launch_Quit{

	@Test(retryAnalyzer=utilityPackage.IRetryLogic.class,priority=1)
	public void addedMoreQuantity()
	{
		AmazonHome az=new AmazonHome(driver);
		az.search("shoes");
	
		AmazonProductSearchResult ap=new AmazonProductSearchResult(driver);
		ap.amazon_product();
		
		Set<String> ids=driver.getWindowHandles();
		Iterator<String> id=ids.iterator();
		String parent_id=id.next();
		String child_id=id.next();
	
		driver.switchTo().window(child_id);
	
		AmazonProductDetails apd=new AmazonProductDetails(driver);
		apd.cartButton();
	
		AmazonCartProductAdded acpa=new AmazonCartProductAdded(driver);
		acpa.goToCartBtn();
	
//		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(2));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Singh")));
		
		AmazonCartPage acp=new AmazonCartPage(driver);
		acp.clickQuantity(5);
	
		String value=acp.Subtotal();
		Assert.assertEquals(value.contains("Subtotal"), true,"Test Case Failed");
	}
	
}
