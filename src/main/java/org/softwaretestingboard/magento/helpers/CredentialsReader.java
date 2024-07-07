package org.softwaretestingboard.magento.helpers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class CredentialsReader {
    private final String userEmail;
    private final String userPassword;
    private final String surname;
    private final String name;
    private final String weakPassword;
    private final String wrongEmail;

    public CredentialsReader(){
        String configPath = "src/main/resources/credentials.properties";
        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader(configPath));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Configuration file was not found at " + configPath);
        }
        Properties properties = new Properties();
        try {
            properties.load(reader);
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        userEmail = properties.getProperty("userEmail");
        userPassword = properties.getProperty("userPassword");
        name = properties.getProperty("name");
        surname = properties.getProperty("surname");
        weakPassword = properties.getProperty("weakPassword");
        wrongEmail = properties.getProperty("wrongEmail");
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getWeakPassword() {
        return weakPassword;
    }

    public String getWrongEmail() {
        return wrongEmail;
    }
}
