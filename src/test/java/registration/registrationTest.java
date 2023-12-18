package registration;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationPage;

import java.io.IOException;

public class registrationTest extends BaseTests {

    RegistrationPage
            registrationPage = new RegistrationPage();

    @Test
    public void testSuccessfulRegistration() throws IOException, InterruptedException {
        registrationPage.registeration(util.ConfigReader.getProperty("newPhoneNumber"), util.ConfigReader.getProperty("password"));
        Thread.sleep(7000);
        String currentUrl = driver.getCurrentUrl();
        String expectedSubstring = "&canVerify=true";
        Assert.assertTrue(currentUrl.contains(expectedSubstring));
    }
}
