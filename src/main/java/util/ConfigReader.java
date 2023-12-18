package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class ConfigReader {
    private static ThreadLocal<Properties> threadLocalProperties = new ThreadLocal<>();

    private static Properties getPropertyObject() throws IOException {
        Properties prop = threadLocalProperties.get();

        if (prop == null) {
            FileInputStream fp = new FileInputStream("src/main/java/Config/config.properties");
            prop = new Properties();
            prop.load(fp);
            threadLocalProperties.set(prop);
        }

        return prop;
    }

    private ConfigReader() {
    }

    public static String getUrl() throws IOException {
        return getPropertyObject().getProperty("url");
    }

    public static String getPhoneNumber() throws IOException {
        return getPropertyObject().getProperty("phoneNumber");
    }
    public static String getInvalidPassword() throws IOException {
        return getPropertyObject().getProperty("invalidPassword");
    }

    public static String getPassword() throws IOException {
        return getPropertyObject().getProperty("password");
    }

    public static String getProperty(String propertyName) throws IOException {
        return getPropertyObject().getProperty(propertyName);
    }
}
