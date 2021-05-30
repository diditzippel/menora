package com.menora.bl;

import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Service
// Manage property file
public class ApplicationPropertyService {

    public String getVaultLocation() {
        return getProperty("vaultLocation");
    }

    public Integer getDurationTimeInMinutes() {

        String durationString = getProperty("durationTimeInMinutes");
        return Integer.parseInt(durationString);
    }

    private String getProperty(String propertyName) {

        String propertyValue = null;
        try (InputStream input = new FileInputStream("C:\\Users\\David\\Downloads\\menoraUpdate\\menoraConfig.properties")) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            propertyValue = prop.getProperty(propertyName);

        } catch (IOException io) {
            io.printStackTrace();
        }

        return propertyValue;
    }
}
