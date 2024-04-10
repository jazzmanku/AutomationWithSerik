package flakytests;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import utils.Helper;

import java.io.IOException;

public class RetryAnalyzer implements IRetryAnalyzer {

    int counter = 0;
    int retryLimit = 2;
    /*
     * (non-Javadoc)
     * @see org.testng.IRetryAnalyzer#retry(org.testng.ITestResult)
     *
     * This method decides how many times a test needs to be rerun.
     * TestNg will call this method every time a test fails. So we
     * can put some code in here to decide when to rerun the test.
     *
     * Note: This method will return true if a tests needs to be retried
     * and false it not.
     *
     */

    @Override
    public boolean retry(ITestResult result) {
        System.out.println(result.isSuccess());
        if(counter < retryLimit)
        {
            counter++;
            try {
                Helper.TakeScreenCapture(result.getName()+"_" + counter);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return true;
        }
        return false;
    }
}
