package ru.training.hw3;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyManager {
    private static final String PROPERTIES_FILE_PATH =
            "src/test/java/resources/hw3/test.properties";
    private static final String USERNAME_PROPERTY = "user.username";
    private static final String PASSWORD_PROPERTY = "user.password";
    private Properties properties;

    public void load() {
        try (InputStream inputStream = new FileInputStream(PROPERTIES_FILE_PATH)) {
            properties = new Properties();
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return properties.getProperty(USERNAME_PROPERTY);
    }

    public String getPassword() {
        return properties.getProperty(PASSWORD_PROPERTY);
    }
}
