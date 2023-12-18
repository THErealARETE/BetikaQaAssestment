package MyBet;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LogOutPage;
import pages.LoginPage;
import pages.MyBetsPage;

import java.io.IOException;

import static util.ConfigReader.getPassword;
import static util.ConfigReader.getPhoneNumber;

public class myBetTest extends BaseTests{

        LoginPage loginPage = new LoginPage();
        MyBetsPage myBetsPage = new MyBetsPage();

        LogOutPage logOutPage = new LogOutPage();

        @Test
        public void testToNavigateToBetsPage() throws IOException, InterruptedException {
            loginPage.cleanLogin(getPhoneNumber(),getPassword());
            myBetsPage.myBets();
            Thread.sleep(7000);
            String currentUrl = driver.getCurrentUrl();
            System.out.println(currentUrl);
            String expectedSubstring = "/b/M";
            Assert.assertTrue(currentUrl.contains(expectedSubstring));
            logOutPage.cleanLogOut();

        }

}
