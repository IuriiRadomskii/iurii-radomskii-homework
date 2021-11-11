package com.epam.tc.hw6.data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyInit {

    public static String getProperty(String propertyName) {
        FileInputStream inputStream;
        Properties property = new Properties();
        try {
            inputStream = new FileInputStream("src/test/java/com/epam/tc/hw4/credentials.properties");
            property.load(inputStream);
            return property.getProperty(propertyName);
        } catch (IOException e) {
            System.err.println("Property file doesn't exist");
        }
        return "";
    }
}
