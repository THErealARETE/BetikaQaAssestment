package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class BasePage {

    // this is our base test covering components common to the whole suite
    protected static WebDriver driver;
    private static WebDriverWait wait;


    public static void initWebDriver() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        ChromeOptions
                options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");


        new ChromeDriver(options);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,  Duration.ofSeconds(50));

    }

    public void quitWebDriver() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }



    protected WebElement waitForVisibilityOfElementByXPath(String xpath) {
        By
                locator = By.xpath(xpath);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    protected WebElement waitForVisibilityOfElementByCssSelector(String cssSelector) {
        By locator = By.cssSelector(cssSelector);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    protected List<WebElement> waitForVisibilityOfElementsByCssSelector(String cssSelector) {
        By locator = By.cssSelector(cssSelector);
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }
    protected WebElement waitForVisibilityOfElementByLinkText(String linkText) {
        By locator = By.linkText(linkText);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public WebElement waitUntilElementClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

}