package MyBet;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BetPlacementPage;
import pages.LoginPage;
import pages.MyBetsPage;

import java.io.IOException;

public class myBetTest extends BaseTests{

        LoginPage loginPage = new LoginPage();
        MyBetsPage myBetsPage = new MyBetsPage();

        @Test
        public void testToNavigateToBetsPage() throws IOException {
            loginPage.cleanLogin(util.ConfigReader.getProperty("phoneNumber"), util.ConfigReader.getProperty("password"));
            myBetsPage.myBets();
            String currentUrl = driver.getCurrentUrl();
            String expectedSubstring = "/b/M";
            Assert.assertTrue(currentUrl.contains(expectedSubstring));
        }

}
