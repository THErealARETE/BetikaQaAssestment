package BetPlacement;

import base.BaseTests;
import controller.Controller;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BetPlacementPage;
import pages.LoginPage;

import java.io.IOException;

public class BetPlacementTest extends BaseTests {

    LoginPage loginPage = new LoginPage();
    BetPlacementPage betPlacementPage = new BetPlacementPage();

    @Test
    public void testSuccessfulBetPlacement() throws IOException, InterruptedException {
        loginPage.cleanLogin(util.ConfigReader.getProperty("phoneNumber"), util.ConfigReader.getProperty("password"));
        betPlacementPage.cleanBetPlacement();
        Assert.assertFalse(isElementPresent(util.LocatorReader.getLocator("placeBetButton")));
    }

    private boolean isElementPresent(String cssSelector) {
        try {
            // Try to find the element
            driver.findElement(By.cssSelector(cssSelector));
            return true;  // Element is present
        } catch (NoSuchElementException e) {
            return false; // Element is not present
        }
    }
}


