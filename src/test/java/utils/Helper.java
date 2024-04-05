package utils;

import java.io.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class Helper {
    public static String readPropertyByKey(String key){
//        System.out.println(System.getProperty("user.home"));
//        System.out.println(System.getProperty("user.dir"));
//        System.out.println(System.getProperty("user.name"));
        String value = "";
        String slashType = "/";
        if(System.getProperty("os.name").toLowerCase().contains("windows")){
            slashType = "\\";
        }
        String settingFilePath = System.getProperty("user.dir") + slashType + "appsettings.properties";

        try(InputStream input = new FileInputStream(settingFilePath)){
            Properties properties = new Properties();
            properties.load(input);
            value = properties.getProperty(key);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    return value;
    }

    public static void addLogging(StringBuffer stringBuffer) {
        stringBuffer.append("------------------------------ Test Results ------------------------------" +"\n");
        stringBuffer.append("Run Time...............: " + getTimeStamp() + "\n");
        stringBuffer.append("Operating System.......: " + System.getProperty("os.name") + "\n");
        stringBuffer.append("OS Version.............: " + System.getProperty("os.version") + "\n");
        stringBuffer.append("User Home Dir..........: " + System.getProperty("user.home") + "\n");
        stringBuffer.append("User Name..............: " + System.getProperty("user.name") + "\n");
        stringBuffer.append("JDK Version............: " + System.getProperty("java.version") + "\n");
    }
    public static List<String> readInputData(String fileName) throws IOException {
        String currentLine;
        List<String> fileData = new ArrayList<>();
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        while((currentLine = bufferedReader.readLine()) !=null){
            if(currentLine.startsWith("#") == false)
                fileData.add(currentLine);
        }
        bufferedReader.close();
        return fileData;
    }

    public static void writeOutputData(String resultsData) throws IOException {
        String fileName = "./logs/testResults.txt";
        FileWriter writer = new FileWriter(fileName, true);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        bufferedWriter.write(resultsData);
        bufferedWriter.close();
    }


    public static String getTimeStamp(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        Long time = new Date().getTime();
        Timestamp timestamp = new Timestamp(time);
        return dateFormat.format(timestamp);
    }

}
