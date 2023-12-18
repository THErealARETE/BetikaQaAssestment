package login;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LogOutPage;
import pages.LoginPage;

import java.io.IOException;

import static util.ConfigReader.*;


public class LoginTests extends BaseTests {

    LoginPage loginPage = new LoginPage();

    LogOutPage logOutPage = new LogOutPage();

    @Test
    public void testSuccessfulLogin() throws IOException {
        loginPage.cleanLogin(getPhoneNumber(),getPassword());
        Assert.assertEquals(loginPage.getDepositText().getText(), "Deposit", "We are logged in successfully");
        logOutPage.cleanLogOut();
    }

    @Test
    public void testInvalidLoginCredentials() throws IOException {
        loginPage.cleanLogin(getPhoneNumber(),getInvalidPassword());
        String currentUrl = driver.getCurrentUrl();
        String expectedSubstring = "/login?next=%2F";
        Assert.assertTrue(currentUrl.contains(expectedSubstring));
    }

}
