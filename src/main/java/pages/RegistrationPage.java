package pages;

import controller.Controller;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class RegistrationPage extends Controller {

        private void clickNavigateRegisterButton() {
            waitForVisibilityOfElementByLinkText(util.LocatorReader.getLocator("navigateToRegister")).click();
        }

        private void setPhoneNumber(String phoneNumber) {
            waitForVisibilityOfElementByCssSelector(util.LocatorReader.getLocator("phoneNumberField")).sendKeys(phoneNumber);
        }

        private void setPassword(String password) {
            waitForVisibilityOfElementByXPath(util.LocatorReader.getLocator("registerPassword")).sendKeys(password);
        }

        private void setConfirmPassword(String password) {
            waitForVisibilityOfElementByXPath(util.LocatorReader.getLocator("registerConfirmPassword")).sendKeys(password);
        }

        private void clickCheckBox() {
            waitForVisibilityOfElementByXPath(util.LocatorReader.getLocator("checkBox")).click();
        }

        private void clickRegisterButton() {
            waitForVisibilityOfElementByCssSelector(util.LocatorReader.getLocator("registerButton")).click();
        }

        public void registeration(String phoneNumber, String password) throws IOException {
            openPage();
            clickNavigateRegisterButton();
            setPhoneNumber(phoneNumber);
            setPassword(password);
            setConfirmPassword(password);
            clickCheckBox();
            clickRegisterButton();
        }

//    public WebElement getVerificationText() {
//        return waitForVisibilityOfElementByCssSelector(util.LocatorReader.getLocator("verificationNotification"));
//    }
}


