package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {

    private static final Properties properties = new Properties();

    static {
        try (InputStream input = ConfigLoader.class.getResourceAsStream("/config.properties")) {
            if (input == null) {
                throw new RuntimeException("Properties file not found");
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Error while loading properties file", e);
        }
    }

    public static String getProperty(String propertyKey) {
        String property = properties.getProperty(propertyKey);
        if (property == null) {
            throw new IllegalArgumentException(String.format("Value for key %s not found", propertyKey));
        }
        return property;
    }

    public static String getBaseUrl() {
        return getProperty("baseUrl");
    }
}
