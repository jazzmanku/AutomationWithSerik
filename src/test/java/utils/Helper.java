package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Helper {
    public static String readPropertyByKey(String key){
//        System.out.println(System.getProperty("user.home"));
//        System.out.println(System.getProperty("user.dir"));
//        System.out.println(System.getProperty("user.name"));
        String value = "";
        try(InputStream input = new FileInputStream(System.getProperty("user.dir") + "\\appsettings.properties")){
            Properties properties = new Properties();
            properties.load(input);
            value = properties.getProperty(key);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    return value;
    }
}
