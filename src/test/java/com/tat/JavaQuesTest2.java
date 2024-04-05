package com.tat;

import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
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
public class JavaQuesTest2 {

    @Test(dataProvider = "set_457", dataProviderClass = DataProviderEx.class)
    public void testCheckIn7090(String a, String b, String expResults) {
        Assert.assertEquals(checkIn7090(Integer.parseInt(a.trim()),
                Integer.parseInt(b.trim())),
                Boolean.parseBoolean(expResults.trim()));
    }
}
