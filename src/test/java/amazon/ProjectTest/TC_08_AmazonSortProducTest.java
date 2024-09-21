package amazon.ProjectTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import amazon.Project.AmazonHome;
import amazon.Project.AmazonProductSearchResult;


@Listeners(utilityPackage.IListnersAmazon.class)
public class TC_08_AmazonSortProducTest extends Launch_Quit{

	
	@Test(retryAnalyzer=utilityPackage.IRetryLogic.class,priority=1)
	public void SortByFeature() throws InterruptedException 
	{
		AmazonHome ah=new AmazonHome(driver);
		ah.search("earing");
		
		//AmazonProductSort apf=new AmazonProductSort(driver);
//		apf.sortByFeature("Featured");
//		String sort=apf.sortResultStore().getText();	
//		Assert.assertEquals(sort, "Featured", "Test case Failed");
		
		AmazonProductSearchResult aps=new AmazonProductSearchResult(driver);
		aps.sortByFeature("Featured");
		String sort1=aps.sortResultStore().getText();	
		//System.out.println(sort1);
		Assert.assertEquals(sort1, "Featured", "Test case Failed");
			
		Thread.sleep(2000);
		aps.sortByFeature("Price: Low to High");	
		String sort2=aps.sortResultStore().getText();	
		Assert.assertEquals(sort2, "Price: Low to High", "Test case Failed");
		Thread.sleep(2000);	
		aps.sortByFeature("Price: High to Low");
		String sort3=aps.sortResultStore().getText();	
		Assert.assertEquals(sort3, "Price: High to Low", "Test case Failed");
//		Robot r=new Robot();
//		r.keyPress(KeyEvent.VK_CONTROL);
//		r.keyPress(KeyEvent.VK_C);
//		r.keyRelease(KeyEvent.VK_CONTROL);
//		r.keyRelease(KeyEvent.VK_C);
//		
//		r.keyPress(KeyEvent.VK_CONTROL);
//		r.keyPress(KeyEvent.VK_V);
//		r.keyRelease(KeyEvent.VK_CONTROL);
//		r.keyRelease(KeyEvent.VK_V);
	}
}
