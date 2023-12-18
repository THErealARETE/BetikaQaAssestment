package pages;

import controller.Controller;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class LoginPage extends Controller {

    private void clickNavigateLoginButton() {
         waitForVisibilityOfElementByLinkText(util.LocatorReader.getLocator("navigateToLogin")).click();
    }

    private void setPhoneNumber(String phoneNumber) {
        waitForVisibilityOfElementByCssSelector(util.LocatorReader.getLocator("phoneNumberField")).sendKeys(phoneNumber);
    }

    private void setPassword(String password) {
        waitForVisibilityOfElementByCssSelector(util.LocatorReader.getLocator("passwordField")).sendKeys(password);
    }

    private void clickLoginButton() {
        waitForVisibilityOfElementByCssSelectorToBeClickable(util.LocatorReader.getLocator("loginButton")).click();
    }

    public void cleanLogin(String phoneNumber, String password) throws IOException {
        openPage();
        clickNavigateLoginButton();
        setPhoneNumber(String.valueOf(phoneNumber));
        setPassword(String.valueOf(password));
        clickLoginButton();
    }

    public WebElement getDepositText() {
        return waitForVisibilityOfElementByCssSelector(util.LocatorReader.getLocator("depositButton"));
    }

}
