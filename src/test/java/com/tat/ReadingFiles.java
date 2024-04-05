package com.tat;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadingFiles {

    public static void main(String[] args) throws IOException {
        readInto2DArray();
    }

    public static void readFilesByBuffReader() throws IOException {
        String fileName = "./testData/test.csv";
        String currentLine;
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        while((currentLine = bufferedReader.readLine()) != null){
            System.out.println(currentLine);
        }
        bufferedReader.close();
    }

    public static void readFileByFiles() throws IOException {
        String fileName = "./testData/test.csv";
        Path path = Paths.get(fileName);
        List<String> contents = Files.readAllLines(path);
        for(String line : contents){
            System.out.println(line);
        }
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
