package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LocatorReader {

    private static Properties properties;

    static {
        properties = new Properties();
        loadLocatorsProperties();
    }

    private static void loadLocatorsProperties() {
        try {
            FileInputStream fileInputStream = new FileInputStream("src/Config/locators.properties");
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getLocator(String locatorName) {
        return properties.getProperty(locatorName);
    }

}
