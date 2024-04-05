package com.tat;

import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DataProviderEx {

    @DataProvider(name = "set_457")
    public Object[][] TestData_917() throws IOException {
        return readInto2DArray();
    }

    @DataProvider(name = "set_4571")
    public Object[][] TestData_9173() throws IOException {
        return readInto2DArray();
    }

    @DataProvider(name = "set_4572")
    public Object[][] TestData_9172() throws IOException {
        return readInto2DArray();
    }
    public static Object[][] readInto2DArray() throws IOException {
        Path path = Paths.get("./testData/test.csv");
        List<String[]> content = new ArrayList<>();
        List<String> lines = Files.readAllLines(path);
        for(String line : lines){
            String[] eachWord = line.split(",");
            content.add(eachWord);
        }

        Object[][] testData = new String[content.size()][0];
        return content.toArray(testData);
    }
}
