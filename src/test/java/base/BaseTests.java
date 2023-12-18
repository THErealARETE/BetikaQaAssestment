package base;


import org.testng.annotations.*;



public class BaseTests extends BasePage {
    @BeforeTest
    public void beforeTest() {
        initWebDriver();

    }

    @AfterTest
    public void afterTest() {
        driver.manage().deleteAllCookies();
        quitWebDriver();
    }



}
