package registration;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RegistrationPage;

import java.io.IOException;

public class registrationTest extends BaseTests {

    RegistrationPage
            registrationPage = new RegistrationPage();

    @Test
    public void testSuccessfulRegistration() throws IOException {
        registrationPage.registeration(util.ConfigReader.getProperty("newPhoneNumber"), util.ConfigReader.getProperty("password"));
        String currentUrl = driver.getCurrentUrl();
        String expectedSubstring = "&canVerify=true";
        Assert.assertTrue(currentUrl.contains(expectedSubstring));
    }
}
