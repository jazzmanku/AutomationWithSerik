package com.tat;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.tat.Main.ComplexFinancialMethod;


public class MainTest {

    @Test
    public void TC01_testComplexFinancialMethod_bothNumbersMoreThan100() {
        double actualResults = ComplexFinancialMethod(110.0, 120.0);
        double expectedResults = 191400.0;
        if(actualResults == expectedResults){
            System.out.println("Test Pass");
        }
        else{
            System.out.println("Test Fail");
            System.out.println("Expected : " + expectedResults + "\nActual : " + actualResults);
            Assert.fail();
        }
    }


    @Test
    public void TC02_testComplexFinancialMethod_bothNumbersLessThan100MoreThan0() {
        double actualResults = ComplexFinancialMethod(20.0, 15.0);
        double expectedResults = 5100.0;
        if(actualResults == expectedResults){
            System.out.println("Test Pass");
        }
        else{
            System.out.println("Test Fail");
            System.out.println("Expected : " + expectedResults + "\nActual : " + actualResults);
            Assert.fail();
        }
    }

    @Test
    public void TC03_testComplexFinancialMethod() {
        double actualResults = ComplexFinancialMethod(10.0, -10.0);
        double expectedResults = -300.0;
        if(actualResults == expectedResults){
            System.out.println("Test Pass");
        }
        else
        {
            System.out.println("Test Fail");
            System.out.println("Expected : " + expectedResults + "\nActual : " + actualResults);
            Assert.fail();
        }
    }

    @Test
    public void TC04_testComplexFinancialMethod_oneNegativeOnePositive() {
        double actualResults = ComplexFinancialMethod(-10.0, 10.0);
        double expectedResults = -300.0;
        if(actualResults == expectedResults){
            System.out.println("Test Pass");
        }
        else
        {
            System.out.println("Test Fail");
            System.out.println("Expected : " + expectedResults + "\nActual : " + actualResults);
            Assert.fail();
        }
    }

    @Test
    public void TC05_testComplexFinancialMethod_bothNegative() {
        double actualResults = ComplexFinancialMethod(-10.0, -10.0);
        double expectedResults = 1500.0;
        if(actualResults == expectedResults){
            System.out.println("Test Pass");
        }
        else
        {
            System.out.println("Test Fail");
            System.out.println("Expected : " + expectedResults + "\nActual : " + actualResults);
            Assert.fail();
        }
    }
}