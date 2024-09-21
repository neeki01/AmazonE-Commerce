package utilityPackage;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class IRetryLogic implements IRetryAnalyzer{

	int current_count=0;
	int retry_count=1;
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		
		if(current_count < retry_count)
		{
			current_count++;
			return true;
		}
		return false;
	}

}
