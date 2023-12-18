package util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PhoneNumberManager {

    private long currentNumber;
    private long lastValue;
    private String configFile = "src/main/java/Config/config.properties";

    public PhoneNumberManager() {
        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(configFile)) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        currentNumber = Long.parseLong(properties.getProperty("newPhoneNumber", "0"));
        lastValue = currentNumber - 1;
    }

    public long incrementAndUpdate() {
        currentNumber++;
        lastValue = currentNumber - 1;
        updateConfig();

        return currentNumber;
    }

    private void updateConfig() {
        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(configFile)) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        properties.setProperty("newPhoneNumber", String.valueOf(currentNumber));

        try (FileOutputStream fileOutputStream = new FileOutputStream(configFile)) {
            properties.store(fileOutputStream, null);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Updated Configuration: currentNumber = " + currentNumber + ", lastValue = " + lastValue);
    }

    public static void main(String[] args) {
        PhoneNumberManager numberManager = new PhoneNumberManager();
        long newNumber = numberManager.incrementAndUpdate();

        System.out.println("New Number: " + newNumber);
    }
}
