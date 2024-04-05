package retryTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class FlakyTests {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void Test1()
    {
        int randomNumber = generateRandomNumber(100);
        System.out.println(randomNumber);
        Assert.assertEquals(randomNumber%2, 0);
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void Test2()
    {
        Assert.assertEquals(false, true);
    }


    public static int generateRandomNumber(int upperbound){
        Random rand = new Random();
        return rand.nextInt(upperbound);
    }
}
