package login;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.IOException;


public class LoginTests extends BaseTests {

    LoginPage loginPage = new LoginPage();

    @Test
    public void testSuccessfulLogin() throws IOException {
        loginPage.cleanLogin(util.ConfigReader.getProperty("phoneNumber"), util.ConfigReader.getProperty("password"));
        Assert.assertEquals(loginPage.getDepositText().getText(), "Deposit", "We are logged in successfully");
    }

    @Test
    public void testInvalidLoginCredentials() throws IOException {
        loginPage.cleanLogin(util.ConfigReader.getProperty("phoneNumber"), util.ConfigReader.getProperty("invalidPassword"));
        String expectedErrorMessage = "The mobile and password provided do not match";
        Assert.assertEquals(loginPage.getErrorMessageText().getText(), expectedErrorMessage, "successful tested invalid credentials");
    }

}
