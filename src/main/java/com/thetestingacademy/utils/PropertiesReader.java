package com.thetestingacademy.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    public static String readKey(String key) {

        Properties properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/data.properties");
            properties.load(fileInputStream);
        } catch (IOException e) {
            System.out.println((e.getMessage()));
        }
        return properties.getProperty(key);
    }
}
