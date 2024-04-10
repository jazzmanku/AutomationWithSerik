package flakytests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class MyFlakyTests {
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void TestEvenOrOdd()
    {
        int randomNumber = generateRandomNumber(100);
        System.out.println(randomNumber);
        Assert.assertEquals(randomNumber%2, 0);
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void FailingTest()
    {
        Assert.assertEquals(false, true);
    }


    public static int generateRandomNumber(int upperbound){
        Random rand = new Random();
        return rand.nextInt(upperbound);
    }
}
