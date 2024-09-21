package amazon.ProjectTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import amazon.Project.AmazonHome;
import amazon.Project.AmazonRegistration;


@Listeners(utilityPackage.IListnersAmazon.class)
public class TC_01_AmazonRegisterTest extends Launch_Quit{

	@Test(retryAnalyzer=utilityPackage.IRetryLogic.class,invocationCount=0 )
	public void amazonRegister()
	{
			AmazonHome amazon_home=new AmazonHome(driver);
			amazon_home.Account_dropdown(driver);//hover over to login
			
			AmazonRegistration ar=new AmazonRegistration(driver);
			ar.register_user();//click on sign-in link
			ar.user_name();//fill user name
			ar.phoneNo();//fill in phone number
			ar.Customer_Password();//fill in password
			ar.otp_continue();//click verify button
			boolean linkName=ar.verify_Condition();
			
			Assert.assertEquals(linkName, true,"Registration Failed"); 
	}
}
