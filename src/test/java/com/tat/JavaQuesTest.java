package com.tat;

import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Random;

import static com.tat.JavaQues.checkIn7090;

/*
Given 2 int values, return true if they are both in the range 70..80 inclusive, or they are both in the range 80..90 inclusive.

Sample TestCases
(input ) ->  output
isTheNumIn7090(70, 71) → true
isTheNumIn7090  (70, 81) → false
isTheNumIn7090  (80, 90) → true

Create your TestCases if needed

Method name regex
Read Files
Read file and DP

 */
public class JavaQuesTest {

    Random random = new Random();

    @BeforeTest
    public void SetupTest(){
        System.out.println("Before Test - Open the Browser and Application");
    }

    @BeforeMethod
    public void SetupBeforeMethodRuns(){
        System.out.println("    Before Method - Login");
    }

    @Test(enabled = false, dataProvider = "set_457", groups = {"Code"}, dependsOnGroups = {"Sanity"})
    public void testCheckIn7090(int a, int b, boolean expResults) {
        Assert.assertEquals(checkIn7090(a,b), expResults);
    }

    @Test(enabled = false, priority = 1, groups = {"Regression","Sanity"})
    public void TestOnChrome3() throws InterruptedException {
        Thread.sleep(random.nextInt(5000));
    }

    @Test(enabled = false, priority = 2, groups = "Regression")
    public void TestOnChrome() throws InterruptedException {
        Thread.sleep(random.nextInt(5000));
    }

    @Test(groups = "Sanity")
    public void TestOnChrome2() throws InterruptedException {
        Thread.sleep(random.nextInt(5000));
    }
    @Test(groups = "Sanity")
    public void TestOnFirefox() throws InterruptedException {
        Thread.sleep(random.nextInt(5000));
    }

    @Test(groups = "Sanity")
    public void TestOnFirefox2() throws InterruptedException {
        Thread.sleep(random.nextInt(5000));
    }

    @Test(groups = "Sanity")
    public void TestOnFirefox3() throws InterruptedException {
        Thread.sleep(random.nextInt(5000));
    }

    @DataProvider(name = "set_457")
    public Object[][] TestData_917(){
        return new Object[][]{
                {70, 71, true},
                {70, 81, false},
                {80, 90, true},
                {80, 91, false},
                {79, 90, false},
                {90, 79, false},
                {80, 79, true},
                {89, 88, true},
                {90, 80, true},
                {90, 91, false},
                {75, 76, true},
                {75, 85, false},
        };
    }

    @AfterMethod
    public void AfterMethodRuns(){
        System.out.println("    After Method - Logout");
    }

    @AfterTest
    public void TearDownTest(){
        System.out.println("After Test - Shutdown the application");
    }




}
