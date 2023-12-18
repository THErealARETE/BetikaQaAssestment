package registration;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationPage;

import java.io.IOException;

import static util.ConfigReader.getPassword;

public class registrationTest extends BaseTests {

    RegistrationPage
            registrationPage = new RegistrationPage();

    @Test
    public void testSuccessfulRegistration() throws IOException, InterruptedException {
        registrationPage.registration( getPassword());
        System.out.println(util.ConfigReader.getProperty("newPhoneNumber"));
        Thread.sleep(7000);
        String currentUrl = driver.getCurrentUrl();
        String expectedSubstring = "&canVerify=true";
        Assert.assertTrue(currentUrl.contains(expectedSubstring));
    }
}
