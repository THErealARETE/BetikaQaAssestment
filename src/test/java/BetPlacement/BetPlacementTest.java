package BetPlacement;

import base.BaseTests;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BetPlacementPage;
import pages.LogOutPage;
import pages.LoginPage;

import java.io.IOException;


import static util.ConfigReader.getPassword;
import static util.ConfigReader.getPhoneNumber;


public class BetPlacementTest extends BaseTests {

    LoginPage loginPage = new LoginPage();
    BetPlacementPage betPlacementPage = new BetPlacementPage();

    LogOutPage logOutPage = new LogOutPage();

    @Test
    public void testSuccessfulBetPlacement() throws IOException, InterruptedException {
        loginPage.cleanLogin(getPhoneNumber(),getPassword());
        betPlacementPage.cleanBetPlacement();
        By placeBetButtonLocator = By.cssSelector(util.LocatorReader.getLocator("placeBetButton"));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(placeBetButtonLocator));
        Assert.assertFalse(isElementPresent(util.LocatorReader.getLocator("placeBetButton")));
        logOutPage.cleanLogOut();

    }

    private boolean isElementPresent(String cssSelector) {
        try {

            driver.findElement(By.cssSelector(cssSelector));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}


